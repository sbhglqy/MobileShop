package com.edu.huatec.mobileshop.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.edu.huatec.mobileshop.R;
import com.edu.huatec.mobileshop.activity.GoodsListActivity;
import com.edu.huatec.mobileshop.adapter.CategoryLeftAdapter;
import com.edu.huatec.mobileshop.adapter  .CategoryRightAdapter;
import com.edu.huatec.mobileshop.common.BaseFragment;
import com.edu.huatec.mobileshop.http.ProgressDialogSubscriber;
import com.edu.huatec.mobileshop.http.entity.CategoryEntity;
import com.edu.huatec.mobileshop.http.presenter.CategoryPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/10/11 0011.
 */

public class CategoryFragment extends BaseFragment {

    @BindView(R.id.rv_left)
    RecyclerView rv_left;
    @BindView(R.id.rv_right)
    RecyclerView rv_right;

    private List<CategoryEntity> leftData;
    private List<CategoryEntity> rightData;
    private CategoryLeftAdapter leftAdapter;
    private CategoryRightAdapter rightAdapter;

    @Override
    public int getContentViewId(){ return R.layout.fragment_category;}

    @OnClick(R.id.ll_search)
    void search() { toastShort("开发中...");}

    @Override
    protected void initData(){
        super.initData();
        //获取一级列表
        CategoryPresenter.getTopList(new ProgressDialogSubscriber<List<CategoryEntity>>(getActivity()){
            @Override
            public void onNext(List<CategoryEntity> categoryEntities){
                leftData.clear();
                leftData.addAll(categoryEntities);
                //刷新列表
                leftAdapter.notifyDataSetChanged();
                //左边选中的位置 刷新UI
                leftAdapter.setSelect(0);
                //加载二级列表
                loadSecondList(0);
            }
        });
    }

    private void loadSecondList(int pos){
        if(leftData==null||leftData.size()==0){
            return;
        }

        CategoryEntity entity=leftData.get(pos);
        CategoryPresenter.getSecondList(new ProgressDialogSubscriber<List<CategoryEntity>>(getActivity()){
           @Override
            public void onNext(List<CategoryEntity> categoryEntities){
               rightData.clear();
               rightData.addAll(categoryEntities);
               rightAdapter.notifyDataSetChanged();
           }
        },entity.getCat_id());
    }

    @Override
    protected void initView(View view){
        super.initView(view);
        leftData=new ArrayList<>();
        rightData=new ArrayList<>();

        //设置列表样式
        LinearLayoutManager leftManager=new LinearLayoutManager(getActivity());
        leftManager.setOrientation(OrientationHelper.VERTICAL);
        rv_left.setLayoutManager(leftManager);

        //垂直表格
        GridLayoutManager rightManager=new GridLayoutManager(getActivity(),3,OrientationHelper.VERTICAL,false);
        rv_right.setLayoutManager(rightManager);

        leftAdapter=new CategoryLeftAdapter(getActivity(),leftData);
        leftAdapter.setOnItemClickListener(new CategoryLeftAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view,int position,CategoryEntity entity){
                //左边选中的位置 刷新UI
                leftAdapter.setSelect(position);
                //加载二级列表
                loadSecondList(position);
            }
        });
        rightAdapter=new CategoryRightAdapter(getActivity(),rightData);
        rightAdapter.setOnItemClickListener(new CategoryRightAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(View view, int position, CategoryEntity entity) {
                //跳转到商品列表界面
                Intent intent=new Intent(getActivity(), GoodsListActivity.class);
                intent.putExtra("cat_id",entity.getCat_id());
                startActivity(intent);
            }
        });
        rv_left.setAdapter(leftAdapter);
        rv_right.setAdapter(rightAdapter);
    }

}
