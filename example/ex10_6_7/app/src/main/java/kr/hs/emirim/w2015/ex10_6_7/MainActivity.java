package kr.hs.emirim.w2015.ex10_6_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {
    RatingBar rating1, rating2, rating3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rating1 = findViewById(R.id.rating1);
        rating2 = findViewById(R.id.rating2);
        rating3 = findViewById(R.id.rating3);

        Button btnInc = findViewById(R.id.btn_incr);
        Button btnDec = findViewById(R.id.btn_decr);
        btnInc.setOnClickListener(btnlistener);
        btnDec.setOnClickListener(btnlistener);
    }
    View.OnClickListener btnlistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_incr:
                    rating1.setRating(rating1.getRating()+ rating1.getStepSize());
                    rating2.setRating(rating2.getRating()+ rating2.getStepSize());
                    rating3.setRating(rating3.getRating()+ rating3.getStepSize());
                    break;
                case R.id.btn_decr:
                    rating1.setRating(rating1.getRating()- rating1.getStepSize());
                    rating2.setRating(rating2.getRating()- rating2.getStepSize());
                    rating3.setRating(rating3.getRating()- rating3.getStepSize());
                    break;
            }
        }
    };
}