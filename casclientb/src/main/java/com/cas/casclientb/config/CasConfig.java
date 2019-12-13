package com.cas.casclientb.config;

import net.unicon.cas.client.configuration.CasClientConfigurerAdapter;
import net.unicon.cas.client.configuration.EnableCasClient;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCasClient
public class CasConfig extends CasClientConfigurerAdapter {
    //加一个过滤器，负责过滤登出，登出时的过滤器
    @Bean
    public FilterRegistrationBean singleSignOutFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.addInitParameter("casServerUrlPrefix","http://127.0.0.1:9001/cas");
//        filterRegistrationBean.addInitParameter("casServerUrlPrefix","http://127.0.0.1:9001/cas");
        filterRegistrationBean.setOrder(-1);
        filterRegistrationBean.setFilter(new SingleSignOutFilter());
        return filterRegistrationBean;
    }

    //加一个监听器，负责监听登出，登出时将httpsession销毁
    @Bean
    public ServletListenerRegistrationBean singleSignHttpSessionListener(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new SingleSignOutHttpSessionListener());
        return servletListenerRegistrationBean;
    }


}
