package com.nscoder.mvpdemo.model;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Tiger on 2017/12/17.
 */

public class HomeModel implements IModel{

    Handler handler = new Handler();

    @Override
    public void login(final String name, final String ps, final IListener listener) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if(TextUtils.isEmpty(name)){
                    listener.onNameError();
                    error = true;
                }
                if(TextUtils.isEmpty(ps)){
                    listener.onPsError();
                    error = true;
                }
                if(error == false){
                    listener.onSuccess();
                }
            }
        },2000);
    }
}
