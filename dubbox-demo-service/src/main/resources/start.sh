#!/bin/bash
echo dubbo services are starting...
echo JAVA_HOME:$JAVA_HOME
echo PATH:$PATH

nohup java -classpath  .:$CLASSPATH:../lib/* com.doctor.demo.service.boot.BootMain >& /dev/null   &

echo $! > service.pid