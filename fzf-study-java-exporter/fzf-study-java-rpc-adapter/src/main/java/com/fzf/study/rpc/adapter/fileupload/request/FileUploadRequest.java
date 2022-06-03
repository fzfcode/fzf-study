package com.fzf.study.rpc.adapter.fileupload.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @author: fanzhenfeng
 * @date: 2022/6/2 4:00 下午
 * @description:
 * @version: v1.0
 */
@Data
public class FileUploadRequest implements Serializable {

    private static final long serialVersionUID = 4507958953637570145L;

    private MultipartFile file;
}
