package com.android.minlib.samplesimplewidget;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.minlib.reloadtipview.EmotionBean;
import com.android.minlib.reloadtipview.ReloadTipView;

import java.util.Random;

public class ReloadTipViewActivity extends AppCompatActivity{

    ReloadTipView reloadTipView;
    int heigh = 300;
    EmotionBean bean = new EmotionBean();

    TextView tvTip;
    Button btChange;

    private int[] colors = {Color.RED,Color.BLUE,Color.BLACK,Color.GREEN,Color.GRAY};
    private String[] colorsTxt = new String[]{"红色","蓝色","黑色","绿色","灰色"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reloadtipview);
        reloadTipView = findViewById(R.id.reloadtipview);
        tvTip = findViewById(R.id.tip);
        btChange = findViewById(R.id.change);

        reloadTipView.setActionClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ReloadTipViewActivity.this, "唰唰唰", Toast.LENGTH_SHORT).show();
            }
        });
        reloadTipView.showNotNet();

        bean.seteIcon(ContextCompat.getDrawable(this,R.mipmap.default_no_data));
        bean.seteTipTxt("这是一个自定义的提示");
        bean.seteActionTxt("点我唰唰唰");

        btChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int tipTextSize = random.nextInt(20) + 10;
                int tmp = random.nextInt(4);
                int tipTextColor = colors[tmp];
                String tipTextColorTxt = colorsTxt[tmp];
                int tipTextTopMargin = random.nextInt(30);

                int actionTextSize = random.nextInt(20) + 10;
                tmp = random.nextInt(4);
                int actionTextColor = colors[tmp];
                String actionTextColorTxt = colorsTxt[tmp];
                int actionTextTopMargin = random.nextInt(30);

                int contentTopMargin = random.nextInt(400);
                int contentMinHeigh = (random.nextInt(200) + 300);

                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("提示语 文字大小 范围10~30dp : " + tipTextSize + "\n");
                stringBuffer.append("提示语 文字颜色 五色随机 : " + tipTextColorTxt + "\n");
                stringBuffer.append("提示语 顶部距离 范围0~30dp : " + tipTextTopMargin + "\n");

                stringBuffer.append("功能键 文字大小 范围10~30dp : " + actionTextSize + "\n");
                stringBuffer.append("功能键 文字颜色 五色随机 : " + actionTextColorTxt + "\n");
                stringBuffer.append("功能键 顶部距离 范围0~30dp : " + actionTextTopMargin + "\n");

                stringBuffer.append("整体内容 顶部距离 范围0~400dp : " + contentTopMargin + "\n");
                stringBuffer.append("整体内容 最小高度 范围300~500dp : " + contentMinHeigh + "\n");




                reloadTipView.setTipTxt("随机改变参数的Tip");
                reloadTipView.setTipTxtSize(dip2px(tipTextSize));
                reloadTipView.setTipTxtColor(tipTextColor);
                reloadTipView.setTipTopMargin(dip2px(tipTextTopMargin));

                reloadTipView.setActionTxt("随机改变参数的Action");
                reloadTipView.setActionTxtSize(dip2px(actionTextSize));
                reloadTipView.setActionTxtColor(actionTextColor);
                reloadTipView.setActionTopMargin(dip2px(actionTextTopMargin));

                reloadTipView.setContentTopMargin(dip2px(contentTopMargin));
                reloadTipView.setContentMinHeigh(dip2px(contentMinHeigh));

                tvTip.setText(stringBuffer);


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("显示无网络");
        menu.add("显示无数据");
        menu.add("显示服务器异常");
        menu.add("显示自定义");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(reloadTipView != null){
            if(item.getTitle().equals("显示无网络")){
                reloadTipView.showNotNet();
            }else if(item.getTitle().equals("显示无数据")){
                reloadTipView.showNotData();
            }else if(item.getTitle().equals("显示服务器异常")){
                reloadTipView.showError();
            }else if(item.getTitle().equals("显示自定义")){

                reloadTipView.showCustomEmotion(bean);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public int dip2px(float dipValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
