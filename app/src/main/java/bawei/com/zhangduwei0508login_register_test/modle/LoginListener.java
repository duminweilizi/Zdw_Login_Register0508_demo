package bawei.com.zhangduwei0508login_register_test.modle;

public interface LoginListener {
    void loginSuccess(String json);

    void loginError(String error);
}
