package com.example.dxnima.zhidao.ui.personcenter;

import com.example.dxnima.zhidao.R;
import com.example.dxnima.zhidao.ui.base.BaseActivity;

/**
 * 页面活动互动
 * Created by DXnima on 2019/4/1.
 */
public class HomeActivity extends BaseActivity {

    /**
     * 初始化布局组件
     */
    @Override
    public void initViews(){
        setContentView(R.layout.activity_main);
    }

    /**
     * 增加按钮点击事件
     */
    @Override
    public void initListeners(){}

    /**
     * 初始化数据
     */
    @Override
    public void initData(){}


    @Override
    public void onError(String errorMsg, String code){
        showToast(errorMsg);
    }

    @Override
    public void onSuccess(String errorMsg, String code){}

    @Override
    public void showLoading(){}

    @Override
    public void hideLoading(){}
}