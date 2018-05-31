package com.yehowah.androidinterface530;

import android.util.Log;

//2.定义类--XiaoMing,调用接口，进行还钱
public class XiaoMing {
    private static final String TAG = "XiaoMing";
    OnRepay XiaoHong;//小红
    
    public XiaoMing(OnRepay listener){
        this.XiaoHong = listener;
    }
    
    //小明借钱的方法
    public void JieQian(){
        Log.i(TAG, "小明借了小红10块钱,小明说:\"不要着急, 还钱的时候,我会告诉你.\"");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 过了一会儿, 小明要还钱了,这个时候要通知小红. 通知的方式,就用到了回调
        if (XiaoHong.onRepay()){// 告诉小红, 小明还钱了;
            Log.i(TAG, "谢谢的还钱,我已经收到 ");
        }else {
            //如果小红没有收到10块钱(可能路上被强盗抢了),那么....
            Log.i(TAG, "小明还我的钱,我没有收到,可能被快递员私吞了, 请再还一次");
        }
    }
    
    public void JieQianCallback(OnRepayCallback callback){
        Log.i(TAG, "小明借了小红10块钱,小明说:\\\"不要着急, 还钱的时候,我会告诉你.\\\" ");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 过了一会儿, 小明要还钱了,这个时候要通知小红. 通知的方式,就用到了回调
        if (callback.onRepayCallBack()) {// 告诉小红, 小明还钱了;
            //如果小红收到小明还的10块钱;
            Log.e("小红", "谢谢的还钱,我已经收到");
        }else {
            //如果小红没有收到10块钱(可能路上被强盗抢了),那么....
            Log.e("小红", "小明还我的钱,我没有收到,可能被快递员私吞了, 请再还一次");
        }
        
    }
    
    
}
