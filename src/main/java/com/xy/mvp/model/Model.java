package com.xy.mvp.model;

import android.os.Handler;
import android.os.Message;

import com.xy.mvp.view.View;

import java.util.ArrayList;

import cn.xy.library.util.log.XLog;

public class Model extends BaseModel {

    private static ArrayList<View> mViews=new ArrayList<View>();
    private static Model mModel=null;

    public void setViews(View mPV){
        XLog.i("Model中增加P"+mPV);
        mViews.add(mPV);
    }
    public static Model getInstant(){
        if (mModel == null){
            mModel = new Model();
        }
        return mModel;
    }

    public void onCreate(){
        handler = new mHandler();
        XLog.i();
    }

    public void onRestart() {
        XLog.i();
    }

    public void onResume() {
        handler.sendEmptyMessage(0x01);
        XLog.i();
    }

    public void onPause() {
        XLog.i();
    }

    public void onStop() {
        XLog.i();
    }

    public void onDestroy(View mPV) {
        XLog.i("Model中去除P"+mPV);
        mViews.remove(mPV);
        if (mViews.size()==0){
            clear();
        }
    }

    public final void clear() {
        handler.removeMessages(0x01);
        handler = null;
        mModel = null;
    }

    public void openTime(){

    }

    private mHandler handler;
    private int i = 0;
    private class mHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            handler.removeMessages(0x01);
            handler.sendEmptyMessageDelayed(0x01,1000);
            ++i;
            for (View mView : mViews) {
                XLog.i(mView+" 发送传出处理的值："+i);
                mView.onTime(i);
            }
        }
    }
}
