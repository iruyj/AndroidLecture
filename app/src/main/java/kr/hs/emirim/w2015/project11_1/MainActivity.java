package kr.hs.emirim.w2015.project11_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView grid1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("최신 영화 포스터");
        grid1 = findViewById(R.id.grid1);
        GridAdapter adapter = new GridAdapter(this);
        grid1.setAdapter(adapter);

    }
}