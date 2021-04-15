package kr.hs.emirim.w2015.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Switch switchStart;
    RadioGroup rg;
    ImageView imgv;
    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchStart = findViewById(R.id.switch_start);
        linear = findViewById(R.id.linear);
        rg = findViewById(R.id.radio_group);
        imgv = findViewById(R.id.imgv);
        Button btnFinish = findViewById(R.id.btn_finish);
        Button btnFirst = findViewById(R.id.btn_first);

        btnFinish.setOnClickListener(btnListener);
        btnFirst.setOnClickListener(btnListener);

        switchStart.setOnCheckedChangeListener(checkListener);
        rg.setOnCheckedChangeListener(rgListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_finish:
                    finish();
                    break;
                case R.id.btn_first:
                    linear.setVisibility(View.VISIBLE);
                    switchStart.setChecked(false);
                    break;
            }
        }
    };

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

    RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
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
