package com.example.button_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import me.tankery.lib.circularseekbar.CircularSeekBar;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    AudioManager audioManager;
    ImageView pause;
    ImageView animeImg;
    TextView gaane;
    TextView singer;
    CircularSeekBar gol_gaana;
    TextView tim;
    TextView onGoing;
    Button privacy;

    int num = 0;
    int[] imagesAnime = {R.drawable.naruto,R.drawable.nandemonaiya,R.drawable.tancir,R.drawable.yourname,R.drawable.yourlie};
    int[] animeSongs = {R.raw.bluebird,R.raw.nande,R.raw.gurenge,R.raw.yourname,R.raw.hikarunara};
    String[] animeSongsName = {"BlueBird","Nandemonaiya","Gurenge","Sparkle","Hikaru Nara"};
    String[] gayak = {"Ikimono-gakari","Radwimps","Lisa","Radwimps","Goose House"};
    int size = imagesAnime.length;

    public void gaana(int num){
        player.stop();
        player = MediaPlayer.create(this,animeSongs[num]);
        gaane.setText(animeSongsName[num]);
        singer.setText(gayak[num]);
        Toast.makeText(this, "Playing : " + animeSongsName[num], Toast.LENGTH_SHORT).show();
        player.start();
        timerFunc();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "This is OnStart State", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        if(player.isPlaying())
//            player.start();
        Toast.makeText(this, "This is Resume State", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        player.pause();
        Toast.makeText(this, "This is Paused State", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "This is Stop State", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        tim = (TextView) findViewById(R.id.musicDuration);
        player = MediaPlayer.create(this,R.raw.bluebird);
        timerFunc();

        pause = (ImageView) findViewById(R.id.pauseButton);

        gaane = (TextView) findViewById(R.id.songName);
        singer = (TextView) findViewById(R.id.singerName);

        animeImg = (ImageView) findViewById(R.id.songPhoto);
        onGoing = (TextView) findViewById(R.id.onGoing);
        privacy = findViewById(R.id.privacyPolicy);
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

        SeekBar volume = findViewById(R.id.volume);
        volume.setMax(maxVol);
        volume.setProgress(curVol);

        volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar songProg = (SeekBar) findViewById(R.id.songPush);
        songProg.setMax(player.getDuration());

        songProg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                onGoingSong(i);
                endTime(i);
                player.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                songProg.setProgress(player.getCurrentPosition());
            }
        },0,1000);

        gol_gaana = findViewById(R.id.circular_song);
        gol_gaana.setMax(player.getDuration());

        gol_gaana.setOnSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularSeekBar circularSeekBar, float v, boolean b) {
                player.seekTo((int) v);
            }

            @Override
            public void onStopTrackingTouch(CircularSeekBar circularSeekBar) {

            }

            @Override
            public void onStartTrackingTouch(CircularSeekBar circularSeekBar) {

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                gol_gaana.setProgress(player.getCurrentPosition());
            }
        },0,1000);
    }

    public void openActivity(){
        Intent intent = new Intent(this,privacyPolicy.class);
        startActivity(intent);
    }

    boolean shuru = true;

    public void onGoingSong(int i){
        String dark;
        i = i/1000;
        int min = i/60;
        int sec = i - min*60;
        if (min==0)
            if (sec<=9)
                dark = "00" + ":0" + sec;
            else
                dark = "00" + ":" + sec;
        else if (min>0 && min<=9)
            if (sec<=9)
                dark = "0" + min + ":0" + sec;
            else
                dark = "0" + min + ":" + sec;
        else
            if (sec<=9)
                dark = min + ":0" + sec;
             else
                dark = min + ":" + sec;
        onGoing.setText(dark);
    }

    public void endTime(int i){
        String dark;
        int time = player.getDuration();
        time = time / 1000;
        i = i/1000;
        int saver = time - i;

        int min = saver/60;
        int sec = saver - min*60;
        if (min==0)
            if (sec<=9)
                dark = "00" + ":0" + sec;
            else
                dark = "00" + ":" + sec;
        else if (min>0 && min<=9)
            if (sec<=9)
                dark = "0" + min + ":0" + sec;
            else
                dark = "0" + min + ":" + sec;
        else
        if (sec<=9)
            dark = min + ":0" + sec;
        else
            dark = min + ":" + sec;
        tim.setText(dark);
    }

    public void timerFunc(){
        String timerSong;
        int time = player.getDuration();
        time = time/1000;
        int minutes = time/60;
        int seconds = time - minutes*60;
        if (seconds<=9)
            timerSong = "0" + minutes + ":0" + seconds;
        else
            timerSong = "0" + minutes + ":" + seconds;
        tim.setText(timerSong);
    }

    public void next(View view){
        num++;
        if (num==size)
            num=0;
        animeImg.setImageResource(imagesAnime[num]);
        gaana(num);
        pause.setImageResource(R.drawable.stop);
        shuru = false;
    }

    public void prev(View view){
        num--;
        if (num<0) {
            num = size-1;
            animeImg.setImageResource(imagesAnime[num]);
            gaana(num);
            pause.setImageResource(R.drawable.stop);
            shuru = false;
        }
        else{
            animeImg.setImageResource(imagesAnime[num]);
            gaana(num);
            pause.setImageResource(R.drawable.stop);
            shuru = false;
        }
    }

    public void play(View view){
        if (shuru){
            player.start();
            pause.setImageResource(R.drawable.stop);
            shuru = false;
        }
        else{
            player.pause();
            pause.setImageResource(R.drawable.playing);
            shuru = true;
        }
    }
}