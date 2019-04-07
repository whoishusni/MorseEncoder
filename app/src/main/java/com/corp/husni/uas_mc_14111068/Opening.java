package com.corp.husni.uas_mc_14111068;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class Opening extends AppCompatActivity {
    RelativeLayout rel_opening;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_opening);

        //2000 = 2 detik
        int lama_waktu = 2000;

        Handler slide = new Handler();
        slide.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent pindah = new Intent(Opening.this,MainActivity.class);
                startActivity(pindah);
                finish();
            }
        },lama_waktu);
    }
}
