package com.ITReuvenBlog.WebBlog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")/*какой ресурс искать*/
                .addResourceLocations("classpath:/css/");/*где искать нужный ресурс*/
        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/images/");
        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/js/");
    }
}







