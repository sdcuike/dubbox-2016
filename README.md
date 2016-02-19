# dubbox-2016
——————————————————————————————————————————


dubbo的插件集合[https://github.com/dubboclub/dubbo-plus](https://github.com/dubboclub/dubbo-plus)

dubbo服务管理以及监控系统[https://github.com/dubboclub/dubbokeeper](https://github.com/dubboclub/dubbokeeper)

——————————————————————————————————————————
 
1. 下载dubbox-2016源码：执行mvn clean install -Dmaven.test.skip=true

2. copy 目录下dubbox-demo-service／target／dubbox-demo-service-1.0.0-SNAPSHOT-bin.tar 到某一目录解压

3. 安装zookeeper ，配置为单独服务器远行。

4.执行dubbox-demo-service-1.0.0-SNAPSHOT／bin下start.sh脚本，启动dubbo服务端(或执行dubbox-demo-service下的test下的com.doctor.demo.service.impl.com.doctor.demo.service.impl)。

5.找到dubbox-demo-client测试l类com.doctor.demo.service.client.impl.HelloServiceClientImplTest执行。

6.dubbo-rpc-jsonrpc 例子执行效果：



 测试地址：http://10.100.8.159:81/com.doctor.demo.service.HelloService (根据实际地址改动ip＋端口）
 
postman执行：

1.方法：public WelcomeResponseDto hello(WelcomeDto welcomDto)测试

{
    "jsonrpc":"2.0",
    "id":11,
    "method":"hello",
    "params":[{
            "name":"exapmpe",
            

        
        }]
    
}

返回
{
  "jsonrpc": "2.0",
  "id": 11,
  "result": {
    "content": "welcome to dubbo,{\"name\":\"exapmpe\",\"age\":12}"
  }
}



2.方法public WelcomeResponseDto hello(String name)测试：
{
    "jsonrpc":"2.0",
    "id":11,
    "method":"hello",
    "params":["hello me"]
    
}

返回：
{
  "jsonrpc": "2.0",
  "id": 11,
  "result": {
    "content": "welcome to dubbo,hello me"
  }
}



 2.方法public WelcomeResponseDto hello(String name, int age, WelcomeDto welcomeDto)测试：
 {
    "jsonrpc":"2.0",
    "id":11,
    "method":"hello",
    "params":["hello me","188",{"name":"exapmpe","age":12}]
    
}


返回：{
  "jsonrpc": "2.0",
  "id": 11,
  "result": {
    "content": "welcome to dubbo,hello me ,your age :188 {\"name\":\"exapmpe\",\"age\":12}"
  }
}


![https://raw.githubusercontent.com/sdcuike/dubbox-2016/master/test01.png](https://raw.githubusercontent.com/sdcuike/dubbox-2016/master/test01.png)
