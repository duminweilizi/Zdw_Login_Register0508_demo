package bawei.com.zhangduwei0508login_register_test.view;


import java.util.List;

import bawei.com.zhangduwei0508login_register_test.modle.GoosListBean;

public interface IGoodsListView {
    //展示商品列表的方法
    void showGoodsList(List<GoosListBean.DataBean> data);
    //刷新
    void showGoodsListFresh(List<GoosListBean.DataBean> data);
    //更多
    void showGoodsListLoadMore(List<GoosListBean.DataBean> data);
    //

    String getContent();

    String getPage();

    //搜索
    void showGoodsListSousuo(List<GoosListBean.DataBean> data);
}
