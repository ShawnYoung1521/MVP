package com.xy.mvp.presenter;

import android.content.Context;
import com.xy.mvp.model.Model;
import com.xy.mvp.view.View;

public class Presenter extends BasePresenter<View, Model> implements View{

    public Presenter(Context context) {
        super(context);
    }

    @Override
    public Model getModel() {
        return Model.getInstant();
    }

    public void onCreate(){
        mModel.onCreate();
        addView();
    }

    private void addView(){
        mModel.setViews(this);
    }

    public void onRestart() {
        mModel.onRestart();
    }

    public void onResume() {
        mModel.onResume();
    }

    public void onPause() {
        mModel.onPause();
    }

    public void onStop() {
        mModel.onStop();
    }

    public void onDestroy() {
        mModel.onDestroy(this);
    }

    public void openTime() {
        mModel.openTime();
    }

    @Override
    public void onTime(int position) {
        get().onTime(position);
    }
}
