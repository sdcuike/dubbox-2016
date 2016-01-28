#!/bin/bash

currentDir=$(pwd)
echo currentDir $currentDir

cd ..
deployDir=$(pwd)
echo deployDir $deployDir

echo dubbo services are starting...
echo JAVA_HOME:$JAVA_HOME
echo PATH:$PATH


########### beign服务启动了吗(避免重复启动)
PIDS=$( ps -f | grep java | grep "$deployDir" |awk '{print $2}' )
if [ -n "$PIDS" ]; then
    echo "ERROR: The $deployDir already have server started!"
    echo "PID: $PIDS"
    exit 1
fi
###########end


nohup java    -classpath  $deployDir/config/*:$deployDir/lib/* com.alibaba.dubbo.container.Main  >& /dev/null   &

echo $! > bin/service.pid