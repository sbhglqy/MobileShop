//package com.edu.huatec.mobileshop.fragment;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import com.bumptech.glide.Glide;
//import com.edu.huatec.mobileshop.R;
//
///**
// * Created by Administrator on 2019/10/23 0023.
// */
//
//public class MessageFragment {
//    @Override
//    protected MessagePresenter createPresenter(){ return messagePresenter;}
//
//    @Override
//    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
//        View view=inflater.inflate(R.layout.fragment_message,container,false);
//        ImageView imageView=(ImageView)view.findViewById(R.id.iv_image);
//        Glide.with(this)
//                .load("https://static.oschina.net/uploads/space/2017/0325/085809_5wxz_2945455.png")
//                .into(imageView);
//        return view;
//    }
//}
