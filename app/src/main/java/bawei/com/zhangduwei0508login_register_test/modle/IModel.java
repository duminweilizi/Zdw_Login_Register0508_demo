package bawei.com.zhangduwei0508login_register_test.modle;

import java.util.Map;

/**
 * Model
 */

public interface IModel {
//    登录
    void login(String url, Map<String, String> params, LoginListener loginListener);
//    注册
    void reg(String url, Map<String, String> params, RegListener regListener);
//    获取商品数据
    void getGoodsListData(String url, Map<String, String> params, GoodsListListener goodsListListener);

    //刷新
    void getGoodsListFresh(String url, Map<String, String> params, GoodsListListener goodsListListener);

    //更多
    void getGoodsListLoadMore(String url, Map<String, String> params, GoodsListListener goodsListListener);

    //搜索
    void getGoodsListSousuo(String url, Map<String, String> params, GoodsListListener goodsListListener);
}
