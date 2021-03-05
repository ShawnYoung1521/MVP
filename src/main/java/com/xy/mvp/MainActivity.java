package com.xy.mvp;

import android.app.Service;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import com.xy.mvp.base.BaseActivity;
import com.xy.mvp.presenter.Presenter;

import cn.xy.library.util.log.XLog;
import cn.xy.library.util.service.XService;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter.onCreate();
        XService.startService(MainService.class);
        XService.bindService(MainService.class,mConnection, Service.BIND_AUTO_CREATE);
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    @Override
    protected void onStart() {
        mPresenter.onRestart();
        super.onStart();
    }

    @Override
    public Presenter getPresenter() {
        return new Presenter(this);
    }

    @Override
    protected void onResume() {
        mPresenter.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mPresenter.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        XService.unbindService(mConnection);
        super.onDestroy();
    }

    @Override
    public void onTime(int position) {
        XLog.e(position);
    }
}
