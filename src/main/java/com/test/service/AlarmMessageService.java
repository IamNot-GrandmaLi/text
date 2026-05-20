package com.test.service;

import com.test.config.KafkaConfig.KafkaProperties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AlarmMessageService {

    private static final Logger log = LoggerFactory.getLogger(AlarmMessageService.class);

    private final KafkaProducer<String, String> producer;
    private final KafkaProperties kafkaProperties;

    @Value("${alarm.messages.path:./messages}")
    private String messagesPath;

    @Value("${alarm.messages.send-interval-ms:5000}")
    private long sendIntervalMs;

    public AlarmMessageService(KafkaProducer<String, String> producer, KafkaProperties kafkaProperties) {
        this.producer = producer;
        this.kafkaProperties = kafkaProperties;
    }

    /**
     * 发送消息目录中所有 .txt 文件的内容到 Kafka
     */
    public void sendAllMessages() {
        File dir = new File(messagesPath);
        if (!dir.exists() || !dir.isDirectory()) {
            log.warn("消息目录不存在: {}", dir.getAbsolutePath());
            return;
        }

        File[] files = dir.listFiles((d, name) -> name.endsWith(".txt"));
        if (files == null || files.length == 0) {
            log.warn("消息目录中没有 .txt 文件: {}", dir.getAbsolutePath());
            return;
        }

        // 按文件名排序
        Arrays.sort(files, Comparator.comparing(File::getName));

        String topic = kafkaProperties.getTopic();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (File file : files) {
            try {
                String content = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);

                // 占位符替换
                content = content.replace("${alarm_un_id}", UUID.randomUUID().toString());
                content = content.replace("${alarm_occ_time}", sdf.format(new Date()));

                ProducerRecord<String, String> record = new ProducerRecord<>(topic, content);
                producer.send(record);
                log.info("发送消息成功, 文件: {}, topic: {}", file.getName(), topic);

                Thread.sleep(sendIntervalMs);
            } catch (IOException e) {
                log.error("读取消息文件失败: {}", file.getName(), e);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("消息发送被中断");
                break;
            }
        }
        log.info("所有消息发送完成, 共 {} 条", files.length);
    }

    /**
     * 列出消息目录中的所有文件
     */
    public List<String> listMessageFiles() {
        File dir = new File(messagesPath);
        if (!dir.exists() || !dir.isDirectory()) {
            return Collections.emptyList();
        }
        File[] files = dir.listFiles((d, name) -> name.endsWith(".txt"));
        if (files == null) {
            return Collections.emptyList();
        }
        List<String> names = new ArrayList<>();
        for (File f : files) {
            names.add(f.getName());
            Collections.sort(names);
        }
        return names;
    }

    @PreDestroy
    public void close() {
        if (producer != null) {
            producer.close();
            log.info("Kafka 生产者已关闭");
        }
    }
}
