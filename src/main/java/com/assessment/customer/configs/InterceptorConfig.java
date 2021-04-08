package com.assessment.customer.configs;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.assessment.customer.interceptor.AccessLogInterceptor;
import com.assessment.customer.interceptor.CorrelationIdInterceptor;

/**
 * API Interceptor configurations.
 * 
 * @author lahirua
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * Interceptor List.
     */
    
    
    @Autowired
    private CorrelationIdInterceptor correlationIdInterceptor;

    @Autowired
    private AccessLogInterceptor accessLogInterceptor;

    /**
     * Setting the locale for Spring Boot Configurations.
     * 
     * @return {@link LocaleResolver}
     */
    @Bean
    public LocaleResolver localeResolver() {
	SessionLocaleResolver slr = new SessionLocaleResolver();
	slr.setDefaultLocale(Locale.ENGLISH);
	return slr;
    }

    /**
     * Setting up the locale change interceptor for Spring boot configurations.
     * 
     * @return {@link LocaleChangeInterceptor}
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
	LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
	lci.setParamName("locale");
	return lci;
    }

    /**
     * Register the interceptors used. Only the specified Interceptors handle
     * requests which match with the given path params. Adding order is
     * important.
     * 
     * @param registry
     *                     : Interceptor registry object.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

	registry.addInterceptor(correlationIdInterceptor);
	registry.addInterceptor(accessLogInterceptor);

    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

}
