package com.example.yoga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan  // 告知spring容器去扫描 @WebServlet 标注的类
public class YogaSingleManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(YogaSingleManageApplication.class, args);
	}

}
