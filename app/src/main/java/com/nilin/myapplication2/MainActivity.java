package com.nilin.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button imageButton_start = (Button) findViewById(R.id.button);

        imageButton_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                playService.start();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        bindPlayService();//绑定服务
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindPlayService();//解绑服务
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindPlayService();//解绑服务
    }


}
