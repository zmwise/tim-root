package com.tim.result;

import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Map;

/**
 * @description: 返回结果生成工厂类
 * @author: lizhiming
 * @since: 2017/11/25
 */
public class ResultFactory {

    private static final Result SUCCESS_RESULT = new Result(Status.SUCCESS, Status.SUCCESS_MSG);

    private ResultFactory() {
    }

    /**
     * 生成返回成功结果
     */
    public static Result successResult() {
        return SUCCESS_RESULT;
    }

    /**
     * 生成返回成功结果T data
     */
    public static Result successData(Object data){
        return new Result(Status.SUCCESS, Status.SUCCESS_MSG,data);
    }

    /**
     * 生成返回成功结果List<T> listData
     * @param listData
     * @return
     */
    public static Result successData(List<T> listData){
        return new Result(Status.SUCCESS, Status.SUCCESS_MSG,listData);
    }

    /**
     * 生成返回成功结果List<T> pageData
     * @param pageData
     * @return  */
    public static Result successData(Page<T> pageData){
        return new Result(Status.SUCCESS, Status.SUCCESS_MSG,pageData);
    }


    /**
     * 生成返回结果
     *
     * @param code
     *            错误码
     * @param msg
     *            消息文本
     * @return 结果对象
     */
    public static Result result(int code, String msg) {
        return new Result(code, msg);
    }

    /**
     * 生成返回结果
     *
     * @param code
     *            错误码
     * @param msg
     *            消息文本
     * @param listData
     *            数据对象
     * @return 结果对象
     */
    public static Result result(int code, String msg, List<T> listData) {
        return new Result(code, msg, listData);
    }

    /**
     * 生成返回结果
     *
     * @param code
     *            错误码
     * @param msg
     *            消息文本
     * @param data
     *            数据对象
     * @return 结果对象
     */
    public static <T> Result result(int code, String msg, T data) {
        return new Result(code, msg, data);
    }

    /**
     * 生成返回结果
     *
     * @param code
     *            错误码
     * @param msg
     *            消息文本
     * @param mapData
     *            数据对象
     * @return 结果对象
     */
    public static <K, V> Result result(int code, String msg, Map<K, V> mapData) {
        return new Result(code, msg, mapData);
    }
}
