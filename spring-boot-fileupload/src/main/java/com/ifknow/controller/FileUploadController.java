package com.ifknow.controller;

import com.ifknow.config.ObtainProperties;
import com.ifknow.utils.FileModel;
import com.ifknow.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ifknow <br>
 * @Date: 2020/8/25  9:59 <br>
 * @Description: NO Description
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private ObtainProperties obtainProperties;

    @PostMapping("/upload")
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        FileModel model = new FileModel().setUploadPath(obtainProperties.getUploadFile().getUploadPath()).setReadPath(obtainProperties.getUploadFile().getReadPath());
        FileUtil uploadUtil = new FileUtil();
        Map<String, Object> map = uploadUtil.upload(file, request, model);
        log.info(file.getOriginalFilename() + "  上传成功");
        return map;
    }
}
