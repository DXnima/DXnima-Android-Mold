package com.example.dxnima.zhidao.ui.personcenter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dxnima.zhidao.R;
import com.example.dxnima.zhidao.biz.personcenter.IUserLoginView;
import com.example.dxnima.zhidao.biz.personcenter.LoginPresenter;
import com.example.dxnima.zhidao.constant.Event;
import com.example.dxnima.zhidao.ui.base.BaseActivity;

/**
 * 登录界面（LoginActivity），只要继承BaseActivity则可以了
 * Created by DXnima on 2019/4/1.
 */
public class LoginActivity extends BaseActivity implements IUserLoginView{

    /**
     * 用户名
     */
    private EditText userName;

    /**
     * 用户密码
     */
    private EditText password;

    /**
     * 登录按钮
     */
    private Button login;

    private LoginPresenter mUserLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        presenter = mUserLoginPresenter = new LoginPresenter();
        mUserLoginPresenter.attachView(this);
    }

    /**
     * 初始化布局组件
     */
    @Override
    public void initViews() {
        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.passowrd);
        login = (Button) findViewById(R.id.login);
    }


    //按钮点击事件
    @Override
    public void initListeners() {
        login.setOnClickListener(this);
    }


    //初始化数据
    @Override
    public void initData() {

    }

    // 初始化公共头部
    @Override
    public void setHeader() {
        super.setHeader();
        title.setText("登录");
    }

    @Override
    public void onEventMainThread(Event event) {
        super.onEventMainThread(event);
        switch (event){
            case IMAGE_LOADER_SUCCESS:
                clearEditContent();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                mUserLoginPresenter.login(userName.getText().toString(), password.getText().toString());
                break;
        }
        super.onClick(v);
    }

    @Override
    public void clearEditContent() {
        userName.setText("");
        password.setText("");
    }

    @Override
    public void onError(String errorMsg, String code) {

        showToast(errorMsg);
    }

    @Override
    public void onSuccess() {
        //成功打开新界面homeactivity
        startActivity(HomeActivity.class,null);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}