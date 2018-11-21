package org.prajin.ex.nttdata.flightticketing.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "nttdata.slf4jfilter")
public class Slf4jMdcFilterConfiguration {

    public static final String DEFAULT_RESPONSE_TOKEN_HEADER = "Response_Token";
    public static final String DEFAULT_MDC_UUID_TOKEN_KEY = "Slf4jMdcFilter.UUID";
    public static final String DEFAULT_MDC_CLIENT_IP_KEY = "Slf4jMdcFilter.ClientIP";

    private String responseHeader = DEFAULT_RESPONSE_TOKEN_HEADER;
    private String mdcTokenKey = DEFAULT_MDC_UUID_TOKEN_KEY;
    private String mdcClientIpKey = DEFAULT_MDC_CLIENT_IP_KEY;
    private String requestHeader = null;

    @Bean
    public FilterRegistrationBean servletRegistrationBean() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        final Slf4jMdcFilter log4jMdcFilterFilter = new Slf4jMdcFilter(responseHeader, mdcTokenKey, mdcClientIpKey, requestHeader);
        registrationBean.setFilter(log4jMdcFilterFilter);
        registrationBean.setOrder(2);
        return registrationBean;
    }

}
