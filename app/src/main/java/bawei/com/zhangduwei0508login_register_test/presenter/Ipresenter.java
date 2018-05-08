package bawei.com.zhangduwei0508login_register_test.presenter;


import bawei.com.zhangduwei0508login_register_test.modle.IModel;
import bawei.com.zhangduwei0508login_register_test.view.IGoodsListView;
import bawei.com.zhangduwei0508login_register_test.view.IMainView;
import bawei.com.zhangduwei0508login_register_test.view.IRegView;

public interface Ipresenter {
    //    登录
    void loginPresenter(IModel iModel, IMainView iMainView);

    //    注册
    void regPresenter(IModel iModel, IRegView iRegView);
    //   显示数据
    void showGoodsListToView(IModel iModel, IGoodsListView iGoodsListView);

    //  刷新
    void showGoodsListFresh(IModel iModel, IGoodsListView iGoodsListView);

    //更多
    void showGoodsListLoadMore(IModel iModel, IGoodsListView iGoodsListView);
    //搜索
    void showGoodsListSousuo(IModel iModel, IGoodsListView iGoodsListView);
}
