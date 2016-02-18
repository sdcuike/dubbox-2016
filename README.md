# dubbox-2016
——————————————————————————————————————————


dubbo的插件集合[https://github.com/dubboclub/dubbo-plus](https://github.com/dubboclub/dubbo-plus)

dubbo服务管理以及监控系统[https://github.com/dubboclub/dubbokeeper](https://github.com/dubboclub/dubbokeeper)

——————————————————————————————————————————
 
1. 下载dubbox-2016源码：执行mvn clean install -Dmaven.test.skip=true

2. copy 目录下dubbox-demo-service／target／dubbox-demo-service-1.0.0-SNAPSHOT-bin.tar 到某一目录解压

3. 安装zookeeper ，配置为单独服务器远行。

4.执行dubbox-demo-service-1.0.0-SNAPSHOT／bin下start.sh脚本，启动dubbo服务端(或执行dubbox-demo-service下的test下的com.doctor.demo.service.impl.com.doctor.demo.service.impl)。

5. 找到dubbox-demo-client测试l类com.doctor.demo.service.client.impl.HelloServiceClientImplTest执行。

6.dubbo-rpc-jsonrpc 例子执行效果：



![https://raw.githubusercontent.com/sdcuike/dubbox-2016/dubbo-rpc-jsonrpc-demo/383C4DE1-6879-4ECD-83F8-AECF160E555C.png](https://raw.githubusercontent.com/sdcuike/dubbox-2016/dubbo-rpc-jsonrpc-demo/383C4DE1-6879-4ECD-83F8-AECF160E555C.png)
