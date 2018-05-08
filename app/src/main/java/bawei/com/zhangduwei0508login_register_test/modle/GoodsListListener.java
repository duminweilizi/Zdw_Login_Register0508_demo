package bawei.com.zhangduwei0508login_register_test.modle;

/**
 *
 */

public interface GoodsListListener {
    //    获取数据成功
    void getDataSuccess(String json);

    //获取数据失败
    void getDataError(String error);
}
