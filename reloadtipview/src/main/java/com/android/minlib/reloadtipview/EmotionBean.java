package com.android.minlib.reloadtipview;

import android.graphics.drawable.Drawable;

public class EmotionBean {
    private Drawable eIcon;
    private String  eTipTxt;
    private String eActionTxt;

    public Drawable geteIcon() {
        return eIcon;
    }

    public void seteIcon(Drawable eIcon) {
        this.eIcon = eIcon;
    }

    public String geteTipTxt() {
        return eTipTxt;
    }

    public void seteTipTxt(String eTipTxt) {
        this.eTipTxt = eTipTxt;
    }

    public String geteActionTxt() {
        return eActionTxt;
    }

    public void seteActionTxt(String eActionTxt) {
        this.eActionTxt = eActionTxt;
    }
}
