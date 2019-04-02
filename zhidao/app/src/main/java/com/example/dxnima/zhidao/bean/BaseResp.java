package com.example.dxnima.zhidao.bean;

/**
 * <网络请求返回体>
 * Created by DXnima on 2019/4/1.
 */
public class BaseResp {
    /**
     * 返回状态码
     */
    protected int retcode;

    /**
     * 返回信息描述
     */
    protected String retinfo;

    public int getRetcode()
    {
        return retcode;
    }

    public void setRetcode(int retcode)
    {
        this.retcode = retcode;
    }

    public String getRetinfo()
    {
        return retinfo;
    }

    public void setRetinfo(String retinfo)
    {
        this.retinfo = retinfo;
    }
}