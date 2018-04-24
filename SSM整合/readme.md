### SSM整合步骤
SSM整合主要是配置文件的整合，so下边将ssm按照步骤说明配置文件的写法及作用
1. pom.xml中导包，每个项目必须做的第一步。前提是maven要安装好，不然有些jar包无法下载
2. 使用mybatis逆向工程生成mapper、pojo、mapper.xml。放在特定的包下边，mapper.xml放在resource/mappers中
3. 添加db.properties、log4j.properties文件
4. mybatis核心配置文件SqlMapConfig.xml，这里边并没有什么只有个config标签
5. springmvc配置文件springmvc.xml，这里有三样东西：注解扫描controller所在的包、mvc三大组件配置(处理器映射器|处理器适配器|资源视图解释器)、类型转换器(FormattingConversionServiceFactoryBean)
6. spring核心配置文件applicationContext.xml，这里边也有三样东西：注解扫描service包、配置数据库连接池、spring与mybatis整合(sqlSessionFactoryBean、dao层接口扫描、事务管理器、注解开启事务)
7. 服务器配置文件web.xml,这里边有三个东西：配置dispatchServlet、context-parm标签加载spring核心配置文件、配置ContextLoaderListener(用来监听核心配置文件的加载)
