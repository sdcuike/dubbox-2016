#!/bin/bash

currentDir=$(pwd)
echo currentDir $currentDir

cd ..
deployDir=$(pwd)
echo deployDir $deployDir

echo dubbo services are starting...
echo JAVA_HOME:$JAVA_HOME


########### beign服务启动了吗(避免重复启动)
PIDS=$( ps -f | grep java | grep "$deployDir" |awk '{print $2}' )
if [ -n "$PIDS" ]; then
    echo "ERROR: The $deployDir already have server started!"
    echo "PID: $PIDS"
    exit 1
fi
###########end

####jvm参数设置
JAVA_OPTS=" -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true "

JAVA_DEBUG_OPTS=""
if [ "$1" = "debug" ]; then
    JAVA_DEBUG_OPTS=" -Xdebug -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=y  "
fi

 

JAVA_MEM_OPTS=""
BITS=`java -version 2>&1 | grep -i 64-bit`
if [ -n "$BITS" ]; then
    JAVA_MEM_OPTS=" -server -Xmx2g -Xms2g -Xmn256m   -Xss256k -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled   -XX:LargePageSizeInBytes=128m -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 "
else
    JAVA_MEM_OPTS=" -server -Xms1g -Xmx1g   -XX:SurvivorRatio=2 -XX:+UseParallelGC "
fi

######
#-Dspring.profiles.active=prod/dev/test

if [ "$1" = "debug" ]; then
    java -Dspring.profiles.active=prod   $JAVA_OPTS $JAVA_MEM_OPTS $JAVA_DEBUG_OPTS    -classpath  $deployDir/config:$deployDir/lib/* com.alibaba.dubbo.container.Main   
    
else
    nohup java -Dspring.profiles.active=prod   $JAVA_OPTS $JAVA_MEM_OPTS    -classpath  $deployDir/config:$deployDir/lib/* com.alibaba.dubbo.container.Main  >& /dev/null   &
fi


echo $! > bin/service.pid