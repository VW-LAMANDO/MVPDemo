package com.nscoder.mvpdemo.presenter;

import com.nscoder.mvpdemo.model.HomeModel;
import com.nscoder.mvpdemo.model.IListener;
import com.nscoder.mvpdemo.model.IModel;
import com.nscoder.mvpdemo.views.IActivity;

/**
 * Created by Tiger on 2017/12/17.
 */

public class HomePresenter implements  IPresenter{

    IActivity homeActivity;
    IModel homeModel;
    public  HomePresenter(IActivity homeActivity){
        this.homeActivity = homeActivity;
        this.homeModel = new HomeModel();
    }

    @Override
    public void onClick(String name, String ps) {
        homeModel.login(name, ps, new IListener() {
            @Override
            public void onNameError() {
                homeActivity.setNameError();
                homeActivity.hideProgress();
            }

            @Override
            public void onPsError() {
                homeActivity.setPassWordError();
                homeActivity.hideProgress();
            }

            @Override
            public void onSuccess() {
                homeActivity.goHome();
            }
        });
    }
}
