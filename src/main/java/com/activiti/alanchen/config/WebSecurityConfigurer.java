package com.activiti.alanchen.config;

import com.smm.framework.authority.GlobalWebSecurityConfigurer;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * @author Alan Chen
 * @description Spring security配置
 * @date 2019-10-12
 */
@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class WebSecurityConfigurer extends GlobalWebSecurityConfigurer {


    @Override
    protected HttpSecurity customConfigure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/activiti/**").permitAll()
                .anyRequest().authenticated();
        return http;
    }

}
