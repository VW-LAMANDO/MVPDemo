package com.nscoder.mvpdemo.views;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nscoder.mvpdemo.R;
import com.nscoder.mvpdemo.presenter.HomePresenter;
import com.nscoder.mvpdemo.presenter.IPresenter;

/**
 * Created by Tiger on 2017/12/17.
 */

public class HomeActivity extends AppCompatActivity implements IActivity,View.OnClickListener{

    EditText edName;
    EditText edPassword;
    Button btLogin;
    ProgressBar pbLoading;
    IPresenter homePresenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.editText);
        edPassword = findViewById(R.id.editText2);
        btLogin = findViewById(R.id.button);
        btLogin.setOnClickListener(this);
        pbLoading = findViewById(R.id.progressBar);
        homePresenter = new HomePresenter(this);
    }

    @Override
    public void showProgress() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void setNameError() {
        Toast.makeText(this, getString(R.string.name_wrong), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPassWordError() {
        Toast.makeText(this, getString(R.string.ps_wrong), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goHome() {
        Toast.makeText(this, getString(R.string.go_home), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        homePresenter.onClick(edName.getText().toString(),edPassword.getText().toString());
    }
}
