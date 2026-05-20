package com.test.controller;

import com.test.service.AlarmMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alarm")
public class AlarmController {

    private final AlarmMessageService alarmMessageService;

    public AlarmController(AlarmMessageService alarmMessageService) {
        this.alarmMessageService = alarmMessageService;
    }

    /**
     * 手动触发发送所有消息
     */
    @GetMapping("/send")
    public String send() {
        alarmMessageService.sendAllMessages();
        return "消息发送完成，请查看日志";
    }

    /**
     * 列出消息目录中的所有文件
     */
    @GetMapping("/list")
    public List<String> list() {
        return alarmMessageService.listMessageFiles();
    }
}
