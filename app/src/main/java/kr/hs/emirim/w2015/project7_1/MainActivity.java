package kr.hs.emirim.w2015.project7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear1;
    Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear1 = findViewById(R.id.linear1);
        btn1 = findViewById(R.id.btn1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
         MenuInflater inflater = getMenuInflater();
         inflater.inflate(R.menu.menu1, menu);
         return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item_red:
                linear1.setBackgroundColor(Color.RED);
                return true;
            case R.id.item_yellow:
                linear1.setBackgroundColor(Color.RED);
                return true;
            case R.id.item_blue:
                linear1.setBackgroundColor(Color.RED);
                return true;
            case R.id.item_rotate:
                btn1.setRotation(45);
                return true;
            case R.id.item_zoom:
                btn1.setScaleX(2);
                return true;
        }
        //우리가 직접 작성할때 false로 해줌
        return false;

    }
}