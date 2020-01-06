package com.cc1500.web.Result;


import com.cc1500.web.utils.SimplePropertyPreFilter;

import java.util.Objects;

public class ResultVo {
    private String msg;
    private  Integer code;
    private  Object data;

    public ResultVo(String msg, Integer code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public ResultVo(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public ResultVo(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultVo(Integer code){
        this.code=code;
    }

    public static String successful(String msg){
        return  SimplePropertyPreFilter.excludeJson(new ResultVo(msg,0));
    }

    public static String failure(String msg){
        return  SimplePropertyPreFilter.excludeJson(new ResultVo(msg,500));
    }

    public static String successful(){
        return  SimplePropertyPreFilter.excludeJson(new ResultVo("请求成功",0));
    }

    public static String successful(Object data){
        return  SimplePropertyPreFilter.excludeJson(new ResultVo("请求成功",0,data));
    }
    public static String failure(Object data){
        return  SimplePropertyPreFilter.excludeJson(new ResultVo("请求失败",0,data));
    }


    public static String failure(){
        return  SimplePropertyPreFilter.excludeJson(new ResultVo("请求失败",500));
    }
    public static String success(String mgs,Integer code,Object data,String...strings){
        return  SimplePropertyPreFilter.excludeJson(new ResultVo(mgs,code,data),strings);
    }

    public static String error(String mgs,Integer code,Object data,String...strings){
        return   SimplePropertyPreFilter.excludeJson(new ResultVo(mgs,code,data),strings);
    }

    public static ResultVo successByObject(String msg, Integer code, Object data, String...strings){
        return  new ResultVo(msg,code,data);
    }

    public static ResultVo errorByObject(String msg, Integer code, Object data){
        return   new ResultVo(msg,code,data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ResultVo)){ return false;}
        ResultVo resultVo = (ResultVo) o;
        return Objects.equals(msg, resultVo.msg) &&
                Objects.equals(code, resultVo.code) &&
                Objects.equals(data, resultVo.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(msg, code, data);
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
