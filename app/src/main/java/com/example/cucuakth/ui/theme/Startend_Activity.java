package com.example.cucuakth.ui.theme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cucuakth.R;

public class Startend_Activity extends Activity {
    Button btnPlay,btnInstruct,btnExit;
    public void onCreate(Bundle savedInstanState){
        super.onCreate(savedInstanState);
        setContentView(R.layout.startend_layout);

        anhXa();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Startend_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        });
        btnInstruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Startend_Activity.this);
                builder.setTitle("Hướng dẫn");
                builder.setMessage("Trước khi nhấn nút bắt đầu hay chọn đối tượng mà bạn nghĩ là sẽ chiến thắng. Nếu đúng bạn được cộng 10 điểm còn sai sẽ trừ 5 điểm. Nhấn nút OK để tiếp tục.");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
    private void anhXa(){
        btnPlay = (Button) findViewById(R.id.play);
        btnInstruct = (Button) findViewById(R.id.instruct);
        btnExit = (Button) findViewById(R.id.exit);
    }
}
