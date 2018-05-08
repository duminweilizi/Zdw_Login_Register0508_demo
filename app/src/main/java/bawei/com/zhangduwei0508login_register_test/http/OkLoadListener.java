package bawei.com.zhangduwei0508login_register_test.http;

/**
 * OkHttp网络请求的监听
 */

public interface OkLoadListener {
    //    请求数据成功
    void okLoadSuccess(String json);

    //请求数据失败
    void okLoadError(String error);
}
