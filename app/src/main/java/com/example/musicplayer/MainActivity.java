package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Note1: define the media player as a member of the activity.
    private MediaPlayer _mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Note2: initialize the media player with the activity.
        // This makes it ready to play the media upon calling start().
        // _mediaPlayer = MediaPlayer.create(this, R.raw.lisa_gerrard);
        _mediaPlayer = MediaPlayer.create(this, R.raw.number_one);
        // Note3: lisa_gerrard is the resource. In this case the mp3 file
        //        from the res/raw directory lisa_gerrard.mp3
        // Note4: file-based resource names must consist of {[a-z][0-9]_}.
        //        No uppercase!!

        Button playButton = findViewById(R.id.play_button);
        playButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Note3: data members of the activity are
                // accessible inside the onClick callback.
                _mediaPlayer.start();
                // Toast.makeText(MainActivity.this, "Play!", Toast.LENGTH_SHORT).show();
            }
        });

        Button pauseButton = findViewById(R.id.pause_button);
        pauseButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _mediaPlayer.pause();
                Toast.makeText(MainActivity.this, "Pause!", Toast.LENGTH_SHORT).show();
            }
        });

        _mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this, "Completed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
