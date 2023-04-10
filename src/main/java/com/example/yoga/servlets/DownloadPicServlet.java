package com.example.yoga.servlets;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author 黄雯婷
 * @version 1.0
 * @description: 头像图片下载
 * @date 2023-04-10 15:54:35
 **/
@WebServlet(name="downloadPicServlet",value = "/downloadPicServlet")
public class DownloadPicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //下载文件，需要设置消息头
        String filename=request.getParameter("fileName");
        //String filename="狗狗1";
        System.out.println(filename);
        response.addHeader("content-Type","application/octet-stream");//MIME类型
        response.addHeader("content-Disposition","attachment;filename="+ URLEncoder.encode(filename,"utf-8"));//filename需要带文件后缀，比如：a.jpg，如果文件名带有中文，需要使用 URLEncoder.encode(filename,"uft-8") 进行编码

        // servlet 通过文件地址，将文件转为输入流读到servlet中
       // InputStream inputStream = getServletContext().getResourceAsStream("E:\\upload\\狗狗1.jpg");
        File file = new File("E:\\upload\\1.jpg");
        InputStream inputStream = new FileInputStream(file);
        ServletOutputStream outputStream = response.getOutputStream();
        // 读文件需要使用字节数组作为过渡
        byte[] bytes = new byte[100];
        int len=-1;
        while((len=inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
