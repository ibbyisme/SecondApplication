package com.example.secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.button6) Button b6;
    @BindView(R.id.editText) EditText t6;

    Button b1,b2,b4,b5,b7,b8;
    Intent i7,i8;
    EditText text1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        text1=(EditText)findViewById(R.id.editText);

        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new ButtonListener(){
            public void onClick(View v)
            {
                text1.setText("绑定了采用匿名内部类监视器");
            }
        });
        //内部类
        b4=(Button)findViewById(R.id.button4);
        FouthButton fouthbutton=new FouthButton();
        b4.setOnClickListener(fouthbutton);

        b5=(Button)findViewById(R.id.button5);
        b5.setOnClickListener(new onListenButton(text1));

        b7=(Button)findViewById(R.id.button7);
        b7.setOnClickListener(new ButtonListener());

        b8=(Button)findViewById(R.id.button8);
        b8.setOnClickListener(new ButtonListener());

    }
    @Override
    public void onClick(View v)
    {
        text1.setText("使用activity作为监视器");
    }
    @OnClick({R.id.button6})
    public void OnViewClick(View v)
    {
         t6.setText("BuTTerKnife绑定监听器");
    }
    class FouthButton implements View.OnClickListener {
        public void onClick(View v)
        {
            text1.setText("绑定了内部类实现监听");
        }
    }
    public void click1(View source)
    {
        text1.setText("绑定到标签类");
    }

    //@OnClick(R.id.button51)
   // public void OnViewClick(View v)
   // {
       // text1.setText("BuTTerKnife绑定监听器");
    //}
    public class ButtonListener implements View.OnClickListener{
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.button7:
                    i7=new Intent(MainActivity.this,Main7Activity.class);
                    startActivity(i7);
                    break;
                case R.id.button8:
                    i8=new Intent(MainActivity.this,Main8Activity.class);
                    startActivity(i8);
                    break;
                default:
                    break;
            }
        }

    }
    public class outListener implements View.OnClickListener{
        public void onClick(View v)
        {

        }
    }
}
class onListenButton implements View.OnClickListener {

    EditText text2;
    public onListenButton(EditText text2)
    {
        super();
        this.text2=text2;
    }
    public void onClick(View v)
    {
        text2.setText("使用外部类做监听器");
    }
}
