package com.yehowah.androidinterface530;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yehowah.androidinterface530.OtherTest.ToastListener;
import com.yehowah.androidinterface530.OtherTest.ToastListenerUser;

//实现接口，小红要知道还钱的结果
//https://blog.csdn.net/angcyo/article/details/46410577
//https://blog.csdn.net/qq_23940659/article/details/50791721
public class MainActivity extends AppCompatActivity implements OnRepay,View.OnClickListener{
    private static final String TAG = "MainActivity";
    private XiaoMing xiaoMing;
    private ToastListenerUser toastListenerUser;
    private int i = 1;
    private Button JieBt;
    private Button ChouBt;
    private Button ToastBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xiaoMing = new XiaoMing((OnRepay) this);

        toastListenerUser = new ToastListenerUser();
        toastListenerUser.setToastListener(new ToastListener() {
            @Override
            public void showToast() {//实现接口中未实现
                Toast.makeText(MainActivity.this, "回调成功"+i, Toast.LENGTH_SHORT).show();
                i++;
            }
        });


        ChouBt = (Button) findViewById(R.id.ChouBt);
        JieBt = (Button) findViewById(R.id.JieBt);
        ToastBt = (Button) findViewById(R.id.ToastBt);
        JieBt.setOnClickListener(this);
        ChouBt.setOnClickListener(this);
        ToastBt.setOnClickListener(this);
    }


    @Override
    public boolean onRepay() {// 小明还钱的时候,小红接收, 返回true:收到了钱, 返回false:没收收到
        Log.i(TAG, "小红没有收到小明的还钱,可能被快递员私吞了..: ");
        return false;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.JieBt:
                xiaoMing.JieQian();//
                break;
            case R.id.ChouBt:
                xiaoMing.JieQianCallback(new OnRepayCallback() {
                    @Override
                    boolean onRepayCallBack() {
                        Log.e("小红", "小红收到小明的还钱10元...");
                        return true;
                    }
                });
                break;
            case R.id.ToastBt:
                //实现接口
                toastListenerUser.useToastListener();

                break;
        }
    }
}
