package kr.hs.emirim.w2015.project4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit1,edit2;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlus = findViewById(R.id.btn1);
        Button btnMinus = findViewById(R.id.btn2);
        Button btnMulti = findViewById(R.id.btn3);
        Button btnDiv = findViewById(R.id.btn4);
        Button btnMod = findViewById(R.id.btn5);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        textResult=findViewById(R.id.t1);

        btnPlus.setOnClickListener(btnLisener);
        btnMinus.setOnClickListener(btnLisener);
        btnMulti.setOnClickListener(btnLisener);
        btnDiv.setOnClickListener(btnLisener);
        btnMod.setOnClickListener(btnLisener);
    }

    View.OnClickListener btnLisener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strEdit1 = edit1.getText().toString();
            String strEdit2 = edit2.getText().toString();
            int num1 = Integer.parseInt(strEdit1);
            int num2 = Integer.parseInt(strEdit2);
            int result =0;
            switch (v.getId()){
                case R.id.btn1:
                    result = num1+num2;
                    break;
                case R.id.btn2:
                    result = num1-num2;
                    break;
                case R.id.btn3:
                    result = num1*num2;
                    break;
                case R.id.btn4:
                    result = num1/num2;
                    break;
                case R.id.btn5:
                    result = num1%num2;
                    break;
            }
            textResult.setText(R.string.t1); //t1으로 text 뒤로 돌아가서
            textResult.append(" "+result+""); //그 뒤에 출력해줌
        }
    };
}