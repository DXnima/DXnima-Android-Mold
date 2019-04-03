package com.example.dxnima.zhidao.ui.personcenter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.dxnima.zhidao.R;
import com.example.dxnima.zhidao.ui.base.BaseActivity;

/**
 * Created by DXnima on 2019/4/3.
 */
public class WelcomeActivity extends BaseActivity{

    private final int SPLASH_DISPLAY_LENGHT = 3000;  //延迟3秒

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_lunch);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);//跳转到登陆页面
                WelcomeActivity.this.startActivity(intent);
                WelcomeActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }

    @Override
    public void initViews() {

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