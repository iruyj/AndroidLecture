package kr.hs.emirim.w2015.ex10_15_18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        int num1 = intent.getIntExtra("num1",0);
        int num2 = intent.getIntExtra("num2",0);
        String calcul = intent.getStringExtra("calcul");

        switch (calcul){
            case "+":
                result = num1+num2;
                break;
            case "-":
                result = num1-num2;
                break;
            case "*":
                result = num1*num2;
                break;
            case "/":
                result = num1/num2;
                break;
        }

        Button btn100 = findViewById(R.id.btn_back);
        btn100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent  = new Intent(getApplicationContext(), MainActivity.class);
                mainIntent.putExtra("result",result);
                setResult(RESULT_OK,mainIntent);
                finish();
            }
        });
    }
}