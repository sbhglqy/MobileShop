package com.edu.huatec.mobileshop.http.service;


import com.edu.huatec.mobileshop.http.entity.GoodsDetailEntity;
import com.edu.huatec.mobileshop.http.entity.GoodsEntity;
import com.edu.huatec.mobileshop.http.entity.HttpResult;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2019/11/11 0011.
 */

public interface GoodsService {

    //获取商品详情
    @GET("goods/union/{goodsId}")
    Observable<HttpResult<GoodsDetailEntity>> goodsDetail (
        @Path("goodsId")int goodsId
    );

    @FormUrlEncoded
    @POST("goods/find")
    Observable<HttpResult<List<GoodsEntity>>> listByKeywords(
            @Field("input") String keywords
    );

    //根据二级分类的id获取商品列表
    @GET("goods/cat/{catId}")
    Observable<HttpResult<List<GoodsEntity>>> list(
            @Path("catId") int catId
    );
}
