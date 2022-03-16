package com.fzf.study.rpc.adapter.socket.util;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class NioAcceptorHelper implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(NioAcceptorHelper.class);

    @Value("#{env['nioPoolSize']?:0}")
    private int nioPoolSize;

    @Value("#{env['nioBacklog']?:0}")
    private int nioBacklog;

    private NioSocketAcceptor acceptor;

    private List<IoFilter> ioFilters;


    public NioSocketAcceptor getAcceptor() {
        return acceptor;
    }


    public List<IoFilter> getIoFilters() {
        return ioFilters;
    }

    public void setIoFilters(List<IoFilter> ioFilters) {
        this.ioFilters = ioFilters;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        LOGGER.info("设置参数");

        if (nioPoolSize > 0) {
            acceptor = new NioSocketAcceptor(nioPoolSize);
        } else {
            acceptor = new NioSocketAcceptor();
        }

        if (nioBacklog > 0) {
            acceptor.setBacklog(nioBacklog);
        }

        if (ioFilters != null) {
            for (IoFilter ioFilter : ioFilters) {
                acceptor.getFilterChain().addLast(ioFilter.getClass().getName(), ioFilter);
            }
        }
    }
}
