package com.example.dxnima.zhidao.biz.personcenter;

import android.util.Log;

import com.example.dxnima.zhidao.ZDApplication;
import com.example.dxnima.zhidao.bean.table.User;
import com.example.dxnima.zhidao.biz.BasePresenter;
import com.example.dxnima.zhidao.bridge.BridgeFactory;
import com.example.dxnima.zhidao.bridge.Bridges;
import com.example.dxnima.zhidao.bridge.cache.sharePref.EBSharedPrefManager;
import com.example.dxnima.zhidao.bridge.cache.sharePref.EBSharedPrefUser;
import com.example.dxnima.zhidao.bridge.http.OkHttpManager;
import com.example.dxnima.zhidao.capabilities.http.ITRequestResult;
import com.example.dxnima.zhidao.capabilities.http.Param;
import com.example.dxnima.zhidao.constant.URLUtil;
import com.example.dxnima.zhidao.dao.greendao.DaoSession;
import com.example.dxnima.zhidao.dao.greendao.UserDao;

import java.util.List;

/**
 *
 * Created by DXnima on 2019/4/2.
 */
public class UserPresenter extends BasePresenter<IUserLoginView> {

    public UserPresenter() {
    }

    DaoSession daoSession =ZDApplication.getInstances().getDaoSession();

    //网络层登陆实现
    public void loginInternet(String useName, String password) {

        //网络层
        mvpView.showLoading();
        com.example.dxnima.zhidao.bridge.security.SecurityManager securityManager = BridgeFactory.getBridge(Bridges.SECURITY);
        OkHttpManager httpManager = BridgeFactory.getBridge(Bridges.HTTP);

        httpManager.requestAsyncPostByTag(URLUtil.USER_LOGIN, getName(), new ITRequestResult<UserPresenter>() {
                    @Override
                    public void onCompleted() {
                        mvpView.hideLoading();
                    }

                    @Override
                    public void onSuccessful(UserPresenter entity) {
                        mvpView.onSuccess("登陆成功！","");
                        EBSharedPrefManager manager = BridgeFactory.getBridge(Bridges.SHARED_PREFERENCE);
                        manager.getKDPreferenceUserInfo().saveString(EBSharedPrefUser.USER_NAME, "abc");
                    }

                    @Override
                    public void onFailure(String errorMsg) {
                        mvpView.onError(errorMsg, "");
                    }

                }, UserPresenter.class, new Param("username", useName),
                new Param("pas", securityManager.get32MD5Str(password)));

    }

    //本地数据库登陆实现
    public void loginDatabase(String username, String password) {
        mvpView.showLoading();
        UserDao userDao = daoSession.getUserDao();
        List<User> userList = userDao.queryBuilder().build().list();
        if(userList == null){
            Log.e("register", "数据库里无数据");
        }
        else {
            int flag = 0;
            for (User user : userList) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    mvpView.onSuccess("登陆成功！","");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                mvpView.onError("密码不正确！", "");
            }
        }
    }

    public void register(String username, String password) {
        mvpView.showLoading();
        UserDao userDao = daoSession.getUserDao();
        List<User> userList = userDao.queryBuilder().build().list();
        if(userList == null){
            Log.e("register", "数据库里无数据");
        }else{
            int flag = 0;
            for(User user1 : userList){
                if(user1.getUsername().equals(username)){
                    flag = 1;
                    mvpView.onError("用户名不存在！", "");
                    break;
                }
            }
            if (flag == 0) {
                User user2 = new User(username,password);
                userDao.insert(user2);
                mvpView.onSuccess("注册成功！","");
            }
        }
    }
}