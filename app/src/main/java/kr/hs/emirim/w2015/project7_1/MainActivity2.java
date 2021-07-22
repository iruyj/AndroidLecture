package kr.hs.emirim.w2015.project7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {
    EditText editAngle;
    ImageView imgV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editAngle = findViewById(R.id.edit1);
        imgV = findViewById(R.id.img);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_pic_rotate:
                int angle = Integer.parseInt(editAngle.getText().toString());
                imgV.setRotation(angle);
                return true;
            case R.id.item_img1:
                imgV.setImageResource(R.drawable.bose1);
                return true;
            case R.id.item_img2:
                imgV.setImageResource(R.drawable.bose2);
                return true;
            case R.id.item_img3:
                imgV.setImageResource(R.drawable.bose3);
                return true;
        }
        return false;
    }
}