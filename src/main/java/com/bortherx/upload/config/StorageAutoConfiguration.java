package com.bortherx.upload.config;

import com.bortherx.upload.core.storage.LocalStorage;
import com.bortherx.upload.core.storage.StorageService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by MAC M1.
 *
 * @Author: Ax.
 * @Date: 2021/12/30.
 * @Description: 配置文件自动装配.
 */
@Configuration
@EnableConfigurationProperties(StorageProperties.class)
public class StorageAutoConfiguration {
    private final StorageProperties properties;


    public StorageAutoConfiguration(StorageProperties properties) {
        this.properties = properties;
    }
    @Bean
    public StorageService storageService() {
        StorageService storageService = new StorageService();
        String active = this.properties.getActive();
        storageService.setActive(active);
        if ("local".equals(active)) {
            storageService.setStorage(localStorage());
        } else {
            throw new RuntimeException("当前存储模式 " + active + " 不支持");
        }

        return storageService;
    }
    @Bean
    public LocalStorage localStorage() {
        LocalStorage localStorage = new LocalStorage();
        StorageProperties.Local local = this.properties.getLocal();
        localStorage.setAddress(local.getAddress());
        localStorage.setStoragePath(local.getStoragePath());
        return localStorage;
    }
}
