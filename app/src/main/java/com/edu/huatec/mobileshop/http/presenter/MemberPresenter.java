package com.edu.huatec.mobileshop.http.presenter;


import com.edu.huatec.mobileshop.http.HttpMethods;
import com.edu.huatec.mobileshop.http.entity.MemberEntity;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2019/11/11 0011.
 */

public class MemberPresenter extends HttpMethods {

    //用户注册
    public static void register(Subscriber<MemberEntity> subscriber, String username, String email, String password){
        Observable observable = memberService.register(username,password,email)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribe(observable,subscriber);
    }

    //用户登录
    public static void login2(Subscriber<MemberEntity> subscriber,String username,String password){
        Observable observable = memberService.login2(username,password)
                .map(new HttpResultFunc<MemberEntity>());
        toSubscribe(observable,subscriber);
    }

    //修改密码
    public static void changePassword(Subscriber subscriber,String memberId,String old_pwd,String new_pwd){
        Observable observable = memberService.changePassword(memberId, old_pwd, new_pwd);
        toSubscribe(observable,subscriber);
    }
}
