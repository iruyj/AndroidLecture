package kr.hs.emirim.w2015.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    CheckBox checkStart;
    RadioGroup rg;
    ImageView imgv;
    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkStart = findViewById(R.id.start);
        linear = findViewById(R.id.linear);
        rg = findViewById(R.id.radio_group);
        imgv = findViewById(R.id.imgv);
        Button btn = findViewById(R.id.btn_done);

        checkStart.setOnCheckedChangeListener(checkListener);
        btn.setOnClickListener(btnListener);
    }

    CompoundButton.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                linear.setVisibility(View.VISIBLE);
            } else {
                linear.setVisibility(View.INVISIBLE);
            }
        }
    };

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (rg.getCheckedRadioButtonId()) {
                case R.id.radio_dog:
                    imgv.setImageResource(R.drawable.dog);
                    break;
                case R.id.radio_cat:
                    imgv.setImageResource(R.drawable.cat);
                    break;
                case R.id.radio_rabbit:
                    imgv.setImageResource(R.drawable.rabbit);
                    break;
            }
        }
    };
}
