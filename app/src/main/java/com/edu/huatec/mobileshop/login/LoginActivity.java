//package com.edu.huatec.mobileshop.login;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.edu.huatec.mobileshop.R;
//import com.edu.huatec.mobileshop.common.BaseActivity;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//import butterknife.Unbinder;
//
///**
// * Created by Administrator on 2019/10/23 0023.
// */
//
//public class LoginActivity extends BaseActivity<LoginView,LoginPresenter> implements LoginView{
//    @Inject
//    LoginPresenter loginPresenter;
//    private Unbinder unbinder;
//
//    @BindView(R.id.et_user_name)
//    EditText etUserName;
//    @BindView(R.id.et_user_pwd)
//    EditText etUserPwd;
//
//    @OnClick(R.id.bt_login)
//    void login() {
//        String username=etUserName.getText().toString();
//        String password=etUserPwd.getText().toString();
//        Toast.makeText(this,username+password,Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void injectDependencies(){
//        getActivityComponent().inject(this);
//    }
//
//    @Override
//    protected LoginPresenter createPresenter(){
//        return loginPresenter;
//    }
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        unbinder= ButterKnife.bind(this);
//    }
//
//
//}
