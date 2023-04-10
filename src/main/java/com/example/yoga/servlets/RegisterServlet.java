package com.example.yoga.servlets;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @author 黄雯婷
 * @version 1.0
 * @description: 自定义注册servlet
 * @date 2023-04-10 09:54:37
 **/
@WebServlet(name = "registerServlet",urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置传输编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // 设置读取内容类型
        response.setContentType("text/html;charset=UTF-8");
        // 判断内容是不是multipart/form-data 这种类型的
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(isMultipart){// 如果是带文件流的提交

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            try {
                // 就要解析request请求
                List<FileItem> fileItems = fileUpload.parseRequest(request);
                Iterator<FileItem> iterator = fileItems.iterator();
                String uname=null, pwd=null;
                while (iterator.hasNext()) {
                    FileItem item =  iterator.next();
                    String fieldName = item.getFieldName();
                    switch (fieldName){
                        case "uname":
                            uname=item.getString();
                            break;
                        case "pwd":
                            pwd=item.getString();
                            break;
                        case "pic":
                            // 获取文件名
                            String fileName = item.getName();
                            String path="/upload";//这么写文件会放在项目所在盘符下的 /upload文件夹下，比如 E://upload

                            // E:\self_github_projects\yoga_single_manage\src\main\webapp\
                             String path2=request.getSession().getServletContext().getRealPath("/");

                            // String path2=request.getContextPath();
                            System.out.println("path2:"+path2);
                            File file = new File(path, fileName);
                            item.write(file);
                            System.out.println("上传成功");
                            break;
                    }
                }
                System.out.println("表单信息：uname="+uname+",pwd="+pwd);
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
