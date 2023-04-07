## 框架：springboot+jsp+maven+mysql

1. [关于 JSTL JSP标签库的使用](<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>)

2. 自定义servlet的写法
  ````
(1) 自定义servlet类需要继承 HttpServlet类，根据需要重写 doGet、doPost方法 
`public class MyServlet2 extends HttpServlet`
(2) 需要将上述servlet类注册到 spring容器中，两种注册方式：
i、在自定义servlet上添加注解 @WebServlet，在启动类上添加注解@ServletComponentScan
ii、在@Configuration标注的配置类中，使用@Bean，向ServletRegistrationBean对象中注册自定义servlet
