package com.wm.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: sshdg
 * @Date: 2020/9/19 18:50
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        System.out.println("进入shiro拦截");


        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);


        Map<String, String> map = new LinkedHashMap<>();
        // 向map中添加 过滤的路径 和 必须认证才可以访问的过滤器，此过滤器拦截成功会默认跳转到"login.jsp"
        // map.put("/add", "authc");

        // 也可以设置全部拦截，一些不拦截

        map.put("/admin", "anon");
        map.put("/admin/login2", "anon");
        map.put("/admin/logout", "logout");

        map.put("/admin/**", "authc");
        //首页

        //设置拦截后跳转到的登录页面
        shiroFilterFactoryBean.setLoginUrl("/admin/login");
        // 设置无权访问页面
//        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);


        return shiroFilterFactoryBean;
    }


    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Reaml
     */
    @Bean(name = "userRealm")
    public  UserRealm getRealm(){
        return new UserRealm();
    }

    /**
     * 使用thymeleaf的shiro标签
     * @return
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
