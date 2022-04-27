package com.fzf.study.rpc.adapter.socket.handler;


import lombok.extern.slf4j.Slf4j;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.springframework.stereotype.Component;
import com.fzf.study.rpc.adapter.socket.constant.Constants;

/**
 * 默认客户端请求处理器
 *
 * @author
 *
 */
@Component
@Slf4j
public class DefaultClientIoHandler extends IoHandlerAdapter {

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        // session 创建时调用
        log.info("连接创建 : " + session.getRemoteAddress().toString());
    }

    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        // 异步接收消息
        log.info("接受到数据 :" + String.valueOf(message));
        session.setAttribute(Constants.RESPONSE,message);
        session.closeOnFlush();
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception {
        log.error("出现异常 :" + session.getRemoteAddress().toString() + " : " + cause.toString());
        session.setAttribute(Constants.EXCEPTION,cause);
        session.closeOnFlush();
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status)
            throws Exception {
        log.warn("对方未响应，等待超时，关闭连接");
        session.setAttribute(Constants.EXCEPTION,new Exception());
        session.closeOnFlush();
    }
}
