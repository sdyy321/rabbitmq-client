rabbitmq-client base spring-rabbit and spring-amqp
================

基于spring-amqp的rabbitmq客户端
--------------
实现rabbitmq的监听消费和发送消息功能

构建安装
-----------------------------------------------
### 使用maven构建

- 下载安装rabbitmq-client

```shell
git clone https://github.com/hashio/websocket-client.git
cd rabbitmq-client
mvn clean install
```

- 在你的应用中添加rabbitmq-client 依赖到pom.xml

```xml
<dependency>
  <groupId>me.poplaris</groupId>
  <artifactId>rabbitmq-client</artifactId>
  <version>1.0</version>
</dependency>
```

用法
--------------------------------------------------

- 实现消息监听消费

```java
class ApiProcessEventProcessor implements EventProcesser{
    @Override
    public void process(Object e) {//消费程序这里只是打印信息
        System.out.println(e);
    }
}
```

- 启动控制器

```java
String defaultHost = "127.0.0.1";
String defaultExchange = "EXCHANGE_DIRECT_TEST";
String defaultQueue = "QUEUE_TEST";
EventControlConfig config = new EventControlConfig(defaultHost);
DefaultEventController controller = DefaultEventController.getInstance(config);
EventTemplate eventTemplate = controller.getEopEventTemplate();
controller.add(defaultQueue, defaultExchange, new ApiProcessEventProcessor());
controller.start();
```

- 发送字符串消息

```java
eventTemplate.send(defaultQueue, defaultExchange, "hello world");
```

- 发送序列化对象消息

```java
eventTemplate.send(defaultQueue, defaultExchange, mockObj());
```

参见[博客](http://blog.csdn.net/sdyy321/article/details/9241445)

