package kr.hs.emirim.w2015.ex11_16_17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String[] itemArrs = {"미녀와 야수","스파이더맨:홈커밍","말레피센트","라라랜드","라우디 덴 방즈","겨울왕국",
    "인어공주","알라딘","라푼젤","인사이드아웃"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("");
        Spinner sp = findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 10,itemArrs);
        sp.setAdapter(adapter);

    }
}