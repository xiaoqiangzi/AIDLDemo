package mvpdemo.zhang.com.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import mvpdemo.zhang.com.aidldemo.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {
//    private MyConn conn;//连接对象
    private IMyAidlInterface iMyAidlInterface;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textView=(TextView)findViewById(R.id.tv_local1);
        Intent intent = new Intent()
                .setComponent(new ComponentName("mvpdemo.zhang.com.aidldemo",
                        "mvpdemo.zhang.com.aidldemo.MyService"));
        textView.append("startService\n");
        startService(intent);
        textView.append("bindService\n");
        bindService(intent, MyConn, BIND_AUTO_CREATE);
    }

    private ServiceConnection MyConn =new ServiceConnection() {
        //获取连接
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //这样才能获取到，不像之前的强制类型转换
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
            Log.e("Local", "获取链接");
            textView.append("onServiceConnected\n");
            serverData();
        }

        //连接失效
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("Local", "链接失败");
            textView.append("onServiceDisconnected\n");
            iMyAidlInterface = null;
        }
    };

    private void serverData() {
        try {
            textView.append(iMyAidlInterface.getData("service回应")+"\n");
        } catch (RemoteException e) {
            e.printStackTrace();
            textView.append("service回应error\n");
        }
    }

}
