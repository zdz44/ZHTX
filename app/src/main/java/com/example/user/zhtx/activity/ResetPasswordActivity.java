package com.example.user.zhtx.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.zhtx.LoginActivity;
import com.example.user.zhtx.R;

public class ResetPasswordActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText ed_newPwd,ed_confirmPwd;
    private Button btn_reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        initView();
    }

    private void initView(){
        ed_confirmPwd = (EditText)findViewById(R.id.activity_reset_password_ed_confirmPwd);
        ed_newPwd = (EditText)findViewById(R.id.activity_reset_password_ed_confirmPwd);

        btn_reset = (Button)findViewById(R.id.activity_reset_password_btn_reset);
        btn_reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}