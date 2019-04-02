package com.example.dxnima.zhidao.capabilities.http;

/**
 * <功能详细描述>
 *
 * Created by DXnima on 2019/4/1.
 */
public interface ITRequestResult<T> {

    public void onSuccessful(T entity);

    public void onFailure(String errorMsg);

    public void onCompleted();
}
