package kr.hs.emirim.w2015.ex11_16_17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String[] itemArrs = {"미녀와 야수","스파이더맨:홈커밍","말레피센트","라라랜드","라우디 덴 방즈","겨울왕국",
    "인어공주","알라딘","라푼젤","인사이드아웃"};
    int[] posts ={R.drawable.mov1,R.drawable.mov2,R.drawable.mov3,R.drawable.mov4,R.drawable.mov5,
            R.drawable.mov6,R.drawable.mov7,R.drawable.mov8,R.drawable.mov9,R.drawable.mov10};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("스피너 연습");
        Spinner sp = findViewById(R.id.spinner1);
        ImageView imgV = findViewById(R.id.imgv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemArrs);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imgV.setImageResource(posts[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}