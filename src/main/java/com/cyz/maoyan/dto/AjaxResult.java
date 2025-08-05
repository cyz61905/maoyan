package com.cyz.maoyan.dto;

import lombok.Data;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/5 下午7:56
 * @Version V1.0
 */

@Data
public class AjaxResult {
    private String msg;
    private Integer code;
    private Object data;
    public AjaxResult() {
    }
    public AjaxResult(String msg, Integer code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }
    public static AjaxResult success(Object data) {
        return new AjaxResult("操作成功", 200, data);
    }
    public static AjaxResult error() {
        return new AjaxResult("操作失败", 400, null);
    }
    public static AjaxResult error(String msg) {
        return new AjaxResult(msg, 400, null);
    }
    public AjaxResult msg(String msg){
        this.msg = msg;
        return this;
    }
    public AjaxResult code(Integer code){
        this.code = code;
        return this;
    }
    public AjaxResult data(Object data){
        this.data = data;
        return this;
    }
}
