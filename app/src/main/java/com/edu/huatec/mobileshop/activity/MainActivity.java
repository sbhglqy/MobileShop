package com.edu.huatec.mobileshop.activity;


import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.edu.huatec.mobileshop.R;
import com.edu.huatec.mobileshop.common.BaseActivity;
import com.edu.huatec.mobileshop.fragment.NavigationFragment;

public class MainActivity extends BaseActivity {

    @Override
    public @LayoutRes
    int getContentViewId(){
        return R.layout.activity_main;
    }

    @Override
    protected void initView(){
        super.initView();
        //将Fragment添加到Activity中
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.f1_main,new NavigationFragment());
        transaction.commit();
    }
//    @Override
//    protected MainPresenter createPresenter(){ return mainPresenter;}
//
//    @Inject
//    MainPresenter mainPresenter;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//    }
}
