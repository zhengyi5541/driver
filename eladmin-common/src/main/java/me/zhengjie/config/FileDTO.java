package me.zhengjie.config;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 文件上传信息存储类
 * @author: tzq
 * @create 2019-08-06
 */
@Data
public class FileDTO implements Serializable {

    /**
     * 文件大小
     */
    private Long fileSize;
    /**
     * 文件的绝对路径
     */
    private String fileAPUrl;

    /**
     * 文件的web访问地址
     */
    private String webUrl;

    /**
     * 文件后缀
     */
    private String fileSuffix;
    /**
     * 存储的bucket
     */
    private String fileBucket;

    /**
     * 原文件名
     */
    private String oldFileName;
    /**
     * 存储的文件夹
     */
    private String folder;

    public FileDTO() {
    }

    public FileDTO(Long fileSize, String fileAPUrl, String webUrl, String fileSuffix, String fileBucket, String oldFileName, String folder) {
        this.fileSize = fileSize;
        this.fileAPUrl = fileAPUrl;
        this.webUrl = webUrl;
        this.fileSuffix = fileSuffix;
        this.fileBucket = fileBucket;
        this.oldFileName = oldFileName;
        this.folder = folder;
    }
}
