package com.edu.huatec.mobileshop.http.service;


import com.edu.huatec.mobileshop.http.entity.HttpResult;
import com.edu.huatec.mobileshop.http.entity.MemberEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2019/11/11 0011.
 */

public interface MemberService {
    @FormUrlEncoded
    @POST("member/login2")
    Observable<HttpResult<MemberEntity>> login2(
            @Field("input") String input,
            @Field("password") String password
    );

    //用户注册
    @FormUrlEncoded
    @POST("member")
    Observable<HttpResult<MemberEntity>> register(
            @Field("uname") String uname,
            @Field("password") String password,
            @Field("email") String email
    );

    //修改密码
    @FormUrlEncoded
    @PUT("member/{memberId}")
    Observable<HttpResult> changePassword(
            @Path("memberId") String memberId,
            @Path("old_pwd") String old_pwd,
            @Path("new_pwd") String new_pwd
    );
}
