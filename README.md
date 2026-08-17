# 告警消息推送服务

Spring Boot 应用，从本地文件目录读取告警消息（`.txt`），替换占位符后推送到 Kafka。
## 技术栈

- Java 8
- Spring Boot 2.5.3
- Kafka Clients 2.8.0（原生客户端，非 spring-kafka）
- Maven

## 项目结构

```
text/
├── pom.xml
├── start.sh                          # 启停脚本
├── messages/                         # 告警消息文件目录
│   ├── 事件入库.txt
│   └── 告警入库.txt
├── messages_m/                       # 备用消息文件目录
│   ├── alarm-03.txt
│   └── alarm-04.txt
└── src/main/
    ├── java/com/test/
    │   ├── AlarmApplication.java     # 启动类（启动后自动发送一轮消息）
    │   ├── config/
    │   │   └── KafkaConfig.java      # Kafka 连接配置
    │   ├── controller/
    │   │   └── AlarmController.java  # REST 接口
    │   └── service/
    │       └── AlarmMessageService.java  # 消息读取与发送服务
    └── resources/
        ├── application.yml           # 应用配置
        └── logback-spring.xml        # 日志配置
```

## 配置说明

所有配置在 `src/main/resources/application.yml`：

| 配置项 | 默认值 | 说明 |
|---|---|---|
| `server.port` | `9095` | 服务端口 |
| `alarm.messages.path` | `./messages` | 消息文件目录（相对或绝对路径） |
| `alarm.messages.send-interval-ms` | `5000` | 每条消息发送间隔（毫秒） |
| `alarm.kafka.bootstrap-servers` | `localhost:9092` | Kafka 地址 |
| `alarm.kafka.topic` | `alarm_message` | 目标 Topic |
| `alarm.kafka.sasl-enabled` | `false` | 是否开启 SASL 认证 |
| `alarm.kafka.sasl-jaas-config` | （空） | SASL JAAS 配置字符串 |

### SASL 认证

当 Kafka 集群开启 SCRAM-SHA-512 认证时：

```yaml
alarm:
  kafka:
    sasl-enabled: true
    sasl-jaas-config: 'org.apache.kafka.common.security.scram.ScramLoginModule required username="用户名" password="密码";'
```

## 消息文件格式

`.txt` 文件内容为键值对格式，例如：

```
<AlarmStart>
id:1656691
alarm_un_id:91074197466928481113
ne_name:设备名称
ne_ip:10.0.0.1
alarm_occ_time:2026-06-23 00:00:01
...
```

支持以下占位符，发送时自动替换：

| 占位符 | 替换值 |
|---|---|
| `${alarm_un_id}` | 随机 UUID |
| `${alarm_occ_time}` | 当前时间 `yyyy-MM-dd HH:mm:ss` |

## API 接口

### 手动触发发送

```http
GET /alarm/send
```

读取 `messages/` 目录下所有 `.txt` 文件（按文件名排序），依次发送到 Kafka。

### 列出消息文件

```http
GET /alarm/list
```

返回 `messages/` 目录下所有 `.txt` 文件名列表。

## 构建与运行

### 构建

```bash
mvn clean package -DskipTests
```

输出 jar 在 `target/lib/text.jar`。

### 运行

```bash
java -jar target/lib/text.jar
```

启动后会自动发送 `messages/` 目录下的消息。也可以使用 `start.sh`：

```bash
bash start.sh start     # 启动
bash start.sh stop      # 停止
bash start.sh restart   # 重启
bash start.sh status    # 查看状态
```