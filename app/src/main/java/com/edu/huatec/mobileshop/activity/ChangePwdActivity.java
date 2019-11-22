package com.edu.huatec.mobileshop.activity;

import android.widget.TextView;

import com.edu.huatec.mobileshop.R;
import com.edu.huatec.mobileshop.common.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/11/12 0012.
 */

public class ChangePwdActivity extends BaseActivity{
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public int getContentViewId() { return R.layout.activity_change_pwd;}

    @Override
    protected void initView(){
        super.initView();
        tvTitle.setText("修改密码");
    }

    @OnClick(R.id.iv_back)
    void close(){ finish(); }
}
