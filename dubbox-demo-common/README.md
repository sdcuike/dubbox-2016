 ### swagger-maven-plugin 使用
 pom 添加插件：
 
 <plugin>
                <groupId>com.github.kongchen</groupId>
                <artifactId>swagger-maven-plugin</artifactId>
                <configuration>
                    <apiSources>
                        <apiSource>
                            <springmvc>false</springmvc>
                            <locations>com.doctor.demo</locations>
                            <schemes>http,https</schemes>
                            <host>petstore.swagger.wordnik.com</host>
                            <basePath>/api</basePath>
                            <info>
                                <title>Swagger Maven Plugin Sample</title>
                                <version>v1</version>
                                <description>This is a sample for swagger-maven-plugin</description>
                                <termsOfService>
                                    http://www.github.com/kongchen/swagger-maven-plugin
                                </termsOfService>
                                <contact>
                                    <email>kongchen@gmail.com</email>
                                    <name>Kong Chen</name>
                                    <url>http://kongch.com</url>
                                </contact>
                                <license>
                                    <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
                                    <name>Apache 2.0</name>
                                </license>
                            </info>
                            Support classpath or file absolute path here. 1) classpath e.g: "classpath:/markdown.hbs", "classpath:/templates/hello.html" 2) file e.g: "${basedir}/src/main/resources/markdown.hbs", "${basedir}/src/main/resources/template/hello.html"
                            <templatePath>${basedir}/templates/strapdown.html.hbs</templatePath>
                            <outputPath>${basedir}/generated/document.html</outputPath>
                            <swaggerDirectory>generated/swagger-ui</swaggerDirectory>
                        </apiSource>
                    </apiSources>
                </configuration>
                <executions>
                    <execution>
                        <phase>compile</phase>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            
            
            
            
            
用到到模版见目录。

 1.在该项目下执行mvn clean compile，得到generated/swagger-ui/swagger.json.
 
 2.下载https://github.com/swagger-api/swagger-ui/tree/master/dist 编译后的版本。
 
 3.swagger.json拷贝到dist目录下。然后把dist放到tomcat webapp目录下。（可以把本项目目录下到dist之间copy到tomcat下）。
 
 4.启动tomcat。端口配置为8888。
 
 5.打开http://localhost:8888/dist/ swagger-ui页面。
 
 6.在swagger-ui页面顶端输入地址http://localhost:8888/dist/swagger.json，即可看到rest接口文档。
 
 7.截图（rest.png)
 
 