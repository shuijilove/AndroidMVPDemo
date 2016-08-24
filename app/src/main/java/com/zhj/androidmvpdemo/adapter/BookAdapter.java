package com.zhj.androidmvpdemo.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhj.androidmvpdemo.R;
import com.zhj.androidmvpdemo.model.Book;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by hjzhang on 2016/8/23.
 */
public class BookAdapter extends CommonAdapter<Book> {
    public BookAdapter(Context context, int layoutId, List<Book> datas) {
        super(context, layoutId, datas);
    }
    @Override
    protected void convert(ViewHolder holder, Book book, int position) {
        ImageView iv = holder.getView(R.id.iv);
        TextView tv_title = holder.getView(R.id.tv_title);
        TextView tv_author = holder.getView(R.id.tv_author);
        TextView tv_time = holder.getView(R.id.tv_time);
        TextView tv_summary = holder.getView(R.id.tv_summary);
        Picasso.with(mContext).load(book.getImage()).into(iv);
        tv_title.setText(book.getTitle());
        tv_author.setText(book.getAuthor()!=null&&book.getAuthor().size()>0?book.getAuthor().get(0):"无名");
        tv_time.setText("出版日期："+book.getPubdate());
        tv_summary.setText(book.getSummary());
    }
}
