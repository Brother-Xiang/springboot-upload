package com.bortherx.upload.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by MAC M1.
 *
 * @Author: Ax.
 * @Date: 2021/12/30.
 * @Description: 1.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ResponseStatusEnum {
    /**
     * 操作成功
     */
    SUCCESS(200,"操作成功"),
    /**
     * 操作失败
     */
    ERROR(400,"操作失败"),
    ;
    public Integer code;

    public String msg;
}
