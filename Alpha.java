package com.example.vasavigeethay.sahi;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Alpha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha);
        String value = "https://drive.google.com/file/d/0ByknvhcdvAnNR0lmQnRmV0xCVHc/view"; //http://www.ebookfrenzy.com/android_book/movie.mp4

        VideoView v = (VideoView)findViewById(R.id.videoView);
        Uri video = Uri.parse(value);
        v.setVideoURI(video);
        //v.setVideoPath("");

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(v);
        v.setMediaController(mediaController);

        v.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Alpha.this.finish();
            }
        });
        v.start();
    }
}
