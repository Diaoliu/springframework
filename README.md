## 有点不太全的Spring Framework示例代码

> 下文中所有关于Spring的介绍都不保证正确，只是个人的猜测和总结分析，全文大白话，便于自己和他人参考。

Spring的各个模块都是相对独立的，码农们可以按照自己的需求在pom清单从导入需要的模块。 这些模块的功能如下:

* **Core technologies**: Spring Core
  * 依赖注入, 支持Java依赖注入标准(JSR-330)或者Spring自己的那些注解
  * AOP切面编程，把相同的代码片段插入到目标方法中
* **Testing**: 各种测试工具
* **Data Access**: JDBC Template加强版、整合JPA(Java Persistence API)和Hibernate(JPA的实现)
* **Spring MVC**: Dispatcher Servlet拦截所有匹配URL的请求，分发到各个控制器中处理请求(就是各种花样CRUD)
，直接返回数据(任意数据格式)，或者绑定各种数据到请求(HttpRequest)中并返回一个视图名称，模板引擎把数据填充到这个视图中，这部分和所有Web框架基本上大同小异。

Spring Core实现了容器这个概念，当然容器这个概念一开始来源于Ejb(Enterprise Bean)，Ejb建立在Java RMI(Remote Method Invocation)
之上，每次调用Ejb的方法都要进行一次远程方法调用(除非声明 `@Local`)，即霍霍计算机资源又难以调试，商业级Ejb容器虽逼格甚高，比如Jboss和Weblogic。Spring Core在某种意义上可以作为Ejb的免费替代品，提供了丰富的单元测试和整合测试工具。Spring Core不支持分布式应用(即Ejb分布在不同JVM上)，所以Spring Cloud用一些分布式框架又重新实现了一遍Java
RMI中的服务注册和服务发现。
