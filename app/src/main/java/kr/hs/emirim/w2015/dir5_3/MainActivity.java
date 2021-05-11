package kr.hs.emirim.w2015.dir5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipboardManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linear = new LinearLayout(this);
        linear.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setContentView(linear,params);

        edit = new EditText(this);
        Button btn = new Button(this);
        text = new TextView(this);
        text.setTextColor(Color.MAGENTA);
        text.setTextSize(20);
//        text.setText

        linear.addView(edit);
        linear.addView(btn);
        linear.addView(text);

        btn.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            text.setText(edit.getText().toString());
        }
    };
}