package com.fzf.study.rpc.adapter.socket.service;


import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.message.CoreMessage;
import com.sankuai.meituan.mkt.activity.rpc.adapter.socket.util.DOMXMLReader;

import java.io.IOException;


public interface NFSService {
    CoreMessage process(DOMXMLReader domxmlReader) throws IllegalAccessException, IOException;
}
