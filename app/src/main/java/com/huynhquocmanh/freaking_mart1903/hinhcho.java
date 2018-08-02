package com.huynhquocmanh.freaking_mart1903;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class hinhcho extends Activity implements View.OnClickListener {
    ImageButton imbplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hinhcho);
        imbplay = findViewById(R.id.buttonplay);
        imbplay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent iflash = new Intent(hinhcho.this, MainActivity.class);
        startActivity(iflash);
    }
}
