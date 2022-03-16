package com.fzf.study.rpc.adapter.socket.server;

import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SocketServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocketServer.class);

    //监听端口
    private String[] ports;

    public NioSocketAcceptor acceptor;

    public String[] getPorts() {
        return ports;
    }

    public void setPorts(String[] ports) {
        this.ports = ports;
    }

    public NioSocketAcceptor getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(NioSocketAcceptor acceptor) {
        this.acceptor = acceptor;
    }


    /**
     * 启动服务，监听注定端口
     */
    public void bind() {
        try {
            for (String port : ports) {
                if ("test".equals(port)) {
                    continue;
                }
                acceptor.setReuseAddress(true);
                acceptor.bind(new InetSocketAddress(Integer.valueOf(port)));
                LOGGER.info("服务已启动，监听端口：{},地址重用状态：{}", port, acceptor.isReuseAddress());
            }

        } catch (IOException e) {
            LOGGER.error("端口被占用或其他I/O异常，服务启动失败，请重试", e);
            System.exit(1);
        }

    }

    /**
     * 解除端口监听
     */
    public void unbind() {
        for (String port : ports) {
            acceptor.unbind(new InetSocketAddress(Integer.valueOf(port)));
            LOGGER.info("服务已从端口：" + port + "解除监听");

        }
    }

    /**
     * 服务关闭，释放资源
     */
    public void shutdown() {
        acceptor.dispose(true);
        LOGGER.info("服务已关闭");
    }
}
