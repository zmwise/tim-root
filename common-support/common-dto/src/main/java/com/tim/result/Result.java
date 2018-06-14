package com.tim.result;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @description: 返回结果对象
 * @author: lizhiming
 * @since: 2017/11/25
 */
public class Result {

    private int code;
    private String msg;
    private Object data;

    /**
     * 数据
     */
    private HashMap<String, Object> map;

    public Result() {
        this.code = 0;
        this.msg = "";
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 设置结果数据
     *
     * @author oudebin
     * @param data
     */
    public void put(String key, Object data) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(key, data);
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        if(data==null){
            if (map != null) {
                JSONObject json = new JSONObject();
                Iterator<String> iterator = map.keySet().iterator();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    json.put(key, map.get(key));
                }
                this.data = json;
            }
        }
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
