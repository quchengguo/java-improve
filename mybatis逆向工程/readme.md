## Mybatis逆向工程功能
Mybatis逆向工程可以动态的帮助我们创建数据库表所对应的```pojo（javabean）、mapper、mapper.xml```文件

## 配置步骤
在```generatorConfig.xml```配置文件中修改: <br/>
1. 数据库连接的信息：驱动类、连接地址、用户名、密码
2. targetProject:生成PO类的位置
3. targetProject:mapper映射文件生成的位置
4. targetPackage：mapper接口生成的位置
5. 指定数据库表

最后执行```GeneratorSqlmap.java```中的```main```方法
