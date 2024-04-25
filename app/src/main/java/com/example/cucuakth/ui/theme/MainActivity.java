package com.example.cucuakth.ui.theme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cucuakth.R;

import java.util.Random;

public class MainActivity extends Activity {

    CheckBox checkBox1,checkBox2,checkBox3;
    SeekBar seekBar1,seekBar2,seekBar3;
    Button button1,button2;
    TextView diemso;
    int diem=100;
    protected void onCreate(Bundle savesInstancestate) {
        super.onCreate(savesInstancestate);
        setContentView(R.layout.layout);

        anhXa();
        seekBar1.setEnabled(false);
        seekBar2.setEnabled(false);
        seekBar3.setEnabled(false);
        String diem_st = String.valueOf(diem);
        diemso.setText(diem_st);
        seekBar1.setProgress(5);
        seekBar2.setProgress(5);
        seekBar3.setProgress(5);
        CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                int sord = 5;
                Random random = new Random();
                int number = random.nextInt(sord);
                int number1 = random.nextInt(sord);
                int number2 = random.nextInt(sord);

                if(seekBar1.getProgress() >= seekBar1.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this,"Cà Chua 1 Win",Toast.LENGTH_LONG).show();
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    if(checkBox1.isChecked()){
                        diem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán đùng rồi", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        diem -=5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();
                        if(diem <=0) {
                            chuyendoi();
                            Toast.makeText(MainActivity.this,"Bạn đã thua cuộc!",Toast.LENGTH_LONG).show();
                        }
                    }
                    String diem_st = String.valueOf(diem);
                    diemso.setText(diem_st);
                    bat_tt();
                }
                if(seekBar2.getProgress() >= seekBar2.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this,"Cà Chua 2 Win",Toast.LENGTH_LONG).show();
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    if(checkBox2.isChecked()){
                        diem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán đùng rồi", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        diem -=5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();
                        if(diem <=0) {
                            chuyendoi();
                            Toast.makeText(MainActivity.this,"Bạn đã thua cuộc!",Toast.LENGTH_LONG).show();
                        }
                    }
                    String diem_st = String.valueOf(diem);
                    diemso.setText(diem_st);
                    bat_tt();
                }
                if(seekBar3.getProgress() >= seekBar3.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this,"Cà Chua 3 Win",Toast.LENGTH_LONG).show();
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    if(checkBox3.isChecked()){
                        diem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán đùng rồi", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        diem -=5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();
                        if(diem <=0) {
                            chuyendoi();
                            Toast.makeText(MainActivity.this,"Bạn đã thua cuộc!",Toast.LENGTH_LONG).show();
                        }
                    }
                    String diem_st = String.valueOf(diem);
                    diemso.setText(diem_st);
                    bat_tt();
                }
                seekBar1.setProgress(seekBar1.getProgress()+number);
                seekBar2.setProgress(seekBar2.getProgress()+number1);
                seekBar3.setProgress(seekBar3.getProgress()+number2);
            }

            @Override
            public void onFinish() {

            }
        };
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked()) {
                    seekBar1.setProgress(0);
                    seekBar2.setProgress(0);
                    seekBar3.setProgress(0);

                    button1.setVisibility(View.INVISIBLE);
                    button2.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    tat_tt();
                }
                else {
                    Toast.makeText(MainActivity.this,"Đặt cược đề bắt đầu!",Toast.LENGTH_LONG).show();
                }
            }
        });
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox2.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox1.setChecked(false);
                    checkBox3.setChecked(false);
                }
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox2.setChecked(false);
                    checkBox1.setChecked(false);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Startend_Activity.class);
                startActivity(intent);

            }
        });
    }
    private void bat_tt(){
        checkBox1.setEnabled(true);
        checkBox2.setEnabled(true);
        checkBox3.setEnabled(true);
    }
    private void tat_tt(){
        checkBox1.setEnabled(false);
        checkBox2.setEnabled(false);
        checkBox3.setEnabled(false);
    }
    private void anhXa() {
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.Thoat);

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);

        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        diemso = findViewById(R.id.diem);
    }
    private void chuyendoi(){
        Intent intent = new Intent(MainActivity.this,Startend_Activity.class);
        startActivity(intent);
    }
}
