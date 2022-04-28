package kr.hs.emirim.w2015.project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editW, editH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editW = findViewById(R.id.edit_weight);
        editH = findViewById(R.id.edit_height);
        Button btn_check = findViewById(R.id.btn_check);
        btn_check.setOnClickListener(btnListener);

    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //edit에 있는 값을 가져와서 문자열로 바꾼다음 더블로 만들어서 변수에 넣음
            double weight = Double.parseDouble(editW.getText().toString());
            double height = Double.parseDouble(editH.getText().toString());
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("weight",weight);
            intent.putExtra("height",height);
            startActivity(intent);
        }
    };
}