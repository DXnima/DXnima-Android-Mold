package com.example.dxnima.zhidao.bean.home;

import com.example.dxnima.zhidao.bean.BaseResp;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by DXnima on 2019/4/1.
 */
@Entity
public class LoginResponse extends BaseResp{
    private String userId;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Generated(hash = 586478210)
    public LoginResponse(String userId) {
        this.userId = userId;
    }

    @Generated(hash = 1521785954)
    public LoginResponse() {
    }
    
}