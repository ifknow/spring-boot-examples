package com.ifknow.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: ifknow <br>
 * @Date: 2020/8/25  10:28 <br>
 * @Description: NO Description
 */
public class FileUtil {

    /**
     * 上传文件接口
     *
     * @param file    文件
     * @param request
     * @param model
     * @return
     */
    public Map<String, Object> upload(MultipartFile file, HttpServletRequest request, FileModel model) {
        //文件不为空
        if (!file.isEmpty()) {
            //上传文件名
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            try {
                Map<String, Object> map = this.toUpload(file, suffix, fileName, request, model);
                return map;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 上传操作
     *
     * @param file     文件
     * @param suffix   后缀
     * @param fileName 文件名
     * @param request
     * @param model
     * @return
     */
    public Map<String, Object> toUpload(MultipartFile file, String suffix, String fileName, HttpServletRequest request,FileModel model) {
        suffix = suffix.toLowerCase();
        Map<String, Object> pathMap = this.filePath(suffix, model);
        String filePath = pathMap.get("filePath").toString();
        File realPath = new File(filePath, fileName);
        if (!realPath.getParentFile().exists()) {
            realPath.getParentFile().mkdirs();
        }
        String newName = UUID.randomUUID().toString().replace("-", "") + fileName.substring(fileName.lastIndexOf("."));
        File newFile = new File(filePath + File.separator + newName);
        try {
            file.transferTo(newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String fileType = pathMap.get("fileType").toString();
        Map<String, Object> map = new HashMap<String, Object>();
        //后缀
        map.put("suffix", suffix);
        //原文件名
        map.put("oldName", fileName.substring(0, fileName.lastIndexOf(".")));
        //新文件名
        map.put("newName", newName.substring(0, newName.lastIndexOf(".")));
        //文件大小
        map.put("fileSize", file.getSize());
        //路径
        map.put("url", model.getReadPath() + fileType + File.separator + newName);
        // 类型(0视/1文/2图片)
        map.put("type", getTypeByUrl(suffix));
        return map;
    }

    /**
     * 判断文件的类型：图片、视频、word。。。返回路径
     *
     * @param suffix 后缀名
     * @return
     */
    public Map<String, Object> filePath(String suffix, FileModel model) {
        Map<String, Object> map = new HashMap<String, Object>();
        String filePath = "";
        String fileType = "";
        if (suffix.equals("jpg") || suffix.equals("png")) {
            fileType = "images";
        } else if (suffix.equals("mov")) {
            fileType = "mov";
        } else if (suffix.equals("mp4")) {
            fileType = "mp4";
        } else if (suffix.equals("xlsx") || suffix.equals("xls")) {
            fileType = "excel";
        } else if (suffix.equals("pdf")) {
            fileType = "pdf";
        } else if (suffix.equals("ppt") || suffix.equals("pptx")) {
            fileType = "ppt";
        } else if (suffix.equals("doc") || suffix.equals("docx")) {
            fileType = "word";
        } else {
            fileType = "other";
        }
        filePath = model.getUploadPath() + fileType;
        map.put("filePath", filePath);
        map.put("fileType", fileType);
        return map;
    }

    public int getTypeByUrl(String suffix) {
        suffix = suffix.toLowerCase().trim();
        if (!"jpg".equals(suffix) && !"png".equals(suffix)) {
            if ("mov".equals(suffix) || "mp4".equals(suffix)) {
                return 0;
            } else {
                return 1;
            }
        }
        return 2;
    }
}
