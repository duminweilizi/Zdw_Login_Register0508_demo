package bawei.com.zhangduwei0508login_register_test.modle;

/**
 * 注册的回调接口
 */

public interface RegListener {
    void regSuccess(String json);

    void regError(String error);
}
