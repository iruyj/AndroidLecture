package kr.hs.emirim.w2015.chap5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearDog, linearCat, linearUga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        linearDog = findViewById(R.id.linear_dog);
        linearCat = findViewById(R.id.linear_cat);
        linearUga = findViewById(R.id.linear_uga);

        Button btnDog = findViewById(R.id.btn_dog);
        Button btnCat = findViewById(R.id.btn_cat);
        Button btnUga = findViewById(R.id.btn_uga);

        btnDog.setOnClickListener(btnLinear);
        btnCat.setOnClickListener(btnLinear);
        btnUga.setOnClickListener(btnLinear);
    }

    View.OnClickListener btnLinear = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //모두 안보이게하기
            linearDog.setVisibility(View.INVISIBLE);
            linearCat.setVisibility(View.INVISIBLE);
            linearUga.setVisibility(View.INVISIBLE);
            switch (v.getId()){
                case R.id.btn_dog:
                    linearDog.setVisibility(View.VISIBLE);
                    break;
                case R.id.btn_cat:
                    linearCat.setVisibility(View.VISIBLE);
                    break;
                case R.id.btn_uga:
                    linearUga.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

}