package com.github.hollykunge.security.common.msg;

/**
 * 列表返回类型
 *
 * @author 协同设计小组
 * @create 2017-06-09 7:32
 */
public class ListRestResponse<T> extends BaseResponse {
    String msg;
    T result;
    int count;



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ListRestResponse count(int count) {
        this.setCount(count);
        return this;
    }

    public ListRestResponse count(Long count) {
        this.setCount(count.intValue());
        return this;
    }

    public ListRestResponse msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    public ListRestResponse result(T result) {
        this.setResult(result);
        return this;
    }

    public ListRestResponse(String msg, int count,T result){
        this.count = count;
        this.msg = msg;
        this.result = result;
    }
}
