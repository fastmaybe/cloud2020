package com.fastmay.springcloud.pojo.result;

/**
 * @Author: liulang
 * @Date: 2020/12/28 17:15
 */
@SuppressWarnings("all")
public enum DYCode {

    /**
     * 通用枚举
     */
    SUCCESS(0, "ok"),
    ERROR(-1, "error");




    private Integer code;
    private String message;



   DYCode(Integer code,String message){
        this.code = code;
        this.message = message;
   }


    public <T> CommonResult result(){
        return new CommonResult(code,message,null);
    }

    public <T> CommonResult result(String message){
        return new CommonResult(this.code,message,null);
    }

   public <T> CommonResult result(T data){
       return new CommonResult(this.code,this.message,data);
   }

    public <T> CommonResult result(T data,String message){
        return new CommonResult(this.code,message,data);
    }


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
