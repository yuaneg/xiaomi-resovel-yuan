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
        factory.setMaxFileSize("102400KB");  
        factory.setMaxRequestSize("102400KB");  
        return factory.createMultipartConfig();  
    }  
  
}
