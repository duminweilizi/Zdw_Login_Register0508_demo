package bawei.com.zhangduwei0508login_register_test.view;

/**
 * 注册view
 */

public interface IRegView {
    //获手机号
    String getMobile();

    //获取密码
    String getPassword();

    //注册成功
    void regSuccess();

    //注册失败
    void regError();
}
