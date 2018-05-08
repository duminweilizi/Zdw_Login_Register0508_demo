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


public class RegActivity extends AppCompatActivity implements View.OnClickListener, IRegView {
    private EditText mobile;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        //初始化界面
        initViews();
    }

    private void initViews() {
        mobile = findViewById(R.id.mobile);
        password = findViewById(R.id.pwd);
        Button reg = findViewById(R.id.reg);
        reg.setOnClickListener(this);
    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reg:
                Presenter presenter = new Presenter();
                presenter.regPresenter(new ModelImpl(), this);
                break;
        }
    }

    //获取手机号
    @Override
    public String getMobile() {
        return mobile.getText().toString();
    }

    //密码
    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    //注册成功
    @Override
    public void regSuccess() {
        Toast.makeText(RegActivity.this, "注册成功---", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(RegActivity.this, GoodsListActivity.class));
    }

    //注册失败
    @Override
    public void regError() {
        Toast.makeText(RegActivity.this, "注册失败---", Toast.LENGTH_SHORT).show();
    }
}
