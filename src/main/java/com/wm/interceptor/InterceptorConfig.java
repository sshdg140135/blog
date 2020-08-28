package com.wm.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //要拦截的路径
        String[] addPathPatterns = {
            "/admin/**"
        };
        //要排除的
        String[] excludePathPatterns = {
            "/admin",
            "/admin/login"
        };
        //相当于<mvn:interceptor>标签中的<bean class=""/>标签
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }
}
