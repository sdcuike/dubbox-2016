package com.doctor.dubbx.extend.brave;

import java.util.Arrays;
import java.util.Collection;

import com.alibaba.dubbo.rpc.RpcContext;
import com.github.kristofa.brave.ClientRequestAdapter;
import com.github.kristofa.brave.IdConversion;
import com.github.kristofa.brave.KeyValueAnnotation;
import com.github.kristofa.brave.SpanId;
import com.github.kristofa.brave.http.BraveHttpHeaders;

/**
 * @author sdcuike
 *
 * @time 2016年2月2日 上午10:38:44
 */
public class DubboConsumerRequestAdapter implements ClientRequestAdapter {
    private final RpcContext rpcContext;
    private final DubboSpanNameProvider spanNameProvider;
    private final DubboServiceNameProvider serviceNameProvider;

    public DubboConsumerRequestAdapter(RpcContext rpcContext, DubboSpanNameProvider spanNameProvider, DubboServiceNameProvider serviceNameProvider) {
        this.rpcContext = rpcContext;
        this.spanNameProvider = spanNameProvider;
        this.serviceNameProvider = serviceNameProvider;
    }

    @Override
    public String getSpanName() {
        return spanNameProvider.spanName(rpcContext);
    }

    @Override
    public void addSpanIdToRequest(SpanId spanId) {
        if (spanId == null) {
            rpcContext.setAttachment(BraveHttpHeaders.Sampled.getName(), "0");
        } else {
            rpcContext.setAttachment(BraveHttpHeaders.Sampled.getName(), "1");

            rpcContext.setAttachment(BraveHttpHeaders.TraceId.getName(), IdConversion.convertToString(spanId.getTraceId()));

            rpcContext.setAttachment(BraveHttpHeaders.SpanId.getName(), IdConversion.convertToString(spanId.getSpanId()));

            if (spanId.getParentSpanId() != null) {
                rpcContext.setAttachment(BraveHttpHeaders.ParentSpanId.getName(), IdConversion.convertToString(spanId.getParentSpanId()));
            }
        }
    }

    @Override
    public String getClientServiceName() {
        return serviceNameProvider.serviceName(rpcContext);
    }

    @Override
    public Collection<KeyValueAnnotation> requestAnnotations() {
        String uri = rpcContext.getUrl().toServiceString();
        KeyValueAnnotation annotation = KeyValueAnnotation.create("dubbo.uri", uri);
        return Arrays.asList(annotation);
    }

}
