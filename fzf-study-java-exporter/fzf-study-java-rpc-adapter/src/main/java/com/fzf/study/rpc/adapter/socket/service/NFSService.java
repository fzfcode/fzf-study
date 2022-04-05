package com.fzf.study.rpc.adapter.socket.service;


import com.fzf.study.rpc.adapter.socket.message.CoreMessage;
import com.fzf.study.rpc.adapter.socket.util.DOMXMLReader;

import java.io.IOException;


public interface NFSService {
    CoreMessage process(DOMXMLReader domxmlReader) throws IllegalAccessException, IOException;
}
