package fr.canm.cyrilstern1.cnamptp9deuxiemeactivit;

import fr.canm.cyrilstern1.cnamtp9.SmsAIDL;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service {

    private SmsAIDL service;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate(){
        super.onCreate();
        init();
    }
    public void init() {

        Intent intent = new Intent();
        intent.setPackage(this.getPackageName());
        intent.setAction("service.connection");
        //intent.setClassName("fr.canm.cyrilstern1.cnamptp9deuxiemeactivit.MyService", "fr.canm.cyrilstern1.cnamtp9.SmsService.SmsService2");
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
       // Log.i("passe","passe part la");


    }
     ServiceConnection connection = new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
                Log.i("passe","passe part la");
            service = SmsAIDL.Stub.asInterface(binder);
            try {

                service.interceptedSMS();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            try {
                Log.i("MainActivity", "service.interceptedSMS()== " + service.interceptedSMS());
            }catch(RemoteException e){
                Log.i("MainActivity", "RemoteException" + e.getMessage());
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("MainActivity", "onServiceDisconnected");
        }
    };

}
