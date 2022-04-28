package kr.hs.emirim.w2015.project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ImageView imgV = findViewById(R.id.imgv);
        TextView text1 = findViewById(R.id.text_result1);
        TextView text2 = findViewById(R.id.text_result2);
        Intent intent = getIntent();
        double w = intent.getDoubleExtra("weight",0);
        double h = intent.getDoubleExtra("height",0);
        // BMMI 단위 kg/m^2
        double bmi = w/ Math.pow(h/100,2);

        String bmiStr="";
        int imgSrcId = 0;

        if(bmi<18.5){
            bmiStr ="저";
            imgSrcId = R.drawable.bmi1;
        }else if(bmi<24){
            bmiStr ="정상";
            imgSrcId = R.drawable.bmi2;
        }else if(bmi<30){
            bmiStr ="과";
            imgSrcId = R.drawable.bmi3;
        }else if(bmi<35){
            bmiStr ="비만";
            imgSrcId = R.drawable.bmi4;
        }else if(bmi<40){
            bmiStr ="고도비만";
            imgSrcId = R.drawable.bmi5;
        }else{
            bmiStr ="초고도비만";
            imgSrcId = R.drawable.bmi6;
        }
        imgV.setImageResource(imgSrcId);
        text1.setText(bmiStr + "체중");
    }
}