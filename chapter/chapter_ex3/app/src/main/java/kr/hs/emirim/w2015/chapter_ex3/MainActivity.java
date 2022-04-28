package kr.hs.emirim.w2015.chapter_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex4_17);

        TextView tv1 = findViewById(R.id.text1);
        TextView tv2 = findViewById(R.id.text2);
        TextView tv3 = findViewById(R.id.text3);

        tv1.setText(R.string.hello);
        //tv1.setTextColor(Color.RED);
        tv1.setTextColor(Color.rgb(255,0,0));
        tv2.setTextSize(30);
        tv2.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
        tv3.setText(R.string.t5);
        tv3.setSingleLine();
    }
}