package com.bortherx.upload.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by MAC M1.
 *
 * @Author: Ax.
 * @Date: 2021/12/30.
 * @Description: 自定义响应数据结构
 *  * 				本类可提供给 H5/ios/安卓/公众号/小程序 使用
 *  * 				前端接受此类数据（json object)后，可自行根据业务去实现相关功能
 *  *
 *  * 				200：表示成功
 *  * 				500：表示错误，错误信息在msg字段中
 *  * 				501：bean验证错误，不管多少个错误都以map形式返回
 *  * 				502：拦截器拦截到用户token出错
 *  * 				555：异常抛出信息
 *  * 				556: 用户qq校验异常
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "请求结果响应体")
public class ResponseResultUtils<T> {
    @ApiModelProperty(value = "响应状态回执码")
    private Integer status;

    @ApiModelProperty(value = "数据体")
    private T result;

    @ApiModelProperty(value = "响应回执消息")
    private String message;

    @ApiModelProperty(value = "响应时间戳")
    private final long timestamps = System.currentTimeMillis();

    public synchronized static <T> ResponseResultUtils<T> success(T data) {
        ResponseResultUtils<T> res = new ResponseResultUtils<>();
        res.setStatus(200);
        res.setMessage("操作成功");
        res.setResult(data);
        return res;
    }

    public synchronized static <T> ResponseResultUtils<T> success(String message) {
        ResponseResultUtils<T> res = new ResponseResultUtils<>();
        res.setStatus(200);
        res.setMessage(message);
        res.setResult(null);
        return res;
    }

    public synchronized static <T> ResponseResultUtils<T> e(ResponseStatusEnum statusEnum) {
        return e(statusEnum, statusEnum.msg);
    }

    public synchronized static <T> ResponseResultUtils<T> error(String message) {
        ResponseResultUtils<T> res = new ResponseResultUtils<>();
        res.setStatus(400);
        res.setMessage(message);
        res.setResult(null);
        return res;
    }

    public synchronized static <T> ResponseResultUtils<T> success(ResponseStatusEnum statusEnum, T data) {
        ResponseResultUtils<T> res = new ResponseResultUtils<>();
        res.setStatus(statusEnum.code);
        res.setMessage(statusEnum.msg);
        res.setResult(data);
        return res;
    }
    public synchronized static <T> ResponseResultUtils<T> e(ResponseStatusEnum statusEnum, T data) {
        ResponseResultUtils<T> res = new ResponseResultUtils<>();
        res.setStatus(statusEnum.code);
        res.setMessage(statusEnum.msg);
        res.setResult(data);
        return res;
    }
    public synchronized static <T> ResponseResultUtils<T> e(ResponseStatusEnum statusEnum,String message) {
        ResponseResultUtils<T> res = new ResponseResultUtils<>();
        res.setStatus(statusEnum.code);
        res.setMessage(message);
        res.setResult(null);
        return res;
    }


    private static final long serialVersionUID = 8992436576262574064L;
}
