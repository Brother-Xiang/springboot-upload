package com.bortherx.upload.core.storage;

import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by MAC M1.
 *
 * @Author: Ax.
 * @Date: 2021/12/30.
 * @Description: 对象存储接口，抽取公共方法.
 */
public interface Storage {
    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param keyName       文件名
     */
    void store(InputStream inputStream, long contentLength, String contentType, String keyName);

    /**
     * 查询所有
     * @return
     */
    Stream<Path> loadAll();

    /**
     * 查询
     * @param keyName
     * @return
     */
    Path load(String keyName);

    /**
     * 查询
     * @param keyName
     * @return
     */
    Resource loadAsResource(String keyName);

    /**
     * 删除
     * @param keyName
     */
    void delete(String keyName);


    String generateUrl(String keyName);
}
