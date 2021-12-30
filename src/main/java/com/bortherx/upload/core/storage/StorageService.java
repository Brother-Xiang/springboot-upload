package com.bortherx.upload.core.storage;

import com.bortherx.upload.utils.CharUtil;

import java.io.InputStream;

/**
 * Created by MAC M1.
 *
 * @Author: Ax.
 * @Date: 2021/12/30.
 * @Description: 提供存储服务类，所有存储服务均由该类对外提供.
 */
public class StorageService {
    private String active;
    private Storage storage;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param fileName      文件索引名
     * @return
     */
    public String upload(InputStream inputStream, long contentLength, String contentType, String fileName) {
        String key = generateKey(fileName);
        storage.store(inputStream, contentLength, contentType, key);
        return generateUrl(key);
    }

    private String generateUrl(String keyName) {
        return storage.generateUrl(keyName);
    }

    private String generateKey(String originalFilename) {
        int index = originalFilename.lastIndexOf('.');
        String suffix = originalFilename.substring(index);
        String key = null;
        return CharUtil.getRandomString(20) + suffix;
    }
}
