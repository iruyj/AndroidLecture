package kr.hs.emirim.w2015.project4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
            Log.v("***strEdit1",strEdit1);
            if(strEdit1==null || strEdit1.equals("")||strEdit2==null || strEdit2.equals("")){
                Toast.makeText(getApplicationContext(), "계산에 필요한 값을 입력해주세요.",Toast.LENGTH_SHORT).show();
                return;
            }
            double num1= Double.parseDouble(strEdit1);
            double num2= Double.parseDouble(strEdit2);
            double result = 0;
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
                    if(strEdit2.equals("0")) {
                        Toast.makeText(getApplicationContext(), "0으로 나눌 수 없삼",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = num1/num2;
                    break;
                case R.id.btn5:
                    if(strEdit2.equals("0")) {
                        Toast.makeText(getApplicationContext(), "0으로 나눌 수 없삼",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = num1%num2;
                    break;
            }
            textResult.setText(R.string.t1); //t1으로 text 뒤로 돌아가서
            textResult.append(String.format("%.2f",result)+""); //그 뒤에 출력해줌
        }
    };
}