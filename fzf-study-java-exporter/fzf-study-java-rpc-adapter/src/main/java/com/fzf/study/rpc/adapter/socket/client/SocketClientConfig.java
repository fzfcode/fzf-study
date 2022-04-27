package com.fzf.study.rpc.adapter.socket.client;

import com.fzf.study.rpc.adapter.socket.chain.UnifiedDecodeFilterChain;
import com.fzf.study.rpc.adapter.socket.chain.UnifiedEncodeFilterChain;
import com.fzf.study.rpc.adapter.socket.codec.decode.MessageDecoder;
import com.fzf.study.rpc.adapter.socket.codec.encode.MessageEncoder;
import com.fzf.study.rpc.adapter.socket.filter.ByteArrayDecoderFilter;
import com.fzf.study.rpc.adapter.socket.filter.ByteArrayEncodeFilter;
import com.fzf.study.rpc.adapter.socket.handler.DefaultClientIoHandler;
import com.fzf.study.rpc.adapter.socket.util.CodeMarkUtils;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Socket客户端
 *
 * @author mudaoming
 */
@Configuration
@ConfigurationProperties(prefix = "tlsms")
public class SocketClientConfig {

    @Value(value = "${connectTimeoutMillis:30000}")
    private long connectTimeoutMillis;

    @Value(value = "${idleTime:3000}")
    private int idleTime;


    /**
     * 编码器
     *
     * @return
     */
    @Bean
    public MessageEncoder messageEncoder(CodeMarkUtils codeMarkUtils) {
        MessageEncoder messageEncoder = new MessageEncoder();
        UnifiedEncodeFilterChain unifiedEncodeFilterChain = new UnifiedEncodeFilterChain();
        //字节内容编码过滤
        unifiedEncodeFilterChain.setChain(Arrays.asList(new ByteArrayEncodeFilter()));
        messageEncoder.setFilterChain(unifiedEncodeFilterChain);
        messageEncoder.setCodeMarkUtils(codeMarkUtils);
        return messageEncoder;
    }

    /**
     * 编码器
     *
     * @return
     */
    @Bean
    public MessageDecoder messageDecoder(CodeMarkUtils codeMarkUtils) {
        MessageDecoder messageDecoder = new MessageDecoder();
        UnifiedDecodeFilterChain unifiedDecodeFilterChain = new UnifiedDecodeFilterChain();
        //字节内容解码过滤
        unifiedDecodeFilterChain.setChain(Arrays.asList(new ByteArrayDecoderFilter()));
        messageDecoder.setFilterChain(unifiedDecodeFilterChain);
        messageDecoder.setCodeMarkUtils(codeMarkUtils);
        return messageDecoder;
    }


    /**
     * 编码器filter
     */
    @Bean
    public ProtocolCodecFilter protocolCodecFilter(final ProtocolEncoder messageEncoder, final ProtocolDecoder messageDecoder) {
        return new ProtocolCodecFilter(new ProtocolCodecFactory() {
            @Override
            public ProtocolEncoder getEncoder(IoSession ioSession) throws Exception {
                return messageEncoder;
            }

            @Override
            public ProtocolDecoder getDecoder(IoSession ioSession) throws Exception {
                return messageDecoder;
            }
        });
        //return new ProtocolCodecFilter(customProtocolCodecFactory);
    }

    /**
     * 日志filter
     */
    @Bean
    public LoggingFilter loggingFilter() {
        LoggingFilter filter = new LoggingFilter(DefaultClientIoHandler.class);
        return filter;
    }

    /**
     * 过滤器
     */
    @Bean
    public DefaultIoFilterChainBuilder defaultIoFilterChainBuilder(ProtocolCodecFilter protocolCodecFilter,
                                                                   LoggingFilter loggingFilter) {
        DefaultIoFilterChainBuilder filterChainBuilder = new DefaultIoFilterChainBuilder();
        Map<String, IoFilter> filters = new LinkedHashMap<>();
        filters.put("loggingFilter", loggingFilter);
        filters.put("protocolCodecFilter", protocolCodecFilter);
        filterChainBuilder.setFilters(filters);
        return filterChainBuilder;
    }

    /**
     * 创建Connector
     *
     * @return
     */
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public NioSocketConnector nioSocketConnector(DefaultClientIoHandler defaultClientHandler,
                                                 DefaultIoFilterChainBuilder defaultIoFilterChainBuilder) {
        NioSocketConnector connector = new NioSocketConnector();
        // 设置连接超时时间
        connector.setConnectTimeoutMillis(connectTimeoutMillis);
        //读写空闲时间
        connector.getSessionConfig().setBothIdleTime(idleTime);
        // 设置处理handler
        connector.setHandler(defaultClientHandler);
        // 绑定过滤器链
        connector.setFilterChainBuilder(defaultIoFilterChainBuilder);
        return connector;
    }

}
