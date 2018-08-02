package com.huynhquocmanh.freaking_mart1903;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity {
    TextView txtnumber1, txtnumber2, txtketqua, txtpheptinh ,txtdiemso;
    ImageButton btndung, btnsai;
    int number1, number2;
    String pheptinh;
    int ketqua;
    int diemso =100;
    boolean Check;
    ArrayList<String> mangpheptinh = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        initrandum();
        btndung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Check == true) {
                    Toast.makeText(MainActivity.this, "dung roi", Toast.LENGTH_SHORT).show();
                    initrandum();
                    diemso +=10;

                } else {
                    Toast.makeText(MainActivity.this, "sai roi", Toast.LENGTH_SHORT).show();
                    diemso -=5;
                }
                txtdiemso.setText(diemso+"");

            }
        });
        btnsai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Check == false) {
                    Toast.makeText(MainActivity.this, "dung roi", Toast.LENGTH_SHORT).show();
                    initrandum();
                } else {
                    Toast.makeText(MainActivity.this, "sai roi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initrandum() {
        Random randum = new Random();
        Check = randum.nextBoolean();
        number1 = randum.nextInt(10) + 1;
        number2 = randum.nextInt(10) + 1;
        mangpheptinh.add("+");
        mangpheptinh.add("-");
        mangpheptinh.add("*");
        int indexsofarray = randum.nextInt(mangpheptinh.size());
        pheptinh = mangpheptinh.get(indexsofarray);
        switch (pheptinh) {
            case "+":
                ketqua = number1 + number2;
                break;
            case "-":
                ketqua = number1 - number2;
                break;
            case "*":
                ketqua = number1 * number2;
                break;
        }
        if (Check == true) {

        } else {
            ketqua += randum.nextInt(5) + 1;
        }
        txtketqua.setText("=" + ketqua);
        txtnumber1.setText(number1 + "");
        txtnumber2.setText(number2 + "");
        txtpheptinh.setText(pheptinh);
    }

    private void anhxa() {
        txtdiemso = (TextView) findViewById(R.id.diemso) ;
        txtnumber1 = (TextView) findViewById(R.id.textviewNumber1);
        txtnumber2 = (TextView) findViewById(R.id.textviewNumber2);
        txtpheptinh = (TextView) findViewById(R.id.textviewpheptinh);
        txtketqua = (TextView) findViewById(R.id.textviewketqua);
        btndung = (ImageButton) findViewById(R.id.buttondung);
        btnsai = (ImageButton) findViewById(R.id.buttonsai);
    }
}
