#spring-boot-dubbo脚手架

##框架包含那些？
* mybatis-plus 增强版 mybatis,简化mapper，service等待代码编写任务
* spring-boot 简化新Spring应用的初始搭建以及开发过程
* spring-boot-starter-dubbo 基于dubbo 2.5.3的starter,实现基于@Service,@ @Reference注解实现服务的注册与发现，简化传统spring-consumer.xml与spring-provider.xml的配置
* 整合国外知名bootstrap前端框架inspinia


## 各个模块pom介绍
###parent
```xml
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.3.RELEASE</version>
    </parent>
    
    ………………
    
    <dependency>
    			<groupId>org.springframework.boot</groupId>
    			<artifactId>spring-boot-starter</artifactId>
    		</dependency>
    
    		<dependency>
    			<groupId>com.baomidou</groupId>
    			<artifactId>mybatis-plus</artifactId>
    			<version>2.0.1</version>
    		</dependency>
    
    		<dependency>
    			<groupId>org.hibernate</groupId>
    			<artifactId>hibernate-validator</artifactId>
    			<version>4.2.0.Final</version>
    		</dependency>
    
    		<dependency>
    			<groupId>org.springframework.boot</groupId>
    			<artifactId>spring-boot-starter-test</artifactId>
    			<scope>test</scope>
    		</dependency>
    
    		<dependency>
    			<groupId>org.springframework.boot</groupId>
    			<artifactId>spring-boot-devtools</artifactId>
    			<scope>test</scope>
    		</dependency>
    
    
```

###api
    无需任何dependency
    
###provider
####pom
```xml
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-dubbo</artifactId>
			<version>1.3.6.RELEASE</version>
		</dependency>

		<!--依赖于容器-->

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<version>1.3.6.RELEASE</version>
		</dependency>

		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>druid</artifactId>
			<version>1.0.11</version>
		</dependency>

		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>

		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>1.1.1</version>
		</dependency>
```
####yml
```yml
spring:
    datasource:
        name: test
        url: jdbc:mysql://10.168.16.116:3306/test?useUnicode=true&characterEncoding=utf8
        username: root
        password: devApp2013
        # 使用druid数据源
        type: com.alibaba.druid.pool.DruidDataSource
        driver-class-name: com.mysql.jdbc.Driver
        filters: stat
        maxActive: 20
        initialSize: 1
        maxWait: 60000
        minIdle: 1
        timeBetweenEvictionRunsMillis: 60000
        minEvictableIdleTimeMillis: 300000
        validationQuery: select 'x'
        testWhileIdle: true
        testOnBorrow: false
        testOnReturn: false
        poolPreparedStatements: true
        maxOpenPreparedStatements: 20
    dubbo:
      application:
        name: dubbo-provider
      registry:
        protocol: zookeeper
        address: zookeeper://10.168.17.75:2181
      protocol:
        name: dubbo
        port: 20880
        host:
      scan: com.reapal

mybatis:
    type-aliases-package: com.reapal.dubbo.api.model
    mapper-locations: classpath:mapper/*.xml

debug: true
```




###consumer
####pom
```xml
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-dubbo</artifactId>
			<version>1.3.6.RELEASE</version>
		</dependency>

		<!--依赖于容器-->

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<version>1.3.6.RELEASE</version>
		</dependency>

		<!-- 支持freemarker作为模板引擎 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-freemarker</artifactId>
		</dependency>

		<!--权限-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
```
####yml
```yml
server:
  port: 7070
  display-name: cdubbo-web

spring:
  dubbo:
    application:
      name: dubbo-web
    registry:
      address: zookeeper://10.168.17.75:2181
    scan: com.reapal.dubbo.web
  mvc:
      view:
          prefix: /templates/
          suffix: .ftl
  freemarker:
      cache: false
      request-context-attribute: request
```

##运行环境
*  java8
*  mysql
*  zookeeper

##开发工具
   idea