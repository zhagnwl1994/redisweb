package com.redisweb.redisweb;

import com.redisweb.redisweb.Interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
/**
 * 配置类
 */
//@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/index.html");
//        super.addInterceptors(registry);
    }
}
