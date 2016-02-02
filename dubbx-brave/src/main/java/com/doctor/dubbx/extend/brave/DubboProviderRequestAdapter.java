package com.doctor.dubbx.extend.brave;

import java.util.Collection;
import java.util.Collections;

import com.alibaba.dubbo.rpc.RpcContext;
import com.github.kristofa.brave.IdConversion;
import com.github.kristofa.brave.KeyValueAnnotation;
import com.github.kristofa.brave.ServerRequestAdapter;
import com.github.kristofa.brave.SpanId;
import com.github.kristofa.brave.TraceData;
import com.github.kristofa.brave.http.BraveHttpHeaders;

/**
 * @author sdcuike
 *
 * @time 2016年2月2日 上午10:18:06
 */
public class DubboProviderRequestAdapter implements ServerRequestAdapter {

    private final RpcContext rpcContext;
    private final DubboSpanNameProvider spanNameProvider;

    public DubboProviderRequestAdapter(RpcContext rpcContext, DubboSpanNameProvider spanNameProvider) {
        this.rpcContext = rpcContext;
        this.spanNameProvider = spanNameProvider;
    }

    @Override
    public TraceData getTraceData() {
        final String sampled = rpcContext.getAttachment(BraveHttpHeaders.Sampled.getName());
        if (sampled != null) {
            if (sampled.equals("0") || sampled.toLowerCase().equals("false")) {
                return TraceData.builder().sample(false).build();
            } else {
                final String parentSpanId = rpcContext.getAttachment(BraveHttpHeaders.ParentSpanId.getName());
                final String traceId = rpcContext.getAttachment(BraveHttpHeaders.TraceId.getName());
                final String spanId = rpcContext.getAttachment(BraveHttpHeaders.SpanId.getName());

                if (traceId != null && spanId != null) {
                    SpanId span = getSpanId(traceId, spanId, parentSpanId);
                    return TraceData.builder().sample(true).spanId(span).build();
                }
            }
        }
        return TraceData.builder().build();
    }

    @Override
    public String getSpanName() {
        return spanNameProvider.spanName(rpcContext);
    }

    @Override
    public Collection<KeyValueAnnotation> requestAnnotations() {
        return Collections.emptyList();
    }

    private SpanId getSpanId(String traceId, String spanId, String parentSpanId) {
        if (parentSpanId != null) {
            return SpanId.create(IdConversion.convertToLong(traceId), IdConversion.convertToLong(spanId), IdConversion.convertToLong(parentSpanId));
        }
        return SpanId.create(IdConversion.convertToLong(traceId), IdConversion.convertToLong(spanId), null);
    }
}
