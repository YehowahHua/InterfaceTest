package com.yehowah.androidinterface530.OtherTest;

public class ToastListenerUser {
    //调用接口
    private ToastListener toastListener;

    //给接口设置回调，这里新建一个类来设置回调，并写一个方法来调用接口的方法，以等待其他类来实现接口的方法
    public void setToastListener(ToastListener toastListener) {
        this.toastListener = toastListener;
    }

    public void useToastListener(){
        toastListener.showToast();//
    }

}
