package com.xy.mvp;

import android.content.Intent;
import android.os.IBinder;
import com.xy.mvp.base.BaseService;
import com.xy.mvp.presenter.Presenter;

import cn.xy.library.util.log.XLog;

public class MainService extends BaseService {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mPresenter.onCreate();
        mPresenter.openTime();
    }

    @Override
    public Presenter getPresenter() {
        return new Presenter(this);
    }

    @Override
    public void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onTime(int position) {
        XLog.e(position);
    }
}
