package com.ltz.dialindicatorutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 千分表测量球面半径
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    
    private Button  btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       if(view.getId() == R.id.btn1){
           Toast.makeText(MainActivity.this,"计算球面半径",Toast.LENGTH_SHORT).show();
       }else{
           Toast.makeText(MainActivity.this,"计算千分表读数",Toast.LENGTH_SHORT).show();
       }
    }
}
