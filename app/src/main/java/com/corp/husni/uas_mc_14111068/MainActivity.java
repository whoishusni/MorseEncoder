package com.corp.husni.uas_mc_14111068;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton encode,share,copy,clear;
    EditText teks_biasa;
    TextView teks_morse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encode = (ImageButton) findViewById(R.id.tombol_encode);
        share = (ImageButton) findViewById(R.id.tombol_share);
        copy = (ImageButton) findViewById(R.id.tombol_copy);
        clear = (ImageButton) findViewById(R.id.tombol_clear);
        teks_biasa = (EditText)findViewById(R.id.teks_biasa_isi);
        teks_morse = (TextView)findViewById(R.id.teks_morse_hasil);

        encode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (teks_biasa.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Isi Dulu Teksnya Gan !!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    teks_morse.setText(encodeTeks(teks_biasa.getText().toString()));
                }
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bagimorse();
            }
        });
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kopimorse();

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearteks();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_utama,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int pilihMenu = item.getItemId();
        if (pilihMenu == R.id.morseAlpa){
            Intent morsealphabet = new Intent(MainActivity.this,Alphabet.class);
            startActivity(morsealphabet);

        }
        else if (pilihMenu == R.id.pengaturan){
            Intent pengaturan = new Intent(MainActivity.this,Petunjuk.class);
            startActivity(pengaturan);
        }
        else if(pilihMenu == R.id.about){
            Intent aboutme = new Intent(MainActivity.this,About.class);
            startActivity(aboutme);
        }
        else if (pilihMenu == R.id.bagi){
            Intent bagi_aplikasi = new Intent(Intent.ACTION_SEND);
            bagi_aplikasi.setType("text/plain");
            String tulisan_bagi = "Hallo saya Pake Aplikasi Keren Loh, kalo mau kirim email ke mohhusnimubaraq@gmail.com";
            bagi_aplikasi.putExtra(Intent.EXTRA_TEXT,tulisan_bagi);
            startActivity(Intent.createChooser(bagi_aplikasi,"Kirim Via Apa Gan ???"));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            AlertDialog.Builder konfirmasi = new AlertDialog.Builder(this);
            konfirmasi.setTitle("Keluar");
            konfirmasi.setMessage("Yakin Anda Ingin Keluar Aplikasi Ini ?");
            konfirmasi.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    Toast.makeText(MainActivity.this, "Anda Telah Keluar !!!", Toast.LENGTH_SHORT).show();
                }
            });
            konfirmasi.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog konfirmasi_dialog = konfirmasi.create();
            konfirmasi_dialog.show();
        }
        return super.onKeyDown(keyCode, event);
    }

    public String encodeTeks(String teks){
        String hurufAngka = "";
        hurufAngka = teks.toUpperCase();

        //angka
        hurufAngka = hurufAngka.replace("0","-----"+"/");
        hurufAngka = hurufAngka.replace("1",".----"+"/");
        hurufAngka = hurufAngka.replace("2","..---"+"/");
        hurufAngka = hurufAngka.replace("3","...--"+"/");
        hurufAngka = hurufAngka.replace("4","....-"+"/");
        hurufAngka = hurufAngka.replace("5","....."+"/");
        hurufAngka = hurufAngka.replace("6","-...."+"/");
        hurufAngka = hurufAngka.replace("7","--..."+"/");
        hurufAngka = hurufAngka.replace("8","---.."+"/");
        hurufAngka = hurufAngka.replace("9","----."+"/");

        //huruf
        hurufAngka = hurufAngka.replace("A",".-"+"/");
        hurufAngka = hurufAngka.replace("B","-..."+"/");
        hurufAngka = hurufAngka.replace("C","-.-."+"/");
        hurufAngka = hurufAngka.replace("D","-.."+"/");
        hurufAngka = hurufAngka.replace("E","."+"/");
        hurufAngka = hurufAngka.replace("F","..-."+"/");
        hurufAngka = hurufAngka.replace("G","--."+"/");
        hurufAngka = hurufAngka.replace("H","...."+"/");
        hurufAngka = hurufAngka.replace("I",".."+"/");
        hurufAngka = hurufAngka.replace("J",".---"+"/");
        hurufAngka = hurufAngka.replace("K","-.-"+"/");
        hurufAngka = hurufAngka.replace("L",".-.."+"/");
        hurufAngka = hurufAngka.replace("M","--"+"/");
        hurufAngka = hurufAngka.replace("N","-."+"/");
        hurufAngka = hurufAngka.replace("O","---"+"/");
        hurufAngka = hurufAngka.replace("P",".--."+"/");
        hurufAngka = hurufAngka.replace("Q","--.-"+"/");
        hurufAngka = hurufAngka.replace("R",".-."+"/");
        hurufAngka = hurufAngka.replace("S","..."+"/");
        hurufAngka = hurufAngka.replace("T","-"+"/");
        hurufAngka = hurufAngka.replace("U","..-"+"/");
        hurufAngka = hurufAngka.replace("V","...-"+"/");
        hurufAngka = hurufAngka.replace("W",".--"+"/");
        hurufAngka = hurufAngka.replace("X","-..-"+"/");
        hurufAngka = hurufAngka.replace("Y","-.--"+"/");
        hurufAngka = hurufAngka.replace("Z","--.."+"/");

        //karakter spasi
        hurufAngka = hurufAngka.replace(" ","   ");
        return hurufAngka;

    }
    public void clearteks(){
        teks_biasa.setText("");
        teks_biasa.setHint("isi teks yang mau diterjemahkan");
        teks_morse.setText("");
        teks_morse.setHint("Hasil Text Morse");
    }
    private void kopimorse() {
        teks_morse = (TextView)findViewById(R.id.teks_morse_hasil);
        ClipboardManager klipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData klip = ClipData.newPlainText("klip",teks_morse.getText().toString());
        klipboard.setPrimaryClip(klip);
        Toast.makeText(this, "Teks Morse Tersalin !!!", Toast.LENGTH_SHORT).show();

    }

    private void bagimorse() {
        teks_morse = (TextView)findViewById(R.id.teks_morse_hasil);
        Intent bagimor = new Intent(Intent.ACTION_SEND);
        bagimor.setType("text/plain");
        String bag = teks_morse.getText().toString();
        bagimor.putExtra(Intent.EXTRA_TEXT,bag);
        startActivity(Intent.createChooser(bagimor,"Kirim lewat ..."));

    }

}
