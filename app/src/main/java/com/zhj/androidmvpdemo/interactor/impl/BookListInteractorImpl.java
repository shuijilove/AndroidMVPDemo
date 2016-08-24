package com.zhj.androidmvpdemo.interactor.impl;

import com.zhj.androidmvpdemo.API.API;
import com.zhj.androidmvpdemo.API.Common;
import com.zhj.androidmvpdemo.interactor.BookListInteractor;
import com.zhj.androidmvpdemo.listener.RequestListener;
import com.zhj.androidmvpdemo.model.Book;
import com.zhj.androidmvpdemo.util.FastJsonTools;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONObject;

import java.util.List;

import okhttp3.Call;

/**
 * Created by hjzhang on 2016/8/23.
 */
public class BookListInteractorImpl implements BookListInteractor {
    private RequestListener<List<Book>> listener = null;
    public BookListInteractorImpl(RequestListener<List<Book>> listener){
        this.listener = listener;
    }
    @Override
    public void getBookList(String q, final int start, int count) {
        OkHttpUtils.get().url(API.SEARCH_BOOK).addParams("q",q).addParams("start",start+"").addParams("count","10").build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                listener.onError(e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                try {
                    JSONObject json= new JSONObject(response);
                    String books = json.getString("books");
                    List<Book> tempList = FastJsonTools.getArrayJson(books,Book.class);
                    if(tempList!=null){
                        if(start == 0){
                            listener.onSuccess(Common.REFRESH_DATA,tempList);
                        }else{
                            listener.onSuccess(Common.LOADMORE_DATA,tempList);
                        }
                    }else{
                        listener.onError("没有数据");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
