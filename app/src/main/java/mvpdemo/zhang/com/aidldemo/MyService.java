package mvpdemo.zhang.com.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service {
    public MyService() {

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }
    private class MyBinder extends IMyAidlInterface.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }


        @Override
        public String getData(String data) throws RemoteException {
            Log.e("MyService","sending.....");

            return data;
        }
    }
}
