package com.example.firoz.call;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText e1;
    public MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp=MediaPlayer.create(this,R.raw.button_tone);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        data();
    }

    public void data() {
        e1 = (EditText) findViewById(R.id.editText1);
        int[] idList = {R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10, R.id.button11, R.id.button12, R.id.button13,R.id.button14};
        for (int buttons : idList) {
            View v = (View) findViewById(buttons);
            v.setOnClickListener(this);
        }
    }

    public void display(String val) {
        e1.append(val);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                mp.start();
                display("1");
                break;
            case R.id.button2:
                mp.start();
                display("2");
                break;
            case R.id.button3:
                mp.start();
                display("3");
                break;
            case R.id.button4:
                mp.start();
                display("4");
                break;
            case R.id.button5:
                mp.start();
                display("5");
                break;
            case R.id.button6:
                mp.start();
                display("6");
                break;
            case R.id.button7:
                mp.start();
                display("7");
                break;
            case R.id.button8:
                mp.start();
                display("8");
                break;
            case R.id.button9:
                mp.start();
                display("9");
                break;
            case R.id.button10:
                mp.start();
                display("*");
                break;
            case R.id.button11:
                mp.start();
                display("0");
                break;
            case R.id.button12:
                mp.start();
                display("#");
                break;
            case R.id.button13:
                mp.start();
                Intent call = new Intent(Intent.ACTION_CALL);
                String number=e1.getText().toString();
                if(number.trim().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please enter valid number",Toast.LENGTH_SHORT).show();
                    return;
                }

                call.setData(Uri.parse("tel:" + number));

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(call);

                break;
            case R.id.button14:
                if(e1.getText().toString().length()>=1)
                {
                    String del=e1.getText().toString().substring(0, e1.getText().toString().length()-1);
                    e1.setText(del);
                    e1.setSelection(e1.getText().toString().length());
                    mp.start();
                }

                break;
            default:
                break;



        }
    }

}
