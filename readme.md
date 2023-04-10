## 框架：springboot+jsp+maven+mysql

1. [关于 JSTL JSP标签库的使用](<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>)

2. 自定义servlet的写法

（jsp页面编译之后就是servlet类，所以servlet与jsp是等价的）
  ````
(1) 自定义servlet类需要继承 HttpServlet类，根据需要重写 doGet、doPost方法 
`public class MyServlet2 extends HttpServlet`
(2) 需要将上述servlet类注册到 spring容器中，两种注册方式：
i、在自定义servlet上添加注解 @WebServlet，在启动类上添加注解@ServletComponentScan
ii、在@Configuration标注的配置类中，使用@Bean，向ServletRegistrationBean对象中注册自定义servlet
 ````
3. jsp文件上传下载
 ````
1、需要导入 commons-io、commons-fileupload的apache maven依赖
2、上传：
（1）设置form表单 method="post" enctype="multipart/form-data"
（2）在后端servlet需要设置 request、response编码防止乱码
        // 设置传输编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // 设置读取内容类型
        response.setContentType("text/html;charset=UTF-8");
（3）后端servlet 中主要是使用 org.apache.commons.fileupload.servlet.ServletFileUpload 来对request进行解析
从而获取表单提交过来的表单项
        List<FileItem> fileItems = fileUpload.parseRequest(request);
（4）获得文件的输入流之后，指定文件要保存的路径声明一个file对象，向该file对象写入流
        File file = new File(path, fileName);
        item.write(file);
3、下载：
（1）前端声明一个超链接来请求后端的servlet
（2）在后端servlet 中需要设置响应头
        response.addHeader("content-Type","application/octet-stream");//MIME类型
        response.addHeader("content-Disposition","attachment;filename="+ URLEncoder.encode(filename,"utf-8"));
（3）将要下载的文件路径声明为file对象，再获取到输入流
        File file = new File("E:\\upload\\1.jpg");
        InputStream inputStream = new FileInputStream(file);
（4）使用字节数组作为缓存过渡，使用 response输出流，将文件信息输出到前端
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[100];
        int len=-1;
        while((len=inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }