package com.zhj.androidmvpdemo.presenter;

/**
 * Created by hjzhang on 2016/8/23.
 */
public interface BookPresenter {
    void loadListData(String q, int start, int count);
    void onItemClickListener(int position);
}
