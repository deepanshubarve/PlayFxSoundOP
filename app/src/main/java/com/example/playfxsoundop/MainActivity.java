package com.example.playfxsoundop;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonone;
    private Button buttontwo;
    private Button buttonthree;
    private Button buttonfour;

    private SoundPool soundPool;
    private int sound1,sound2,sound3,sound4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sound1 = soundPool.load(this,R.raw.file_example,1);
        sound2 = soundPool.load(this,R.raw.heeriye,1);
        sound3 = soundPool.load(this,R.raw.file_example,1);
        sound4 = soundPool.load(this,R.raw.file_example,1);



        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .build();


        SoundPool soundPool = new SoundPool.Builder()
                .setMaxStreams(4)
                .setAudioAttributes(audioAttributes)
                .build();


        buttonone = findViewById(R.id.ButtonOne);
        buttontwo = findViewById(R.id.ButtonTwo);
        buttonthree = findViewById(R.id.ButtonThree);
        buttonfour = findViewById(R.id.ButtonFour);

        buttonone.setOnClickListener(this);
        buttontwo.setOnClickListener(this);
        buttonthree.setOnClickListener(this);
        buttonfour.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ButtonOne:
                soundPool.play(sound1,1,1,0,0,1);
                break;

            case R.id.ButtonTwo:
                soundPool.play(sound2,1,1,0,0,1);
                break;

            case R.id.ButtonThree:
                soundPool.play(sound3,1,1,0,0,1);
                break;

            case R.id.ButtonFour:
                soundPool.play(sound4,1,1,0,0,1);
                break;
        }

        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(soundPool!= null){
            soundPool.release();
            soundPool = null;
        }
    }
}
