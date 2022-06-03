package com.fzf.study.rpc.adapter.fileupload;

import com.fzf.study.rpc.adapter.fileupload.request.FileUploadRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: fanzhenfeng
 * @date: 2022/6/2 3:55 下午
 * @description:
 * @version: v1.0
 */
@RestController
@RequestMapping("/fileupload")
public class FileUploadWebExporter {

    @PostMapping("/upload")
    public String upload(FileUploadRequest fileUploadRequest){
        MultipartFile multipartFile = fileUploadRequest.getFile();

//        multipartFile.transferTo();

        return "";

    }
}
