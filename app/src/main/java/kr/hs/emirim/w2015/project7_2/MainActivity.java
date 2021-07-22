package kr.hs.emirim.w2015.project7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear1;
    Button btnBg, btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linear1 = findViewById(R.id.linear1);
        btnBg = findViewById(R.id.btn_bg);
        btnChange = findViewById(R.id.btn_change);
        registerForContextMenu(btnBg);
        registerForContextMenu(btnChange);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        if(v == btnBg){
            menu.setHeaderTitle(R.string.btn_bg);
            inflater.inflate(R.menu.menu1, menu);
        }else {
            menu.setHeaderTitle(R.string.btn_change);
            inflater.inflate(R.menu.menu2, menu);

        }

    }
}