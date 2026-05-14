package com.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.test.entity.Teasd;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Properties;

@RestController
@RequestMapping("/ddd")
public class TestController {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    KafkaProducer<String, String> producer = null;

    @Value("${tp_alarm_event_addr:}")
    private String tp_alarm_event_addr;

    @Value("${jh_alarm_event_addr:}")
    private String jh_alarm_event_addr;

    @Value("${kafka.addr:}")
    private String kafkaaddr;
    @Value("${kafka.topic:}")
    private String topic;
    @Value("${kafka.config:}")
    private String config;




    @RequestMapping(value = "/ssss", method = RequestMethod.GET)
    public void userRoleList(Integer ss) {
        String nowTime = LocalDateTime.now().format(FORMATTER);
        String regex = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";

        Properties props = new Properties();
        props.put("bootstrap.servers", kafkaaddr);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        if (StringUtils.isNotEmpty(config)){
            props.put("security.protocol", "SASL_PLAINTEXT");
            props.put("sasl.mechanism", "SCRAM-SHA-512");
            props.put("sasl.jaas.config", config);
        }
        // 创建生产者实例
        if (producer==null){
            producer = new KafkaProducer<>(props);
        }

        //解析文件
        // try{
        //     FileInputStream fileInputStream = new FileInputStream(new File(tp_alarm_event_addr));
        //     Workbook sheets = WorkbookFactory.create(fileInputStream);
        //     Sheet sheet = sheets.getSheetAt(0);
        //     for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
        //         Row row = sheet.getRow(rowIndex);
        //         Cell cell = row.getCell(38);
        //         cell.setCellType(CellType.STRING);
        //         String stringCellValue = cell.getStringCellValue();
        //         if (Objects.equals(stringCellValue, "Alarm.FollowRootList")
        //                 ||Objects.equals(stringCellValue, "AlarmStatusChange.AlarmRelation")
        //                 ||Objects.equals(stringCellValue, "Alarm.Worksheet")){
        //             Cell cell1 = row.getCell(138);
        //             if (cell1!=null){
        //                 cell1.setCellType(CellType.STRING);
        //                 String content = cell1.getStringCellValue();
        //                 if (StringUtils.isEmpty( content)){
        //                     continue;
        //                 }
        //                 content.replaceAll(regex, nowTime);
        //                 ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, content);
        //                 producer.send(producerRecord);
        //             }
        //         }
        //     }
        // }catch (Exception e){
        //     e.printStackTrace();
        // }

        try{
            FileInputStream fileInputStream = new FileInputStream(new File(jh_alarm_event_addr));
            Workbook sheets = WorkbookFactory.create(fileInputStream);
            Sheet sheet = sheets.getSheetAt(1);

            Row row1 = sheet.getRow(0);
            int i=0;
            while (true){
                Cell cell = row1.getCell(i);
                if(cell==null){
                    continue;
                }
                cell.setCellType(CellType.STRING);
                String stringCellValue = cell.getStringCellValue();
                if (Objects.equals(stringCellValue, "content")){
                    break;
                }
                i++;
            }

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                Cell cell = row.getCell(i);
                if (cell==null){
                    continue;
                }
                cell.setCellType(CellType.STRING);
                String content = cell.getStringCellValue();
                if (StringUtils.isEmpty( content)){
                    continue;
                }
                content.replaceAll(regex, nowTime);
                ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, content);
                producer.send(producerRecord);
            }
            Sheet sheet1 = sheets.getSheetAt(2);
            Row row2 = sheet1.getRow(0);
            int j=0;
            while (true){
                Cell cell = row2.getCell(j);
                if (cell==null){
                    continue;
                }
                cell.setCellType(CellType.STRING);
                String stringCellValue = cell.getStringCellValue();
                if (Objects.equals(stringCellValue, "content")){
                    break;
                }
                j++;
            }

            for (int rowIndex = 1; rowIndex <= sheet1.getLastRowNum(); rowIndex++) {
                Row row = sheet1.getRow(rowIndex);
                Cell cell = row.getCell(j);
                if (cell==null){
                    continue;
                }
                cell.setCellType(CellType.STRING);
                String content = cell.getStringCellValue();
                if (StringUtils.isEmpty( content)){
                    continue;
                }
                content.replaceAll(regex, nowTime);
                ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, content);
                producer.send(producerRecord);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    @RequestMapping(value = "/fffffffff", method = RequestMethod.POST)
    public void defefewfefewf(@RequestBody JSONObject jsonObject, HttpServletRequest request) {
        System.out.println(request.getServletPath());
        System.out.println(request.getRequestURL());
        System.out.println(request.getRequestURI());
    }


}
