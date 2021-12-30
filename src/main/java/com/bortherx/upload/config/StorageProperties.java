package com.bortherx.upload.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by MAC M1.
 *
 * @Author: Ax.
 * @Date: 2021/12/30.
 * @Description: 配置.
 */
@ConfigurationProperties(prefix = "bortherx.storage")
public class StorageProperties {
    private String active;
    private Local local;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    /**
     * 内部类
     */
    public static class Local{
        private String address;
        private String storagePath;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getStoragePath() {
            return storagePath;
        }

        public void setStoragePath(String storagePath) {
            this.storagePath = storagePath;
        }
    }
}
