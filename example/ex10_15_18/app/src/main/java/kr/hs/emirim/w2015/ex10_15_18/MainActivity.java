package kr.hs.emirim.w2015.ex10_15_18;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1,edit2;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.title_main);

        rg = findViewById(R.id.rg);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        Button btncalc = findViewById(R.id.btn_calc);

        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cal="";
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.rplus:
                        cal = "+";
                        break;
                    case R.id.rminus:
                        cal = "-";
                        break;
                    case R.id.rmulti:
                        cal = "*";
                        break;
                    case R.id.rdivice:
                        cal = "/";
                        break;
                }
                intent.putExtra("calcul",cal);
                intent.putExtra("num1", Integer.parseInt(edit1.getText().toString()));
                intent.putExtra("num2", Integer.parseInt(edit2.getText().toString()));
                startActivityForResult(intent,0);
            }
        });
    }
    
    // 세컨드에서 값 가져오기
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK ){
            int result = data.getIntExtra("result",0);
            Toast.makeText(getApplicationContext(),"결과 : "+result, Toast.LENGTH_SHORT ).show();
        }
    }
}