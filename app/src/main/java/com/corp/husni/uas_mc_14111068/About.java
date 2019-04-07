package com.corp.husni.uas_mc_14111068;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class About extends AppCompatActivity {
    ImageButton email,ig,myig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        email = (ImageButton)findViewById(R.id.emailbtn);
        ig = (ImageButton)findViewById(R.id.igbutton);
        myig = (ImageButton)findViewById(R.id.myigbutton);

        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
  
   /*             contoh yg lain untuk view page
Uri webpage = Uri.parse("http://www.android.com");
Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);*/

                Intent ig = new Intent(Intent.ACTION_VIEW);
                ig.setData(Uri.parse("https://www.instagram.com/aonsjogja/"));
                startActivity(ig);
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kirim_email = new Intent(Intent.ACTION_SEND);
                kirim_email.setType("message/rfc822");
                kirim_email.putExtra(Intent.EXTRA_SUBJECT,"Kirim Feedback");
                kirim_email.putExtra(Intent.EXTRA_EMAIL,new String[]{"mohhusnimubaraq@gmail.com"});
                //startActivity(Intent.createChooser(kirim_email,"Pilih Email"));
                startActivity(kirim_email);
                //Toast.makeText(About.this, "Under Construction", Toast.LENGTH_SHORT).show();
            }
        });
        myig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myinsta = new Intent(Intent.ACTION_VIEW);
                myinsta.setData(Uri.parse("https://www.instagram.com/whoishusni/"));
                startActivity(myinsta);
            }
        });

    }
}
