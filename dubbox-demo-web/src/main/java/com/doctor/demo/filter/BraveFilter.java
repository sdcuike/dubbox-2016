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
import org.springframework.context.ApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;
import com.doctor.dubbo.extend.brave.DubboProviderRequestAdapter;
import com.doctor.dubbo.extend.brave.DubboProviderResponesAdapter;
import com.doctor.dubbo.extend.brave.DubboSpanNameProvider;
import com.doctor.dubbo.extend.brave.helper.ApplicationContextProvider;
import com.github.kristofa.brave.Brave;
import com.github.kristofa.brave.http.BraveHttpHeaders;

/**
 * @author sdcuike
 *
 * @time 2016年2月29日 下午4:06:37
 */
@WebFilter(urlPatterns = "/*")
public class BraveFilter implements Filter {
    private Logger log = LoggerFactory.getLogger(BraveFilter.class);
    private static final String spanName = "demo-web";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info(getClass() + " init------------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ApplicationContext context = ApplicationContextProvider.getApplicationContext();

        Brave brave = context.getBean(Brave.class);
        DubboSpanNameProvider spanNameProvider = context.getBean(DubboSpanNameProvider.class);
        RpcContext rpcContext = RpcContext.getContext();

        rpcContext.setAttachment(BraveHttpHeaders.Sampled.getName(), "true");
        // rpcContext.setAttachment(BraveHttpHeaders.TraceId.getName(), IdConversion.convertToString(1L));
        // rpcContext.setAttachment(BraveHttpHeaders.SpanId.getName(), IdConversion.convertToString(1L));

        brave.serverRequestInterceptor().handle(new DubboProviderRequestAdapter(rpcContext, spanNameProvider, spanName));

        try {
            chain.doFilter(request, response);
        } finally {
            brave.serverResponseInterceptor().handle(new DubboProviderResponesAdapter(null));
        }

    }

    @Override
    public void destroy() {
        log.info(getClass() + " destroy------------");

    }

}
