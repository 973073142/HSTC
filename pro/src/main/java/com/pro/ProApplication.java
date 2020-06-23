package com.pro;

import java.util.Properties;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import com.github.pagehelper.PageInterceptor;

@SpringBootApplication
@MapperScan("com.pro.mapper")
public class ProApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProApplication.class, args);
	}
	
	/**
	 * 这一个是分页
	 * @return
	 */
	@Bean
	public PageInterceptor pageHelper() {
		PageInterceptor pageInterceptor=new PageInterceptor();
		Properties properties=new Properties();
		properties.setProperty("helperDialect", "mysql");
		properties.setProperty("reasonable", "true");
		properties.setProperty("offsetAsPageNum", "true");
		pageInterceptor.setProperties(properties);
		return pageInterceptor;
	}
	
	@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大 5M
        factory.setMaxFileSize("5120KB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("102400KB");
        return factory.createMultipartConfig();
	}

}
