package kr.hs.emirim.w2015.project10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.Collections;

public class ResultActivity2 extends AppCompatActivity {
    int[] vCount;
    ViewFlipper vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        Intent getin = getIntent();

        Integer imgs[] = {R.drawable.princess1, R.drawable.princess2,R.drawable.princess3,R.drawable.princess5,R.drawable.princess4,R.drawable.princess6,R.drawable.princess7,R.drawable.princess8,R.drawable.princess9};
        Integer vimg[] ={R.id.imgv01,R.id.imgv02,R.id.imgv03,R.id.imgv04,R.id.imgv05,R.id.imgv06,R.id.imgv07,R.id.imgv08,R.id.imgv09};
        vCount = getin.getIntArrayExtra("voteCount");
        vf = findViewById(R.id.vf);

        Button start = findViewById(R.id.btn_start);
        Button stop = findViewById(R.id.btn_stop);

        //정렬'
        for(int i=0; i<vCount.length; i++) {
            for(int j=i+1; j<vCount.length; j++) {
                if(vCount[i] < vCount[j]) { //내림차순
                    int tmp = vCount[i];
                    int tempSrc = imgs[i];
                    vCount[i] = vCount[j];
                    imgs[i] = imgs[j];
                    vCount[j] = tmp;
                    imgs[j] = tempSrc;
                }
            }
        }


        //이미지 다시넣기
        ImageView imgv[] = new ImageView[vCount.length];
        for (int i=0; i < imgv.length; i++){
            imgv[i] = findViewById(vimg[i]);
            imgv[i].setImageResource(imgs[i]);
        }

        start.setOnClickListener(btnListener);
        stop.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_start:
                    vf.startFlipping();
                    break;
                case R.id.btn_stop:
                    vf.stopFlipping();
                    break;
            }
        }
    };
}
