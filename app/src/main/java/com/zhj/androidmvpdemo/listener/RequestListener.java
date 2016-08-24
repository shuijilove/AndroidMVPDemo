package com.zhj.androidmvpdemo.listener;

/**
 * Created by hjzhang on 2016/8/23.
 */
public interface RequestListener<T> {
    /**
     *
     * @param tag
     * @param data
     */
    void onSuccess(int tag,T data);

    /**
     * @param msg
     */
    void onError(String msg);

    /**
     * @param msg
     */
    void onException(String msg);
}
