package com.ifknow.utils;

/**
 * @Author: ifknow <br>
 * @Date: 2020/8/25  10:00 <br>
 * @Description: NO Description
 */
public class FileModel {
    private String uploadPath;
    private String readPath;

    public String getUploadPath() {
        return uploadPath;
    }

    public FileModel setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
        return this;
    }

    public String getReadPath() {
        return readPath;
    }

    public FileModel setReadPath(String readPath) {
        this.readPath = readPath;
        return this;
    }
}
