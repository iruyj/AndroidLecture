package kr.hs.emirim.w2015.project7_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

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

        btnBg.setOnClickListener(btnListener);

    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast toast = Toast.makeText(getApplicationContext(),"배경색 변경을 원하면 롱클릭~ 하세요",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP|Gravity.LEFT,100,200);
            toast.show();
        }
    };
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

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.bg1:
                linear1.setBackgroundColor(Color.RED);
                return true;
            case R.id.bg2:
                linear1.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.bg3:
                linear1.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.item_rotate:
                btnChange.setRotation(90);
                return true;
            case R.id.item_zoom:
                btnChange.setScaleX(2);
                return true;
        }
        return false;
    }
}