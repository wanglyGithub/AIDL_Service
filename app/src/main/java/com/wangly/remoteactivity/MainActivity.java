package com.wangly.remoteactivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wangly.remoteservice.aidl.IMyAidlInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_service;
    private TextView tv_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        tv_info = (TextView) findViewById(R.id.tv_info);

        btn_service = (Button) findViewById(R.id.btn_service);
        btn_service.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_service:
                method();
                break;
            default:
                break;
        }
    }

    private void method() {
        Intent intent = new Intent();
        intent.setAction("com.wangly.remoteService");
        intent.setPackage(this.getPackageName());
        bindService(intent, serviceConnection,Context.BIND_AUTO_CREATE);
    }


    ServiceConnection serviceConnection = new ServiceConnection() {

        private IMyAidlInterface test;

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //把IBinder 对象转换成 接口类型
            test = IMyAidlInterface.Stub.asInterface(iBinder);

            try {
                String conent = test.getServiceMethodInfo();

                tv_info.setText(conent);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
