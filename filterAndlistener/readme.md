## 项目介绍
该项目为filter实现的一个统一全站编码且具有用户校验功能的案例。
## 注意
* 在描述路径的时候不要使用<font color='red'>硬编码</font>，比如不要使用``` /myFiler/index.jsp```，而是使用```${request.getServletContext().getContextPath()}/index.jsp```
* 在统一字符编码的时候将字符集配置在```web.xml```中，不要使用<font color='red'>硬编码</font>

* ```MyHttpServletRequest```类使用了<font color='red'>装饰者模式</font>，增强了```HttpServletRequest```类。装饰者模式的核心：继承需要增强的类，重写你不满足的方法，在使用的时候直接使用你自己的类。
