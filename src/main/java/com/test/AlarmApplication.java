package com.test;

import com.test.service.AlarmMessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AlarmApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlarmApplication.class, args);
    }

    /**
     * 应用启动后自动发送一轮消息
     */
    @Bean
    public CommandLineRunner startupRunner(AlarmMessageService alarmMessageService) {
        return args -> alarmMessageService.sendAllMessages();
    }
}
