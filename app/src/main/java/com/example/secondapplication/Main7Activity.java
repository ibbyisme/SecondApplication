package com.example.secondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main7Activity extends AppCompatActivity {

    EditText edit1,edit2,edit3,edit4;
    Button bt7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        edit1=(EditText)findViewById(R.id.edit_71);
        edit2=(EditText)findViewById(R.id.edit_72);
        edit3=(EditText)findViewById(R.id.edit_73);
        edit4=(EditText)findViewById(R.id.edit_74);
        bt7=(Button)findViewById(R.id.button_71);
        bt7.setOnClickListener(new ButtonListener());
    }
    public class ButtonListener implements View.OnClickListener{
        public void onClick(View v){

            Configuration config=getResources().getConfiguration();
            String screen=config.orientation==Configuration.ORIENTATION_LANDSCAPE ? "竖向屏幕" :"横向屏幕";
            edit1.setText(screen);
            String name=config.navigation==Configuration.NAVIGATION_NONAV? "没有方向控制":
                    config.navigation==Configuration.NAVIGATION_WHEEL? "滚轮控制方向":
                            config.navigation==Configuration.NAVIGATION_DPAD? "方向键控制方向":"轨迹球控制方向";
            edit2.setText(name);
            String touchName=config.touchscreen==Configuration.TOUCHSCREEN_NOTOUCH? "无触控屏":
                    config.touchscreen==Configuration.TOUCHSCREEN_STYLUS? "触摸笔式的触摸屏·":"接受手指的触摸屏";
            edit3.setText(touchName);
            String code=config.mnc+"";
            edit4.setText(code);
        }
    }


}
