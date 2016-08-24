package com.zhj.androidmvpdemo.view;

import com.zhj.androidmvpdemo.model.Book;

import java.util.List;

/**
 * Created by hjzhang on 2016/8/23.
 */
public interface BookView {
    void showLoading(String msg);

    void hideLoading();

    void refreshListData(List<Book> items);

    void addMoreListData(List<Book> items);

    void showMessage(String message);
}
