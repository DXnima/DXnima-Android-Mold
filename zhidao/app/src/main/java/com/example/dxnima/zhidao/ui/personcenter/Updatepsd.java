package com.example.dxnima.zhidao.ui.personcenter;

import android.os.Bundle;

import com.example.dxnima.zhidao.R;
import com.example.dxnima.zhidao.ui.base.BaseActivity;

/**
 * Created by DXnima on 2019/4/3.
 */
public class Updatepsd extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_udatepsd);
        setHeader();
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initViews() {
        //setContentView(R.layout.activity_udatepsd);
    }

    // 初始化公共头部
    @Override
    public void setHeader() {
        super.setHeader();
        title.setText("修改密码");
    }

    @Override
    public void initListeners() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onError(String errorMsg, String code) {

    }

    @Override
    public void onSuccess(String errorMsg, String code) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}