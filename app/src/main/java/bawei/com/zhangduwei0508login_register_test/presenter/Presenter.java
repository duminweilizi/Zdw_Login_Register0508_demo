package bawei.com.zhangduwei0508login_register_test.presenter;

import android.util.Log;


import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import bawei.com.zhangduwei0508login_register_test.http.HttpConfig;
import bawei.com.zhangduwei0508login_register_test.modle.GoodsListListener;
import bawei.com.zhangduwei0508login_register_test.modle.GoosListBean;
import bawei.com.zhangduwei0508login_register_test.modle.IModel;
import bawei.com.zhangduwei0508login_register_test.modle.LoginListener;
import bawei.com.zhangduwei0508login_register_test.modle.RegListener;
import bawei.com.zhangduwei0508login_register_test.view.IGoodsListView;
import bawei.com.zhangduwei0508login_register_test.view.IMainView;
import bawei.com.zhangduwei0508login_register_test.view.IRegView;


public class Presenter implements Ipresenter {
    private static final String TAG = "Presenter-----";
    //登录
    @Override
    public void loginPresenter(IModel iModel, final IMainView iMainView) {
        //调用m请求数据
        Map<String, String> map = new HashMap<>();
        map.put("mobile", iMainView.getMobile());
        map.put("password", iMainView.getPassword());
        iModel.login(HttpConfig.login_url, map, new LoginListener() {
            //根据回调结果，决定view的显示效果
            @Override
            public void loginSuccess(String json) {
                iMainView.loginSuccess();
            }

            @Override
            public void loginError(String error) {
                iMainView.loginError();
            }
        });

    }

    //注册
    @Override
    public void regPresenter(IModel iModel, final IRegView iRegView) {
        //调用m请求数据
        Map<String, String> map = new HashMap<>();
        map.put("mobile", iRegView.getMobile());
        map.put("password", iRegView.getPassword());
        iModel.reg(HttpConfig.reg_url, map, new RegListener() {
            @Override
            public void regSuccess(String json) {
                iRegView.regSuccess();
            }

            @Override
            public void regError(String error) {
                iRegView.regError();
            }
        });
    }
    //   显示数据
    @Override
    public void showGoodsListToView(IModel iModel, final IGoodsListView iGoodsListView) {
        Map<String, String> map = new HashMap<>();
        map.put("keywords", "笔记本");
        map.put("page", "1");
        iModel.getGoodsListData(HttpConfig.goods_list_url, map, new GoodsListListener() {

            @Override
            public void getDataSuccess(String json) {
                Gson gson = new Gson();
                GoosListBean goosListBean = gson.fromJson(json, GoosListBean.class);
                iGoodsListView.showGoodsList(goosListBean.getData());
            }

            @Override
            public void getDataError(String error) {
                Log.d(TAG, "失败---");
            }
        });
    }

    @Override
    public void showGoodsListFresh(IModel iModel, final IGoodsListView iGoodsListView) {
        Map<String, String> map = new HashMap<>();
        map.put("keywords", "笔记本");
        map.put("page", "1");
        iModel.getGoodsListData(HttpConfig.goods_list_url, map, new GoodsListListener() {

            @Override
            public void getDataSuccess(String json) {
                Gson gson = new Gson();
                GoosListBean goosListBean = gson.fromJson(json, GoosListBean.class);
                iGoodsListView.showGoodsListFresh(goosListBean.getData());
            }

            @Override
            public void getDataError(String error) {
                Log.d(TAG, "失败---");
            }
        });
    }

    @Override
    public void showGoodsListLoadMore(IModel iModel, final IGoodsListView iGoodsListView) {
        Map<String, String> map = new HashMap<>();
        map.put("keywords", "笔记本");
        map.put("page",iGoodsListView.getPage());
        iModel.getGoodsListData(HttpConfig.goods_list_url, map, new GoodsListListener() {

            @Override
            public void getDataSuccess(String json) {
                Gson gson = new Gson();
                GoosListBean goosListBean = gson.fromJson(json, GoosListBean.class);
                iGoodsListView.showGoodsListLoadMore(goosListBean.getData());
            }

            @Override
            public void getDataError(String error) {
                Log.d(TAG, "失败---");
            }
        });
    }

    @Override
    public void showGoodsListSousuo(IModel iModel, final IGoodsListView iGoodsListView) {
        Map<String, String> map = new HashMap<>();
        map.put("keywords",iGoodsListView.getContent());
        map.put("page","1");
        iModel.getGoodsListData(HttpConfig.goods_list_url, map, new GoodsListListener() {

            @Override
            public void getDataSuccess(String json) {
                Gson gson = new Gson();
                GoosListBean goosListBean = gson.fromJson(json, GoosListBean.class);
                iGoodsListView.showGoodsListLoadMore(goosListBean.getData());
            }

            @Override
            public void getDataError(String error) {
                Log.d(TAG, "失败---");
            }
        });
    }
    }
