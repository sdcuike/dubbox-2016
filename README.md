# dubbox-2016
——————————————————————————————————————————


dubbo的插件集合[https://github.com/dubboclub/dubbo-plus](https://github.com/dubboclub/dubbo-plus)

——————————————————————————————————————————

 [http://dangdangdotcom.github.io/dubbox]( http://dangdangdotcom.github.io/dubbox
)
 
 
 
1. 从 [http://gitlab.qc.com/cuikexiang/dubbox/tree/dubbox-2.8.4](http://gitlab.qc.com/cuikexiang/dubbox/tree/dubbox-2.8.4) 下载此版本dubbox。

2. 安装dubbox到本地仓库：mvn clean install -Dmaven.test.skip=true
 
 
3. 下载dubbox-2016源码：执行mvn clean install -Dmaven.test.skip=true
4. copy 目录下dubbox-demo-service／target／dubbox-demo-service-1.0.0-SNAPSHOT-bin.tar 到某一目录解压
5. 安装zookeeper ，配置为单独服务器远行，执行ubbox-demo-service-1.0.0-SNAPSHOT／bin下start.sh脚本，启动dubbo服务端。
6. 找到dubbox-demo-client测试l类com.doctor.demo.service.client.impl.HelloServiceClientImplTest执行。
