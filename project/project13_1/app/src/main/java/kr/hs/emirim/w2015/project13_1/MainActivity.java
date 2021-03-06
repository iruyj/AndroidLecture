package kr.hs.emirim.w2015.project13_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list1;
    TextView textMusic,textTime;
    SeekBar seek1;
    ArrayList<String> arrayList;
    String selectedMusic;
    String musicPath = Environment.getExternalStorageDirectory().getPath() +"/";
    MediaPlayer media;
    boolean puse = true;
    Button btnStart,btnStop,btnPuse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MP3 Player");
        //외부 스토리지 사용할 때 씀
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
        arrayList = new ArrayList<String>();
        File[] listFiles = new File(musicPath).listFiles();
        String fileName, extName;
        for(File file : listFiles){
            fileName = file.getName();
            extName = fileName.substring(fileName.length()-3);  //확장자이름 저장
            if(extName.equals("mp3"))
                arrayList.add(fileName);
        }
        // 리스트 코드
        list1 = findViewById(R.id.list1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrayList);
        list1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list1.setAdapter(adapter);
        list1.setItemChecked(0,true);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedMusic = arrayList.get(position);
            }
        });
        selectedMusic = arrayList.get(0);   // 리스트를 클릭하지 않았을 때 초기값

        // 버튼 코드
        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);
        btnPuse = findViewById(R.id.btn_puse);
        textMusic = findViewById(R.id.text_music);
        textTime = findViewById(R.id.text_time);
        seek1 = findViewById(R.id.seek1);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    media = new MediaPlayer();
                    media.setDataSource(musicPath + selectedMusic);     //경로와 선택한 뮤직이름
                    media.prepare();
                    media.start();
                    btnStart.setClickable(false);
                    btnStop.setClickable(true);
                    textMusic.setText(selectedMusic+" : ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                runOnThread();

            }
        });
        btnPuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (puse){
                    media.stop();
                    btnPuse.setText("이어듣기");
                    puse = false;
                }else{
                    media.start();
                    runOnThread();
                    btnPuse.setText("일시정지");
                    puse = true;
                }

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                media.stop();
                media.reset();
                btnStart.setClickable(true);
                btnStop.setClickable(false);
                puse = true;
                seek1.setProgress(0);
                btnPuse.setText("일시정지");
                textMusic.setText("실행음악 중지");
                textTime.setText(R.string.text_time);

            }
        });
        btnStop.setClickable(false);
    }

    public void runOnThread(){
        new Thread(){
            SimpleDateFormat defalte = new SimpleDateFormat("mm:ss");
            @Override
            public void run() {
                if(media == null)
                    return;
                seek1.setMax(media.getDuration());  //음악 시간 길이
                while(media.isPlaying()){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            seek1.setProgress(media.getCurrentPosition());
                            textTime.setText(R.string.text_time);
                            textTime.append(defalte.format(media.getCurrentPosition()));
                        }
                    });
                    SystemClock.sleep(200);
                }
            }
        }.start();
    }
}