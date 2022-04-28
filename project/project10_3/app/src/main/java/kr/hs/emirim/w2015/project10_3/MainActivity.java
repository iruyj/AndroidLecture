package kr.hs.emirim.w2015.project10_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        //로그창에 메세지 띄우기
        Log.i("엑티비티 생명주기 : ","Call OnCreate()");
        Button btnCall = findViewById(R.id.btn_call);
        Button btnFinish = findViewById(R.id.btn_finish);

        btnCall.setOnClickListener(btnListener);
        btnFinish.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_call:
                    Uri uri = Uri.parse("tel:01012345677");
                    Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                    startActivity(intent);
                    break;
                case R.id.btn_finish:
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("엑티비티 생명주기 : ","Call OnDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("엑티비티 생명주기 : ","Call OnRestart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("엑티비티 생명주기 : ","Call onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("엑티비티 생명주기 : ","Call onPause()");
    }
}
