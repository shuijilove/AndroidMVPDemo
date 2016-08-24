package com.zhj.androidmvpdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zhj.androidmvpdemo.R;
import com.zhj.androidmvpdemo.adapter.BookAdapter;
import com.zhj.androidmvpdemo.model.Book;
import com.zhj.androidmvpdemo.presenter.impl.BookPresenterImpl;
import com.zhj.androidmvpdemo.util.SpaceItemDecoration;
import com.zhj.androidmvpdemo.view.BookView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by hjzhang on 2016/8/23.
 */
public class BookActivity extends AppCompatActivity implements BookView{
    private Toolbar toolbar;
    private XRecyclerView rv_list;
    private List<Book> bookList = new ArrayList<>();
    private BookAdapter adapter;
    private BookPresenterImpl bookPresenter;
    private int start = 0;
    private String key;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ac_book_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        key = getIntent().getStringExtra("key");

        bookPresenter = new BookPresenterImpl(BookActivity.this,this);

        rv_list = (XRecyclerView) findViewById(R.id.rv_list);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        SpaceItemDecoration space = new SpaceItemDecoration(12);
        rv_list.addItemDecoration(space);
        rv_list.setLayoutManager(manager);
        adapter = new BookAdapter(this,R.layout.list_item_book,bookList);
        rv_list.setAdapter(adapter);

        rv_list.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                start = 0;
                bookPresenter.loadListData(key,start,10);
            }

            @Override
            public void onLoadMore() {
                start +=10;
                bookPresenter.loadListData(key,start,10);
            }
        });
        bookPresenter.loadListData(key,start,10);
    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void refreshListData(List<Book> items) {
        rv_list.refreshComplete();
        bookList.clear();
        bookList.addAll(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void addMoreListData(List<Book> items) {
        rv_list.loadMoreComplete();
        bookList.addAll(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
