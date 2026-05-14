package com.test.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.text.SimpleDateFormat;
import java.util.*;

@Data
public class Teasd {
    private Integer sss;

    public static void main(String[] args) throws InterruptedException {
        KafkaProducer<String, String> producer = null;
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // 创建生产者实例
        producer = new KafkaProducer<>(props);
        List<String> list = new ArrayList<>();
        // 告警消息
        list.add("<AlarmStart>\n" +
                "alarm_un_id:${alarm_un_id}\n" +
                "alarm_un_Clear_Id:913525726381853278332\n" +
                "ne_id:3243532036752864301\n" +
                "ne_name:4AGFCX-广丰西桥-31026-7CE5810\n" +
                "ne_alias:\n" +
                "ne_ip:10.0.0.3\n" +
                "alarm_source:\n" +
                "facility_type:ENODEB\n" +
                "factory_id:华为\n" +
                "ne_version:\n" +
                "alarm_loc_obj:4AGFCX-广丰西桥-31026-7CE5810\n" +
                "alarm_loc_obj_type:ENODEB\n" +
                "alarm_obj_status:1300\n" +
                "alarm_obj_seg_status:\n" +
                "location_info:网元名称:4AGFCX-广丰西桥-31026-7CE5810; 网元IP地址:10.0.0.3; 网元IP地址(IP Mode):NULL; 断连端口:6007; 断连错误码:N/A; 断连信息:供电状态可能异常; 适配层分区:MediationService0906; OMC IP:10.0.0.4\n" +
                "alarm_occ_time:${alarm_occ_time}\n" +
                "alarm_clear_time:2026-04-08 20:46:34\n" +
                "alarm_detection_time:2026-04-08 20:49:45\n" +
                "factory_alarm_type:网管内部\n" +
                "factory_alarm_level:1\n" +
                "nms_alarm_level:2\n" +
                "factory_alarm_id:40012\n" +
                "nms_alarm_id:0103-000-006-61-800001\n" +
                "alarm_clear_status:1\n" +
                "alarm_confirm_status:0\n" +
                "alarm_confirm_time:\n" +
                "alarm_confirmor_name:\n" +
                "alarm_title:[衍生告警]同一区县同时中断5个以上LTE基站\n" +
                "an_event_name:同一区县同时中断5个以上LTE基站\n" +
                "alarm_standard_name:网元连接中断\n" +
                "alarm_reason:\n" +
                "alarm_text:{\"addInfo\":\"断连端口:6007; 断连错误码:N/A; 断连信息:端口握手超时; 适配层分区:MediationService0906; OMC IP:10.0.0.4; 原因:MAE与网元之间的网络中断超过3分钟; 建议:请单击该告警的“产生原因和修复建议”超链接字段;打开帮助资料根据建议处理; eNodeBId:511576; deployment:NSA\",\"alarmId\":\"185501039\",\"alarmSeq\":81590607,\"alarmStatus\":1,\"alarmTitle\":\"网元连接中断\",\"alarmType\":\"网管内部\",\"eventTime\":\"2026-04-08 20:46:34\",\"locationInfo\":\"网元名称:4AGFCX-广丰西桥-31026-7CE5810; 网元IP地址:10.0.0.3; 网元IP地址(IP Mode):NULL; 断连端口:6007; 断连错误码:N/A; 断连信息:供电状态可能异常; 适配层分区:MediationService0906; OMC IP:10.0.0.4\",\"neName\":\"4AGFCX-广丰西桥-31026-7CE5810\",\"neType\":\"ENB\",\"neUID\":\"3600HWWXCMNE1073758469\",\"objectName\":\"4AGFCX-广丰西桥-31026-7CE5810\",\"objectType\":\"EnbFunction\",\"objectUID\":\"3600HWWXCENB6003221309213\",\"origSeverity\":1,\"rNeName\":\"\",\"rNeType\":\"\",\"rNeUID\":\"\",\"specificProblem\":\"718\",\"specificProblemID\":\"40012\"}是否上报隐患：是隐患1：专业：动环，隐患流水号：上报后生成，隐患名称：蓄电池续航能力不足，隐患是否已解决：\n" +
                "subject:\n" +
                "alarm_logic_class:操作维护\n" +
                "alarm_logic_subclass:\n" +
                "affect_device:可能设备全阻\n" +
                "affec_business:可能业务受影响\n" +
                "alarm_type:8201\n" +
                "is_report_group:1\n" +
                "prov_zhname:江西省\n" +
                "city_zhname:上饶地区\n" +
                "county_zhname:广丰县\n" +
                "omc_id:36010807\n" +
                "special_field1:\n" +
                "room_name:上饶市广丰县西桥站点5楼无线机房\n" +
                "sub_alarm_type:普通群障\n" +
                "link_onu_num:\n" +
                "home_client_num:46\n" +
                "redefine_type:非VIP\n" +
                "special_field17:广丰县-广丰西桥-HLH\n" +
                "alarm_resource_status:现网状态\n" +
                "special_field0:网元名称:4AGFCX-广丰西桥-31026-7CE5810; 网元IP地址:10.0.0.3; 网元IP地址(IP Mode):NULL; 断连端口:6007; 断连错误码:N/A; 断连信息:供电状态可能异常; 适配层分区:MediationService0906; OMC IP:10.0.0.4\n" +
                "rru_num:3\n" +
                "special_field6:非VIP\n" +
                "network_type_top:家宽\n" +
                "network_type:4G\n" +
                "township:永丰街道\n" +
                "ne_sub_type:\n" +
                "special_field2:\n" +
                "special_field3:\n" +
                "special_field4:\n" +
                "special_field5:\n" +
                "special_field7:1\n" +
                "special_field8:城区道路\n" +
                "special_field9:其他\n" +
                "special_field10:上饶市广丰县西桥站点5楼无线机房\n" +
                "special_field15:511576\n" +
                "special_field16:上饶市广丰县西桥站点5楼无线机房\n" +
                "gcss_service_level:\n" +
                "gcss_service_num:\n" +
                "gcss_service:\n" +
                "gcss_service_type:\n" +
                "gcss_client_name:\n" +
                "gcss_client:\n" +
                "service_crossdomain_type:\n" +
                "redefine_severity:2\n" +
                "business_system:\n" +
                "additional_related_cm_info:\n" +
                "extra_string2:\n" +
                "extra_string1:\n" +
                "business_region_ids:\n" +
                "special_field12:移交铁塔\n" +
                "outserv_reason:2\n" +
                "proj_name:\n" +
                "proj_eoms_id:\n" +
                "is_pivotal_alarm:是\n" +
                "ne_uid:3600HWWXCENB6003221309213\n" +
                "zz_ne_cname:广丰县-广丰西桥-HLH\n" +
                "site_name:\n" +
                "site_id:\n" +
                "machroom_id:475130\n" +
                "worksheet_level:二级响应\n" +
                "jt_event_type:401\n" +
                "event_id:4165008784\n" +
                "jt_event_id:WLSJ-YW-H-01-10-0001\n" +
                "jt_event_level:四级事件\n" +
                "db_event_time:\n" +
                "db_clear_time:\n" +
                "locate_ne_id:3243532036752864301\n" +
                "ne_type:ENODEB\n" +
                "site_type:\n" +
                "remote_eqp_label:\n" +
                "remote_ne_mark:\n" +
                "tower_room:\n" +
                "proj_start_time:\n" +
                "proj_end_time:\n" +
                "remote_object_class:\n" +
                "remote_ne_id:\n" +
                "remote_ne_provice:\n" +
                "remote_ne_projstatus:\n" +
                "remote_ne_port_name:\n" +
                "remote_ne_port_id:\n" +
                "ne_group_id:\n" +
                "ems_id:\n" +
                "locate_ne_type_l:\n" +
                "gcss_client_level:\n" +
                "worksheet_role_id:8a2f94ee419ea67f0141b677b4c605ad\n" +
                "<AlarmEnd>");
        list.add("<AlarmStart>\n" +
                "alarm_un_id:${alarm_un_id}\n" +
                "alarm_un_Clear_Id:917156921818358435461\n" +
                "ne_id:15416273756007139109\n" +
                "ne_name:西桥\n" +
                "ne_alias:上饶市广丰县西桥站点5楼无线机房\n" +
                "ne_ip:\n" +
                "alarm_source:\n" +
                "facility_type:铁塔动环\n" +
                "factory_id:中国铁塔\n" +
                "ne_version:\n" +
                "alarm_loc_obj:西桥/机房1/开关电源10\n" +
                "alarm_loc_obj_type:铁塔动环\n" +
                "alarm_obj_status:1300\n" +
                "alarm_obj_seg_status:\n" +
                "location_info:西桥/机房1/开关电源10\n" +
                "alarm_occ_time:${alarm_occ_time}\n" +
                "alarm_clear_time:2026-04-08 19:45:10\n" +
                "alarm_detection_time:2026-04-08 19:45:30\n" +
                "factory_alarm_type:\n" +
                "factory_alarm_level:三级告警\n" +
                "nms_alarm_level:2\n" +
                "factory_alarm_id:0406016001\n" +
                "nms_alarm_id:0500-099-000-10-800223\n" +
                "alarm_clear_status:1\n" +
                "alarm_confirm_status:0\n" +
                "alarm_confirm_time:\n" +
                "alarm_confirmor_name:\n" +
                "alarm_title:铁塔机房市电停电\n" +
                "an_event_name:铁塔机房市电停电\n" +
                "alarm_standard_name:交流输入1#停电告警\n" +
                "alarm_reason:\n" +
                "alarm_text:<Alarm><ProvinceName>江西省</ProvinceName><CityName>上饶市</CityName><NeName>西桥</NeName><NeID>36112200000469</NeID><ResID>361122908000000136</ResID><RoomId>36112200000469/ZLF01</RoomId><ResRoomId>003602050200000039234198</ResRoomId><AlarmUniqueId>4E941BBF7A135E63E06354801DAC7333</AlarmUniqueId><SignalId>0406016001</SignalId><DeviceType>开关电源</DeviceType><DeviceName>西桥/机房1/开关电源10</DeviceName><DeviceId>36112240600362</DeviceId><AlarmTitle>交流输入停电告警</AlarmTitle><EventTime>2026-04-08 19:45:10</EventTime><ClearTime></ClearTime><AlarmCancelStatus>0</AlarmCancelStatus><AlarmSendStatus>1</AlarmSendStatus><AlarmEngineerStatus>0</AlarmEngineerStatus></Alarm>机房所带业务及设备情况如下：BTS：广丰西桥ENODEB：4AGFCX-广丰西桥-31026-7CE5810、8FGFCX-广丰特警食堂-31026-AF4D79-FDD、9FGFNX-广丰人寿保险公司对面-31026-1F8AA79-FDDGNODEB： OLT： 是否上报隐患：是隐患1：专业：动环，隐患流水号：上报后生成，隐患名称：蓄电池续航能力不足，隐患是否已解决：\n" +
                "subject:1102\n" +
                "alarm_logic_class:系统告警\n" +
                "alarm_logic_subclass:系统告警\n" +
                "affect_device:无影响\n" +
                "affec_business:无影响\n" +
                "alarm_type:8201\n" +
                "is_report_group:0\n" +
                "prov_zhname:江西省\n" +
                "city_zhname:上饶地区\n" +
                "county_zhname:广丰县\n" +
                "omc_id:360519001\n" +
                "special_field1:\n" +
                "room_name:上饶市广丰县西桥站点5楼无线机房\n" +
                "sub_alarm_type:交流电停电\n" +
                "link_onu_num:\n" +
                "home_client_num:\n" +
                "redefine_type:通信基站\n" +
                "special_field17:上饶市广丰县西桥站点5楼无线机房\n" +
                "alarm_resource_status:现网状态\n" +
                "special_field0:西桥/机房1/开关电源10\n" +
                "rru_num:\n" +
                "special_field6:通信基站\n" +
                "network_type_top:动环\n" +
                "network_type:动环\n" +
                "township:永丰街道\n" +
                "ne_sub_type:1102\n" +
                "special_field2:361122908000000136\n" +
                "special_field3:\n" +
                "special_field4:\n" +
                "special_field5:\n" +
                "special_field7:\n" +
                "special_field8:\n" +
                "special_field9:\n" +
                "special_field10:上饶市广丰县西桥站点5楼无线机房\n" +
                "special_field15:\n" +
                "special_field16:上饶市广丰县西桥站点5楼无线机房\n" +
                "gcss_service_level:\n" +
                "gcss_service_num:\n" +
                "gcss_service:\n" +
                "gcss_service_type:\n" +
                "gcss_client_name:\n" +
                "gcss_client:\n" +
                "service_crossdomain_type:\n" +
                "redefine_severity:2\n" +
                "business_system:\n" +
                "additional_related_cm_info:\n" +
                "extra_string2:BTS：广丰西桥\n" +
                "ENODEB：4AGFCX-广丰西桥-31026-7CE5810、8FGFCX-广丰特警食堂-31026-AF4D79-FDD、9FGFNX-广丰人寿保险公司对面-31026-1F8AA79-FDD\n" +
                "GNODEB： \n" +
                "OLT： \n" +
                "extra_string1:\n" +
                "business_region_ids:\n" +
                "special_field12:铁塔\n" +
                "outserv_reason:\n" +
                "proj_name:\n" +
                "proj_eoms_id:\n" +
                "is_pivotal_alarm:是\n" +
                "ne_uid:003602050200000039234198\n" +
                "zz_ne_cname:上饶市广丰县西桥站点5楼无线机房\n" +
                "site_name:\n" +
                "site_id:473970\n" +
                "machroom_id:\n" +
                "worksheet_level:二级响应\n" +
                "jt_event_type:401\n" +
                "event_id:514460785\n" +
                "jt_event_id:WLSJ-WL-DH-04-80-0101\n" +
                "jt_event_level:四级事件\n" +
                "db_event_time:\n" +
                "db_clear_time:\n" +
                "locate_ne_id:6074191056028739459\n" +
                "ne_type:铁塔动环\n" +
                "site_type:\n" +
                "remote_eqp_label:\n" +
                "remote_ne_mark:\n" +
                "tower_room:003602050200000039234198\n" +
                "proj_start_time:\n" +
                "proj_end_time:\n" +
                "remote_object_class:\n" +
                "remote_ne_id:\n" +
                "remote_ne_provice:\n" +
                "remote_ne_projstatus:\n" +
                "remote_ne_port_name:\n" +
                "remote_ne_port_id:\n" +
                "ne_group_id:\n" +
                "ems_id:\n" +
                "locate_ne_type_l:\n" +
                "gcss_client_level:\n" +
                "worksheet_role_id:\n" +
                "<AlarmEnd>");
        // 定界定位
//        list.add("<AlarmStart>\n" +
//                "alarm_type:Alarm.DelimitResult\n" +
//                "alarm_id:9276011576423138818\n" +
//                "event_time:2026-04-09 00:19:25\n" +
//                "business_effect:网络层面：\n" +
//                "1、地市高铁RRU总数：2308个，RRU真实退服30个\n" +
//                "2、退服网元：5AWYNF001-婺源溪头东溪-6448-9E6AC-L；\n" +
//                "5AWYNF002-婺源方思山隧道出口-6448-9E6AD-L；\n" +
//                "5AWYNF004-婺源晓起隧道出口-6448-9E6AF-L；\n" +
//                "3、退服明细：5AWYNF001-婺源溪头东溪-6448-9E6AC-L（下挂RRU数11）、5AWYNF002-婺源方思山隧道出口-6448-9E6AD-L（下挂RRU数10）、5AWYNF004-婺源晓起隧道出口-6448-9E6AF-L（下挂RRU数9）\n" +
//                "业务层面：\n" +
//                "1、分区县情况：婺源县：30个；\n" +
//                "2、影响业务类型：4G手机上网、VoLTE通话：\n" +
//                "社会层面：\n" +
//                "1、：当前无投诉告警。\n" +
//                "2、相关舆情新闻：无：\n" +
//                "delimit_result:主要原因为动环故障\n" +
//                "event_delimit:1、RRU退服核对：真实退服30个；\n" +
//                "2、工程信息核查：经核查，故障网元近期无工程割接记录。\n" +
//                "3、机房动环故障核查：经核查，故障网元所在机房不存在动环告警。\n" +
//                "4、自身动环故障核查：初步核实网元存在动环异常告警，存在动环故障。5AWYNF002-婺源方思山隧道出口-6448-9E6AD-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF001-婺源溪头东溪-6448-9E6AC-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF002-婺源方思山隧道出口-6448-9E6AD-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF004-婺源晓起隧道出口-6448-9E6AF-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF001-婺源溪头东溪-6448-9E6AC-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF001-婺源溪头东溪-6448-9E6AC-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF001-婺源溪头东溪-6448-9E6AC-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF001-婺源溪头东溪-6448-9E6AC-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF002-婺源方思山隧道出口-6448-9E6AD-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF004-婺源晓起隧道出口-6448-9E6AF-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF002-婺源方思山隧道出口-6448-9E6AD-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF004-婺源晓起隧道出口-6448-9E6AF-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF004-婺源晓起隧道出口-6448-9E6AF-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF004-婺源晓起隧道出口-6448-9E6AF-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF001-婺源溪头东溪-6448-9E6AC-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF001-婺源溪头东溪-6448-9E6AC-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF002-婺源方思山隧道出口-6448-9E6AD-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF002-婺源方思山隧道出口-6448-9E6AD-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF001-婺源溪头东溪-6448-9E6AC-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF002-婺源方思山隧道出口-6448-9E6AD-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF004-婺源晓起隧道出口-6448-9E6AF-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF004-婺源晓起隧道出口-6448-9E6AF-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF002-婺源方思山隧道出口-6448-9E6AD-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF004-婺源晓起隧道出口-6448-9E6AF-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF004-婺源晓起隧道出口-6448-9E6AF-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF001-婺源溪头东溪-6448-9E6AC-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF002-婺源方思山隧道出口-6448-9E6AD-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF002-婺源方思山隧道出口-6448-9E6AD-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF001-婺源溪头东溪-6448-9E6AC-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5AWYNF001-婺源溪头东溪-6448-9E6AC-L-2026-04-09 00:18:02-射频单元交流掉电告警\n" +
//                "5、传输故障核查：初步核实设备上联链路运行正常。\n" +
//                "6、无线故障核查：初步核实设备无无线类告警。\n" +
//                "7、其他原因：对于未匹配到上述规则的退服，基于历史数据判断可能原因。：\n" +
//                "event_expound:主要原因为：动环故障，退服RRU数：30，动力原因导致RRU退服数量：30，占比：100%，传输原因导致RRU退服数量：0，占比：0%，无线设备原因导致RRU退服数量：0，占比：0%\n" +
//                "event_pretreatment:\n" +
//                "trigger_major:101\n" +
//                "trigger_ne_name:5AWYNF001-婺源溪头东溪-6448-9E6AC-L,5AWYNF004-婺源晓起隧道出口-6448-9E6AF-L,5AWYNF002-婺源方思山隧道出口-6448-9E6AD-L\n" +
//                "root_major:动环\n" +
//                "root_ne_name:5AWYNF001-婺源溪头东溪-6448-9E6AC-L,5AWYNF004-婺源晓起隧道出口-6448-9E6AF-L,5AWYNF002-婺源方思山隧道出口-6448-9E6AD-L\n" +
//                "major_1st:无线接入网\n" +
//                "major_2st:\n" +
//                "<AlarmEnd>");
//        list.add("<AlarmStart>\n" +
//                "alarm_type:Alarm.DelimitResult\n" +
//                "alarm_id:93884321002395823564\n" +
//                "event_time:2026-04-08 23:53:26\n" +
//                "business_effect:一、网络层面：故障OLT 1个；下挂ONU3705个。\n" +
//                ">>>：上饶-德兴市银城镇移动新大楼汇聚机房-OLT027-Z-ZX-C600共4个PON口中断\n" +
//                "二、业务层面：\n" +
//                "1：覆盖家客用户222个（其中重要家客用户数：；）\n" +
//                ">>>：上饶-德兴市银城镇移动新大楼汇聚机房-OLT027-Z-ZX-C600共4个PON口中断，影响222个用户数退服\n" +
//                "2：覆盖小区1个（小区详情：丽都嘉苑；）\n" +
//                "3：影响政企客户1个（影响政企客户详情：德兴市新营街道办事处；）\n" +
//                "4：涉及专线1条（影响专线详情：99382515876；）\n" +
//                "三、社会层面：\n" +
//                "1：当前投诉量：0\n" +
//                "2：投诉预警信息：0\n" +
//                "3：相关舆情新闻：未查询到舆情预警。\n" +
//                "业务影响分析：\n" +
//                "delimit_result:<PON口中断故障>初步判断为主干光缆中断导致。\n" +
//                "event_delimit:<PON口中断故障>：一、影响用户排查：变化趋势详见“OLT在线用户数”性能分析视图。\n" +
//                ">>>：网元名称：上饶-德兴市银城镇移动新大楼汇聚机房-OLT027-Z-ZX-C600，指标时间：2026-04-08 23:45:00，家宽在线用户数：2935，指标时间：2026-04-08 23:50:00，家宽在线用户数：2916；\n" +
//                "二、工程排查：经核查，故障网元近期无工程割接记录。\n" +
//                "三、传输故障排查：共光缆段名称：上饶德兴市移动新大楼站点7楼综合机房_丽都嘉苑；\n" +
//                "共光缆段名称：上饶德兴市移动新大楼站点7楼综合机房_丽都嘉苑；\n" +
//                "共光缆段名称：上饶德兴市移动新大楼站点7楼综合机房_丽都嘉苑；\n" +
//                "共光缆段名称：上饶德兴市移动新大楼站点7楼综合机房_丽都嘉苑；\n" +
//                "event_expound:故障概述：上饶-德兴市银城镇移动新大楼汇聚机房-OLT027-Z-ZX-C600发生同一区县200个用户（含）以上的家客业务同时阻断\n" +
//                "定界定位概述：<PON口中断故障>初步判断为主干光缆中断导致。\n" +
//                "event_pretreatment:\n" +
//                "trigger_major:108\n" +
//                "trigger_ne_name:上饶-德兴市银城镇移动新大楼汇聚机房-OLT027-Z-ZX-C600\n" +
//                "root_major:家宽\n" +
//                "root_ne_name:上饶-德兴市银城镇移动新大楼汇聚机房-OLT027-Z-ZX-C600\n" +
//                "major_1st:家宽\n" +
//                "major_2st:\n" +
//                "<AlarmEnd>");

        // 手动清除告警：
//        list.add("<AlarmStart>\n" +
//                "alarm_type:Alarm.ManualClear\n" +
//                "alarm_id:98877777\n" +
//                "event_time:2026-04-08 23:53:26\n" +
//                "clear_time:2026-04-08 23:53:26\n" +
//                "<AlarmEnd>");
        // 派单消息
//        list.add("<AlarmStart>\n" +
//                "alarm_type:Alarm.Worksheet\n" +
//                "alarm_id:98877777\n" +
//                "event_time:2026-04-08 20:44:32\n" +
//                "worksheet_id:xx-78748\n" +
//                "<AlarmEnd>");
        // 关联消息
//        list.add("<AlarmStart>\n" +
//                "alarm_type:AlarmStatusChange.AlarmRelation\n" +
//                "alarm_main:912634238588970518903\n" +
//                "rule_name:\n" +
//                "alarm_child:92330673234568076742\n" +
//                "<AlarmEnd>");
//        list.add("<AlarmStart>\n" +
//                "alarm_type:AlarmStatusChange.AlarmRelation\n" +
//                "alarm_main:914741587894304445227\n" +
//                "rule_name:\n" +
//                "alarm_child:36010710727512175708\n" +
//                "<AlarmEnd>");
//        //根音消息
//        list.add("<AlarmStart>\n" +
//                "alarm_type:Alarm.FollowRootList\n" +
//                "main_alarm_id:910308073736440283362\n" +
//                "main_event_time:2026-04-09 01:16:20\n" +
//                "follow_alarm_root_list:[{\"alarm_id\":\"36049805117546085615\",\"alarm_severity\":\"1\",\"alarm_text\":\"<AlarmStart>\\nIntVersion:\\nMsgSerial:\\nAlarmUniqueId:3250117546085615\\nEmsid:JX-N31-1-P\\nPortRate:10G\\nSystemLevel:本地网\\nServiceLevel:\\nAdditionalEventType:普通告警\\nEomsNo:\\nNeId:UUID:22a1ee02-a39d-11e7-a196-38eaa7a20396\\nNeName:吉安-吉水县醪桥基站-OLT001-ZX-C300\\nNeAlias:吉安-吉水县醪桥基站-OLT001-ZX-C300\\nNeIp:\\nSystemName:直真传输综合网管\\nEquipmentClass:PON\\nVendor:中兴\\nVersion:\\nObjectClass:OLT\\nLocateNeName:吉安-吉水县醪桥基站-OLT001-ZX-C300:1-1-19-1\\nLocateNeType:端口\\nLocateNeStatus:未知状态\\nLocateNeSubStatus:UUID:a23af5dc-a39f-11e7-a196-38eaa7a20396\\nCardId:UUID:a27b931a-a39d-11e7-a196-38eaa7a20396\\nLocateInfo:2c549b0f-3663-44f8-9b96-17aa538ecbed,Rack=1,Shelf=1,Slot=19,Port=1\\nEventTime:2026-04-09 01:02:32\\nCancelTime:\\nDalTime:2026-04-09 01:02:34\\nVendorAlarmType:CommunicationAlarm\\nVendorSeverity:1\\nAlarmSeverity:3\\nVendorAlarmId:40713\\nNmsAlarmId:\\nAlarmStatus:1\\nAckFlag:0\\nAckTime:\\nAckUser:设备厂家\\nAlarmTitle:上联口链路中断\\nStandardAlarmName:\\nProbableCauseTxt:TextInfo:OLTIP=10.0.0.2,,aid=4242225,specificProblem=上联口物理线路故障，网线或者光纤脱落\\nAlarmText:上联口链路中断\\nSpecialty:3\\nAlarmLogicClass:\\nAlarmLogicSubClass:\\nEffectOnEquipment:\\nEffectOnBusiness:\\nNmsAlarmType:\\nSendGroupFlag:0\\nRelatedFlag:\\nAlarmProvince:江西省\\nAlarmRegion:吉安\\nAlarmCounty:吉水县\\nSite:\\nAlarmActCount:1\\nCorrelateAlarmFlag:\\nBusinessSystem:\\nGroupCustomer:\\nCustomerClass:\\nBusinessLevel:\\nSheetSendStatus:0\\nSheetStatus:\\nSheetNo:\\nAlarmMemo:\\nCircuitId:\\nMaintOrga:\\nProjectNo:\\nProjectName:\\nProjectStartTime:\\nProjectEndTime:\\nSiteType:\\nRate:10G\\nConnNe:\\nMac:\\nne_model:\\ntranscircuitno:\\nBusiness_Network:\\nBoardType:HUVQ\\nLayerRate:速率无关\\nAlarmCheck:\\nAlarmExplanation:TextInfo:OLTIP=10.0.0.2,,aid=4242225,specificProblem=上联口物理线路故障，网线或者光纤脱落\\nems_alarm_id:1668728391373\\nInfluenceservice:\\n<AlarmEnd>\\n\\n是否上报隐患：否\\n\",\"alarm_title\":\"上联口链路中断\",\"alarm_type\":\"1\",\"city_id\":\"360822\",\"eoms_ne_type\":\"070101\",\"event_time\":\"2026-04-09 01:02:32\",\"follow_mark_root\":1,\"follow_role_attrib_1st\":\"江西-吉安-吉水县-N-家宽-自维-N\",\"follow_root_wksht_ddlud\":\"1\",\"follow_root_wksht_op\":\"1\",\"follow_set_wksht_ddlud\":\"0\",\"follow_set_wksht_op\":\"2\",\"follow_wksht_role_type\":0,\"locate_ne_name\":\"吉安-吉水县醪桥基站-OLT001-ZX-C300-19-HUVQ-1\",\"locate_ne_type\":\"1307\",\"machroom_name\":\"吉安市吉水县醪桥4楼无线机房\",\"main_major\":\"104\",\"main_major_name\":\"传输网\",\"ne_name\":\"吉安-吉水县醪桥基站-OLT001-ZX-C300\",\"ne_type\":\"1018\",\"region_id\":\"360800\",\"standard_alarm_id\":\"0405-008-035-10-000405\",\"sub_alarm_type\":\"418\",\"sub_major\":\"10405\",\"worksheet_role_id\":\"8a2f94e947f9dc710148164315f77ed0\"}]\n" +
//                "<AlarmEnd>");
        for (String content : list) {
            // 替换消息体里的${alarm_un_id}和${alarm_occ_time}
            UUID uuid = UUID.randomUUID();
            content = content.replace("${alarm_un_id}", uuid.toString());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            content = content.replace("${alarm_occ_time}", sdf.format(new Date()));
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>("alarm_message", content);
            producer.send(producerRecord);
            System.out.println("发送消息：" + content);
            Thread.sleep(5000);
        }
    }
}
