package com.example.dxnima.zhidao.bean.table;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 用户登陆表
 * Created by DXnima on 2019/4/2.
 */
@Entity
public class User {

    private String username;

    private String password;

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Generated(hash = 2090636610)
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Generated(hash = 586692638)
    public User() {
    }


}