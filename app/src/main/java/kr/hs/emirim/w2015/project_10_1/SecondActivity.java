package kr.hs.emirim.w2015.project_10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btn_close = findViewById(R.id.btn_close);
        btn_close.setOnClickListener(closeListener);

    }
    View.OnClickListener closeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}