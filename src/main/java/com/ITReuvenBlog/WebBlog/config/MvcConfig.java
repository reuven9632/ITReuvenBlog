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

        /*go-surf*/
        registry.addResourceHandler("stylesAndSettings/go-surf/css/**")/*какой ресурс искать*/
                .addResourceLocations("classpath:/templates/stylesAndSettings/go-surf/css/");/*где искать нужный ресурс*/
        registry.addResourceHandler("stylesAndSettings/go-surf/images/**")
                .addResourceLocations("classpath:/templates/stylesAndSettings/go-surf/images/");
        registry.addResourceHandler("stylesAndSettings/go-surf/js/**")
                .addResourceLocations("classpath:/templates/stylesAndSettings/go-surf/js/");

        /*AlonaNails*/
        registry.addResourceHandler("stylesAndSettings/alona-nails/css/**")
                .addResourceLocations("classpath:/templates/stylesAndSettings/alona-nails/css/");
        registry.addResourceHandler("stylesAndSettings/alona-nails/img/**")
                .addResourceLocations("classpath:/templates/stylesAndSettings/alona-nails/img/");
        registry.addResourceHandler("stylesAndSettings/alona-nails/js/**")
                .addResourceLocations("classpath:/templates/stylesAndSettings/alona-nails/js/");
        registry.addResourceHandler("stylesAndSettings/alona-nails/fonts/**")
                .addResourceLocations("classpath:/templates/stylesAndSettings/alona-nails/fonts/");
    }
}







