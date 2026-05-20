#!/bin/bash
#
# 告警消息推送服务 - 启动脚本
# 用法:
#   bash start.sh start    启动服务
#   bash start.sh stop     停止服务
#   bash start.sh restart  重启服务
#   bash start.sh status   查看状态
#

APP_NAME="text"
JAR_FILE="text.jar"
JAVA_HOME="${JAVA_HOME:-/usr/local/jdk1.8}"
JAVA_OPTS="-Xms256m -Xmx512m"

# 获取脚本所在目录
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
cd "$SCRIPT_DIR"

PID_FILE="$SCRIPT_DIR/app.pid"
LOG_FILE="$SCRIPT_DIR/logs/app.log"

# 确保日志目录存在
mkdir -p "$SCRIPT_DIR/logs"

start() {
    if [ -f "$PID_FILE" ]; then
        pid=$(cat "$PID_FILE")
        if ps -p "$pid" > /dev/null 2>&1; then
            echo "$APP_NAME 已在运行 (PID: $pid)"
            return 1
        fi
    fi

    echo "启动 $APP_NAME ..."
    nohup "$JAVA_HOME/bin/java" $JAVA_OPTS -jar "$JAR_FILE" > "$LOG_FILE" 2>&1 &
    echo $! > "$PID_FILE"
    echo "$APP_NAME 已启动 (PID: $(cat $PID_FILE))"
}

stop() {
    if [ ! -f "$PID_FILE" ]; then
        echo "$APP_NAME 未运行"
        return 1
    fi

    pid=$(cat "$PID_FILE")
    echo "停止 $APP_NAME (PID: $pid) ..."
    kill "$pid"
    sleep 3

    if ps -p "$pid" > /dev/null 2>&1; then
        echo "强制停止..."
        kill -9 "$pid"
    fi

    rm -f "$PID_FILE"
    echo "$APP_NAME 已停止"
}

status() {
    if [ -f "$PID_FILE" ]; then
        pid=$(cat "$PID_FILE")
        if ps -p "$pid" > /dev/null 2>&1; then
            echo "$APP_NAME 运行中 (PID: $pid)"
            return 0
        fi
    fi
    echo "$APP_NAME 未运行"
}

case "$1" in
    start)
        start
        ;;
    stop)
        stop
        ;;
    restart)
        stop
        sleep 2
        start
        ;;
    status)
        status
        ;;
    *)
        echo "用法: $0 {start|stop|restart|status}"
        exit 1
        ;;
esac
