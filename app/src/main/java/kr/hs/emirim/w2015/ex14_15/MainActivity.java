package kr.hs.emirim.w2015.ex14_15;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnD = findViewById(R.id.btn_dialog);
        btnD.setOnClickListener(btnListener);
    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//            dialog.setTitle(R.string.dialog_title);
//            dialog.setMessage(R.string.dialog_messge);
//            dialog.setIcon(R.drawable.dial);
            // 간결하게 코드 바꾸는 방법
            new AlertDialog.Builder(MainActivity.this)
            .setTitle(R.string.dialog_title)
            .setMessage(R.string.dialog_messge)
            .setIcon(R.drawable.dial)
            //대화상자 닫을 버튼
            .setPositiveButton(R.string.btn_positive, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "대화상자 확인버튼 눌렀음", Toast.LENGTH_SHORT).show();
                }
            })
            .show();
        }
    };
}