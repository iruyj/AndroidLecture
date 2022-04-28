package kr.hs.emirim.w2015.ex10_19_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCall = findViewById(R.id.btn_call);
        Button btnHome = findViewById(R.id.btn_homepage);
        Button btnMap = findViewById(R.id.btn_map);
        Button btnSearch = findViewById(R.id.btn_search);
        Button btnSMS = findViewById(R.id.btn_sms);
        Button btnPhoto = findViewById(R.id.btn_photo);

        btnCall.setOnClickListener(btnListener);
        btnHome.setOnClickListener(btnListener);
        btnMap.setOnClickListener(btnListener);
        btnSearch.setOnClickListener(btnListener);
        btnSMS.setOnClickListener(btnListener);
        btnPhoto.setOnClickListener(btnListener);
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_call:
                    intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01071491377"));
                    break;
                case R.id.btn_homepage:
                    intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/?gl=KR"));
                    break;
                case R.id.btn_map:
                    intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.co.kr/maps?g="+35.225558+","+129.226519+"&z=15"));
                    break;
                case R.id.btn_search:
                    intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra("SearchManager","코로나현황");
                    break;
                case R.id.btn_sms:
                    intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra("sms_body","긴급재난문자");
                    intent.setData(Uri.parse("smsto:"+ Uri.encode("010-7149-1377")));
                    break;
                case R.id.btn_photo:
                    intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    break;
            }
            startActivity(intent);
        }
    };
}