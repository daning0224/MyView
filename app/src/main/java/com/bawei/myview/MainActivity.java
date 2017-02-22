package com.bawei.myview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyView myView = (MyView) findViewById(R.id.myView);
        myView.setOnClicListener(new MyView.OnClicListener() {
            @Override
            public void OnClicListener() {
                Toast.makeText(MainActivity.this, "被点击", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
