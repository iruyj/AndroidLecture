package kr.hs.emirim.w2015.ex14_1_4;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {
    public MusicService() {
    }
    MediaPlayer mp;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i( "서비스 테스트::", "onstart 호출됨");
        mp = MediaPlayer.create(this,R.raw.bigsciota);
        mp.setLooping(true);
        mp.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        Log.i( "서비스 테스트::", "onCreate 호출됨");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.i( "서비스 테스트::", "onDestory 호출됨");
        mp.stop();
        super.onDestroy();
    }
}