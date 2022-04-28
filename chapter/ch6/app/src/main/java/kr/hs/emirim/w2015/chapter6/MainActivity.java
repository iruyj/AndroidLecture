package kr.hs.emirim.w2015.chapter6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono1;
    RadioGroup rg;
    DatePicker datePick;
    TimePicker time;
    TextView textResult;
    RadioButton radioCal, radioTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p6_1);

        chrono1 = findViewById(R.id.chrono1);
        rg = findViewById(R.id.rg);
        datePick = findViewById(R.id.datepick);
        time = findViewById(R.id.time);
        textResult = findViewById(R.id.text_result);
        chrono1.setOnClickListener(chronoListener);
        textResult.setOnLongClickListener(textListener);

        rg.setOnCheckedChangeListener(radioListener);

        //calendar.setOnDateChangeListener(calendarListener);
    }
    RadioGroup.OnCheckedChangeListener radioListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            datePick.setVisibility(View.INVISIBLE);
            time.setVisibility(View.INVISIBLE);
            switch (checkedId){
                case R.id.radio_date:
                    datePick.setVisibility(View.VISIBLE);
                    break;
                case R.id.radio_time:
                    time.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    // 예약 시작했을때
    View.OnClickListener chronoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            chrono1.setBase(SystemClock.elapsedRealtime()); //avd에 있는 시계를 이용해 초단위로 사용
            chrono1.start();
            chrono1.setTextColor(Color.RED);
            rg.setVisibility(View.VISIBLE);
            datePick.setVisibility(View.VISIBLE);
        }
    };

    // 예약 끝났을 때
    View.OnLongClickListener textListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            chrono1.stop();
            chrono1.setTextColor(Color.BLUE);
            textResult.setText("  >> "+datePick.getYear() + "년" + (datePick.getMonth()+1) +"월 "+datePick.getDayOfMonth() +"일");
            textResult.append(time.getCurrentHour()+"시 "+time.getCurrentMinute()+"분 예약완료됨");
            rg.setVisibility(View.INVISIBLE);
            datePick.setVisibility(View.INVISIBLE);
            time.setVisibility(View.INVISIBLE);
            return false;
        }
    };

    //캘린더뷰일때는 변경되는 날짜를 가져오는 변수, 버튼이였는데 아니라서 없앰
/*    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_start:
                    chrono1.setBase(SystemClock.elapsedRealtime()); //avd에 있는 시계를 이용해 초단위로 사용
                    chrono1.start();
                    chrono1.setTextColor(Color.RED);
                    break;
                case R.id.btn_done:
                    chrono1.stop();
                    chrono1.setTextColor(Color.BLUE);
                    textResult.setText("  >> "+y + "년" + m +"월 "+d +"일");
                    textResult.append(time.getCurrentHour()+"시 "+time.getCurrentMinute()+"분 예약완료됨");
                    break;
            }
        }
    };

    int y, m, d;
    CalendarView.OnDateChangeListener calendarListener = new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
            y = year;
            m = month;
            d = dayOfMonth;
        }
    };*/
}