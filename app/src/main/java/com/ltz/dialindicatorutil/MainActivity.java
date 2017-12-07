package com.ltz.dialindicatorutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 千分表测量球面半径
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    
    private Button  btn1,btn2;
    private EditText D0,DLR,V1,R1,V2,R2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        D0  = (EditText) findViewById(R.id.D0);
        DLR= (EditText) findViewById(R.id.DLR);
        V1 = (EditText) findViewById(R.id.V1);
        R1= (EditText) findViewById(R.id.R1);
        V2= (EditText) findViewById(R.id.V2);
        R2= (EditText) findViewById(R.id.R2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       if(view.getId() == R.id.btn1){
           if(TextUtils.isEmpty(D0.getText().toString())){
               Toast.makeText(MainActivity.this,"D0不能为空",Toast.LENGTH_SHORT).show();
             return;
           }
           if(TextUtils.isEmpty(DLR.getText().toString())){
               Toast.makeText(MainActivity.this,"DLR不能为空",Toast.LENGTH_SHORT).show();
               return;
           }
           if(TextUtils.isEmpty(V1.getText().toString())){
               Toast.makeText(MainActivity.this,"V1不能为空",Toast.LENGTH_SHORT).show();
               return;
           }
           if(TextUtils.isEmpty(R1.getText().toString())){
               Toast.makeText(MainActivity.this,"R1不能为空",Toast.LENGTH_SHORT).show();
               return;
           }
           if(TextUtils.isEmpty(V2.getText().toString())){
               Toast.makeText(MainActivity.this,"V2不能为空",Toast.LENGTH_SHORT).show();
               return;
           }
         String R2_str =  Utils.CalculationR2(MainActivity.this,D0.getText().toString(),DLR.getText().toString(),V1.getText().toString(),R1.getText().toString(),V2.getText().toString());
         R2.setText(R2_str);
       }else{
           if(TextUtils.isEmpty(D0.getText().toString())){
               Toast.makeText(MainActivity.this,"D0不能为空",Toast.LENGTH_SHORT).show();
               return;
           }
           if(TextUtils.isEmpty(DLR.getText().toString())){
               Toast.makeText(MainActivity.this,"DLR不能为空",Toast.LENGTH_SHORT).show();
               return;
           }
           if(TextUtils.isEmpty(V1.getText().toString())){
               Toast.makeText(MainActivity.this,"V1不能为空",Toast.LENGTH_SHORT).show();
               return;
           }
           if(TextUtils.isEmpty(R1.getText().toString())){
               Toast.makeText(MainActivity.this,"R1不能为空",Toast.LENGTH_SHORT).show();
               return;
           }
           if(TextUtils.isEmpty(R2.getText().toString())){
               Toast.makeText(MainActivity.this,"R2不能为空",Toast.LENGTH_SHORT).show();
               return;
           }
           String V2_str =  Utils.CalculationV2(MainActivity.this,D0.getText().toString(),DLR.getText().toString(),V1.getText().toString(),R1.getText().toString(),R2.getText().toString());
           V2.setText(V2_str);
       }
    }
}
