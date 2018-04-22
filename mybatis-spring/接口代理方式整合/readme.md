## 使用接口代理方式整合spring-mybatis
1. 导包
2. 添加配置文件
```
在SqlMapConfig.xml中(尽量)使用包扫描的方式
```
3. 同一个包下编写mapper&mapper.xml

## 流程梳理
test中找到applicationContext.xml -> applicationContext.xml中的SQLSessionFactory找到sqlMapConfig.xml -> sqlMapConfig.xml扫描到mapper.xml
