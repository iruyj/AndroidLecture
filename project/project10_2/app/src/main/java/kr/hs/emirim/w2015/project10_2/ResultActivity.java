package kr.hs.emirim.w2015.project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        String[] imgNames = intent.getStringArrayExtra("imgNames");

        //사진 담을 배열
        Integer imgs[] = {R.drawable.princess1, R.drawable.princess2,R.drawable.princess3,R.drawable.princess5,R.drawable.princess4,R.drawable.princess6,R.drawable.princess7,R.drawable.princess8,R.drawable.princess9};
        ImageView simg = findViewById(R.id.imgv);
        TextView stext = findViewById(R.id.tt);

        // 요소 담을 배열 설정
        TextView[] tv = new TextView[imgNames.length];
        RatingBar[] rb = new RatingBar[imgNames.length];
        
        //아이디값 담는 배열 생성
        int[] tvIds = {R.id.text1, R.id.text2,R.id.text3,R.id.text4,R.id.text5,R.id.text6,R.id.text7,R.id.text8,R.id.text9};
        int[] rbIds = {R.id.rating1, R.id.rating2,R.id.rating3,R.id.rating4,R.id.rating5,R.id.rating6,R.id.rating7,R.id.rating8,R.id.rating9};
        
        //임시변수 선언
        int max = 0;
        int index =0;
        for (int i=0; i<tv.length; i++){
            tv[i] = findViewById(tvIds[i]);
            rb[i] = findViewById(rbIds[i]);
            tv[i].setText(imgNames[i]);
            rb[i].setRating(voteCount[i]);
            
            //최다 득표자 구하기
            if(voteCount[i]>max){
                max=voteCount[i];
                index = i;
            }
        }
        //최종 설정하기
        stext.setText(imgNames[index]);
        simg.setImageResource(imgs[index]);

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}