package xyz.talentboy.common.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileUpLoad {
    @Bean  
    public MultipartConfigElement multipartConfigElement() {  
    	MultipartConfigFactory factory = new MultipartConfigFactory();  
        factory.setMaxFileSize("1000000KB");  
        factory.setMaxRequestSize("1000000KB");  
        return factory.createMultipartConfig();  
    }  
   

	
}
