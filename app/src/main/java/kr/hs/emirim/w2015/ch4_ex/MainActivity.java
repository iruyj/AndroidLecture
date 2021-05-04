package kr.hs.emirim.w2015.ch4_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ed = findViewById(R.id.edit);
        setContentView(R.layout.activity_main);
        ed.setOnKeyListener(kdyListener);
    }

    View.OnKeyListener kdyListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            //KeyEvent.AcTION_UP : 키를 눌렀다가 땟을 때마다 토스트에 입력된 글을 올린다
            if (event.getAction()== KeyEvent.ACTION_UP){
                Toast.makeText(getApplicationContext(), ed.getText().toString(), Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    };
}