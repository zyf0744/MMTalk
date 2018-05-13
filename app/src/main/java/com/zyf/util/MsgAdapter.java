package com.zyf.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyf.R;

import java.util.List;

public class MsgAdapter extends BaseAdapter {
    private List<ItemBean> mList;//数据源
    private LayoutInflater mInflater;//布局装载器对象

    // 通过构造方法将数据源与数据适配器关联起来
    // context:要使用当前的Adapter的界面对象
    public MsgAdapter(Context context, List<ItemBean> list) {
        mList = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    //ListView需要显示的数据数量
    public int getCount() {
        return mList.size();
    }

    @Override
    //指定的索引对应的数据项
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    //指定的索引对应的数据项ID
    public long getItemId(int position) {
        return position;
    }

    @Override
    //返回每一项的显示内容
    public View getView(int position, View convertView, ViewGroup parent) {
        //将布局文件转化为View对象
        ItemBean bean = mList.get(position);
        View view = null;
        String icon = "";
        TextView titleTextView = null;
        TextView contentTextView = null;
        TextView dateTextView = null;
        ImageView imageView = null;
        if("zyf0744".equals(bean.userName)){
            view = mInflater.inflate(R.layout.item_right,null);
            titleTextView = (TextView) view.findViewById(R.id.tv_title1);
            contentTextView = (TextView) view.findViewById(R.id.tv_content1);
            dateTextView = (TextView) view.findViewById(R.id.tv_date1);
            imageView = (ImageView) view.findViewById(R.id.iv_image1);
            imageView.setImageResource(R.drawable.man);
        }else  if("llb520".equals(bean.userName)  ){
            view = mInflater.inflate(R.layout.item_left,null);
            titleTextView = (TextView) view.findViewById(R.id.tv_title);
            contentTextView = (TextView) view.findViewById(R.id.tv_content);
            dateTextView = (TextView) view.findViewById(R.id.tv_date);
            imageView = (ImageView) view.findViewById(R.id.iv_image);

            imageView.setImageResource(R.drawable.women);
        }
        else{
            view = mInflater.inflate(R.layout.item_left,null);
        }

        /**
         * 找到item布局文件中对应的控件 
         */

        //获取相应索引的ItemBean对象


        /**
         * 设置控件的对应属性值 
         */
        //titleTextView.setText(bean.userName);
        titleTextView.setText("");
        contentTextView.setText(bean.itemContent);
        dateTextView.setText(bean.dateString);
        return view;
    }
}