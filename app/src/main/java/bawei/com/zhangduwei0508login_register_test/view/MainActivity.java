package bawei.com.zhangduwei0508login_register_test.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bawei.com.zhangduwei0508login_register_test.R;
import bawei.com.zhangduwei0508login_register_test.modle.ModelImpl;
import bawei.com.zhangduwei0508login_register_test.presenter.Presenter;


/**
 * 登录页
 */
public class MainActivity extends AppCompatActivity implements IMainView, View.OnClickListener {

    private EditText mobile;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化界面
        initViews();
    }

    private void initViews() {
        mobile = findViewById(R.id.mobile);
        password = findViewById(R.id.pwd);
        Button login = findViewById(R.id.login);
        Button reg = findViewById(R.id.reg);


        login.setOnClickListener(this);
        reg.setOnClickListener(this);
    }

    //手机号
    @Override
    public String getMobile() {
        return mobile.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(MainActivity.this, "成功---", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,GoodsListActivity.class));
    }

    @Override
    public void loginError() {
        Toast.makeText(MainActivity.this, "失败---请注册", Toast.LENGTH_SHORT).show();
    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                Presenter presenter = new Presenter();
                presenter.loginPresenter(new ModelImpl(),this);
                break;
            case R.id.reg:
                startActivity(new Intent(MainActivity.this,RegActivity.class));
                break;
        }
    }
}
