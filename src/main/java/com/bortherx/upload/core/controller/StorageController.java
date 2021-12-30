package com.bortherx.upload.core.controller;

import com.bortherx.upload.core.storage.StorageService;
import com.bortherx.upload.utils.ResponseResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by MAC M1.
 *
 * @Author: Ax.
 * @Date: 2021/12/30.
 * @Description: http请求接口.
 */
@RestController
@RequestMapping(value = "/storage")
@Api(tags = {"资源管理接口"})
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping("/crete")
    @ApiOperation(value = "上传文件")
    public ResponseResultUtils<String> create(@RequestParam("file") MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        try {

            String path = storageService.upload(file.getInputStream(), file.getSize(),
                    file.getContentType(), originalFilename);
            return ResponseResultUtils.success(path);
        } catch (IOException e) {
            return ResponseResultUtils.error("上传文件失败");
        }
    }
}
