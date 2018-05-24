package com.android.minlib.samplesimplewidget;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import com.android.minlib.reloadtipview.ReloadTipView;

public class ReloadTipViewActivity extends AppCompatActivity{

    ReloadTipView reloadTipView;
    int heigh = 300;
    int tmp = 10;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_reloadtipview);
        reloadTipView = findViewById(R.id.reloadtipview);
        reloadTipView.setActionClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                heigh += 100;
                reloadTipView.setContentMinHeigh(heigh);
            }
        });
        reloadTipView.showNotData();

    }
}
