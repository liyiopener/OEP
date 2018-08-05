package com.sut.oep.Interceptor;

import com.sut.oep.Interceptor.MyInterceptor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig  implements ApplicationContextAware,WebMvcConfigurer {

    private ApplicationContext applicationContext;

    public WebConfig(){
        super();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/bootstrap/**").addResourceLocations("classpath:/static/bootstrap/");
        registry.addResourceHandler("/head/**").addResourceLocations("classpath:/static/head/");
        registry.addResourceHandler("/courseImg/**")
                .addResourceLocations("file:///E:/oepfiles/courseImg/");
        registry.addResourceHandler("/courseVedio/**").addResourceLocations("file:///E:/oepfiles/courseVedio/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截规则：除了login和首页，其他都拦截判断
        List<String> expath = new ArrayList<String>();
        expath.add("/Login/**");
        expath.add("/");
        expath.add("/js/**");
        expath.add("/css/**");
        expath.add("/bootstrap/**");
        expath.add("/head/**");
        expath.add("/img/**");
        expath.add("/Course/getCourseListByKinds");
        expath.add("");
        expath.add("/favicon.ico");
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns(expath);
                //.excludePathPatterns("/Login/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}