package com.example.dxnima.zhidao.biz.personcenter;

import com.example.dxnima.zhidao.biz.BasePresenter;
import com.example.dxnima.zhidao.bridge.BridgeFactory;
import com.example.dxnima.zhidao.bridge.Bridges;
import com.example.dxnima.zhidao.bridge.cache.sharePref.EBSharedPrefManager;
import com.example.dxnima.zhidao.bridge.cache.sharePref.EBSharedPrefUser;
import com.example.dxnima.zhidao.bridge.http.OkHttpManager;
import com.example.dxnima.zhidao.bridge.security.SecurityManager;
import com.example.dxnima.zhidao.capabilities.http.ITRequestResult;
import com.example.dxnima.zhidao.capabilities.http.Param;
import com.example.dxnima.zhidao.constant.URLUtil;

/**
 * Created by DXnima on 2019/4/1.
 */
public class LoginPresenter extends BasePresenter<IUserLoginView>{

    public LoginPresenter() {
    }

    public void login(String useName, String password) {
        //网络层
        mvpView.showLoading();
        SecurityManager securityManager = BridgeFactory.getBridge(Bridges.SECURITY);
        OkHttpManager httpManager = BridgeFactory.getBridge(Bridges.HTTP);

        httpManager.requestAsyncPostByTag(URLUtil.USER_LOGIN, getName(), new ITRequestResult<LoginPresenter>() {
                    @Override
                    public void onCompleted() {
                        mvpView.hideLoading();
                    }

                    @Override
                    public void onSuccessful(LoginPresenter entity) {
                        mvpView.onSuccess();
                        EBSharedPrefManager manager = BridgeFactory.getBridge(Bridges.SHARED_PREFERENCE);
                        manager.getKDPreferenceUserInfo().saveString(EBSharedPrefUser.USER_NAME, "abc");
                    }

                    @Override
                    public void onFailure(String errorMsg) {
                        mvpView.onError(errorMsg, "");
                    }

                }, LoginPresenter.class, new Param("username", useName),
                new Param("pas", securityManager.get32MD5Str(password)));
    }
}