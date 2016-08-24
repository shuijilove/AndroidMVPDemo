package com.zhj.androidmvpdemo.presenter.impl;

import android.content.Context;

import com.zhj.androidmvpdemo.API.Common;
import com.zhj.androidmvpdemo.interactor.impl.BookListInteractorImpl;
import com.zhj.androidmvpdemo.listener.RequestListener;
import com.zhj.androidmvpdemo.model.Book;
import com.zhj.androidmvpdemo.presenter.BookPresenter;
import com.zhj.androidmvpdemo.view.BookView;

import java.util.List;

/**
 * Created by hjzhang on 2016/8/23.
 */
public class BookPresenterImpl implements BookPresenter,RequestListener<List<Book>> {
    private Context mContext;
    private BookView bookView;
    private BookListInteractorImpl bookListInteractor;
    public BookPresenterImpl(Context context,BookView bookView){
        this.mContext = context;
        this.bookView = bookView;
        bookListInteractor = new BookListInteractorImpl(this);
    }
    @Override
    public void loadListData(String q, int start, int count) {
        bookListInteractor.getBookList(q,start,count);
    }

    @Override
    public void onItemClickListener(int position) {

    }

    @Override
    public void onSuccess(int tag,List<Book> data) {
        if(tag == Common.REFRESH_DATA){
            bookView.refreshListData(data);
        }else if(tag == Common.LOADMORE_DATA){
            bookView.addMoreListData(data);
        }
    }

    @Override
    public void onError(String msg) {
        bookView.showMessage(msg);
    }

    @Override
    public void onException(String msg) {
        bookView.showMessage(msg);
    }
}
