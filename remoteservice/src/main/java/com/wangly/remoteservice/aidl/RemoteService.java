package com.wangly.remoteservice.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by wangly on 2016/8/31.
 */
public class RemoteService extends Service {

    private IBinder binder = new BinderService();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public static final class BinderService extends IMyAidlInterface.Stub {


        @Override
        public String getServiceMethodInfo() throws RemoteException {
            String result = "";
            for (int i = 0; i < 10; i++) {
                result = "小明---->";
            }
            return result;
        }
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
