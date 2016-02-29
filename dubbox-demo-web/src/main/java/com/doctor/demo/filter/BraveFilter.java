package com.doctor.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sdcuike
 *
 * @time 2016年2月29日 下午4:06:37
 */
@WebFilter(urlPatterns = "/*")
public class BraveFilter implements Filter {
    private Logger log = LoggerFactory.getLogger(BraveFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info(getClass() + " init------------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info(getClass() + " doFilter------------");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info(getClass() + " destroy------------");

    }

}
