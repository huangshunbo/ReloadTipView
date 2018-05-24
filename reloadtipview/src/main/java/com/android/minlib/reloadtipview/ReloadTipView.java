package com.android.minlib.reloadtipview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ReloadTipView extends FrameLayout {

    private Context mContext;
    private ImageView ivIc;
    private TextView tvTip,tvAction;
    private LinearLayout llContent;

    private Drawable icRes;
    private String tipTxt,actionTxt;
    private float tipTxtSize,actionTxtSize;
    private int tipTxtColor,actionTxtColor;
    private float tipTopMargin,actionTopMargin;
    private float contentMinHeigh,contentTopMargin;

    EmotionBean ebNotData = new EmotionBean();
    EmotionBean ebNotNet = new EmotionBean();
    EmotionBean ebError = new EmotionBean();
    EmotionBean ebCustom = new EmotionBean();

    public ReloadTipView(@NonNull Context context) {
        this(context,null);
    }

    public ReloadTipView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,R.style.reloadtip_default_attr);
    }

    public ReloadTipView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
        initAttrs(attrs,defStyleAttr);
        initView();
    }

    private void init(){
        inflate(mContext,R.layout.reloadtipview,this);
        ivIc = findViewById(R.id.reloadtipview_ic);
        tvTip = findViewById(R.id.reloadtipview_tip);
        tvAction = findViewById(R.id.reloadtipview_action);
        llContent = findViewById(R.id.reloadtipview_content);

        setVisibility(GONE);
    }

    private void initAttrs(AttributeSet attrs,int defStyleAttr){
        TypedArray ta = mContext.obtainStyledAttributes(attrs, R.styleable.ReloadTipView,defStyleAttr, R.style.reloadtip_default_attr);
        if(ta != null) {
            tipTxtSize = ta.getDimension(R.styleable.ReloadTipView_tip_txt_size, -1);
            actionTxtSize = ta.getDimension(R.styleable.ReloadTipView_action_txt_size, -1);
            tipTxtColor = ta.getColor(R.styleable.ReloadTipView_tip_txt_color, -1);
            actionTxtColor = ta.getColor(R.styleable.ReloadTipView_action_txt_color, -1);
            tipTopMargin = ta.getDimension(R.styleable.ReloadTipView_tip_txt_topmargin, -1);
            actionTopMargin = ta.getDimension(R.styleable.ReloadTipView_action_txt_topmargin, -1);
            contentMinHeigh = ta.getDimension(R.styleable.ReloadTipView_content_minheigh, -1);
            contentTopMargin = ta.getDimension(R.styleable.ReloadTipView_content_topmargin, -1);

            //三种状态的初始化
            ebNotData.seteIcon(ta.getDrawable(R.styleable.ReloadTipView_notdata_icon));
            ebNotData.seteTipTxt(ta.getString(R.styleable.ReloadTipView_notdata_tip_txt));
            ebNotData.seteActionTxt(ta.getString(R.styleable.ReloadTipView_notdata_actoin_txt));

            ebNotNet.seteIcon(ta.getDrawable(R.styleable.ReloadTipView_notnet_icon));
            ebNotNet.seteTipTxt(ta.getString(R.styleable.ReloadTipView_notnet_tip_txt));
            ebNotNet.seteActionTxt(ta.getString(R.styleable.ReloadTipView_notnet_actoin_txt));

            ebError.seteIcon(ta.getDrawable(R.styleable.ReloadTipView_error_icon));
            ebError.seteTipTxt(ta.getString(R.styleable.ReloadTipView_error_tip_txt));
            ebError.seteActionTxt(ta.getString(R.styleable.ReloadTipView_error_actoin_txt));
        }
    }

    private void initView(){

        if(icRes != null){
            ivIc.setImageDrawable(icRes);
        }

        if(!TextUtils.isEmpty(tipTxt)){
            tvTip.setVisibility(VISIBLE);
            tvTip.setText(tipTxt);
        }
        if(!TextUtils.isEmpty(actionTxt)){
            tvAction.setVisibility(VISIBLE);
            tvAction.setText(actionTxt);
        }

        if(tipTxtSize > -1){
            tvTip.setTextSize(TypedValue.COMPLEX_UNIT_PX,tipTxtSize);
        }
        if(actionTxtSize > -1){
            tvAction.setTextSize(TypedValue.COMPLEX_UNIT_PX,actionTxtSize);
        }

        if(tipTxtColor > 0){
            tvTip.setTextColor(tipTxtColor);
        }
        if(actionTxtColor > 0){
            tvAction.setTextColor(actionTxtColor);
        }

        if(tipTopMargin > -1){
            tvTip.setPadding(0, (int) tipTopMargin,0,0);
        }
        if(actionTopMargin > -1){
            tvAction.setPadding(0, (int) actionTopMargin,0,0);
        }

        if(contentMinHeigh > -1){
            llContent.setMinimumHeight((int) contentMinHeigh);
        }
        if(contentTopMargin != -1){
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) llContent.getLayoutParams();
            lp.topMargin = (int) contentTopMargin;
            llContent.setLayoutParams(lp);
        }

    }

    public void setIcRes(Drawable icRes) {
        this.icRes = icRes;
        initView();
    }

    public void setTipTxt(String tipTxt) {
        this.tipTxt = tipTxt;
        initView();
    }

    public void setActionTxt(String actionTxt) {
        this.actionTxt = actionTxt;
        initView();
    }

    public void setTipTxtSize(float tipTxtSize) {
        this.tipTxtSize = tipTxtSize;
        initView();
    }

    public void setActionTxtSize(float actionTxtSize) {
        this.actionTxtSize = actionTxtSize;
        initView();
    }

    public void setTipTxtColor(int tipTxtColor) {
        this.tipTxtColor = tipTxtColor;
        initView();
    }

    public void setActionTxtColor(int actionTxtColor) {
        this.actionTxtColor = actionTxtColor;
    }

    public void setTipTopMargin(float tipTopMargin) {
        this.tipTopMargin = tipTopMargin;
        initView();
    }

    public void setActionTopMargin(float actionTopMargin) {
        this.actionTopMargin = actionTopMargin;
        initView();
    }

    public void setContentMinHeigh(float contentMinHeigh) {
        this.contentMinHeigh = contentMinHeigh;
        initView();
    }

    public void setContentTopMargin(float contentTopMargin) {
        this.contentTopMargin = contentTopMargin;
        initView();
    }

    public ImageView getIvIc() {
        return ivIc;
    }

    public TextView getTvTip() {
        return tvTip;
    }

    public TextView getTvAction() {
        return tvAction;
    }

    public void setActionClickListener(OnClickListener onClickListener){
        tvAction.setOnClickListener(onClickListener);
    }

    public void showNotData(){
        setIcRes(ebNotData.geteIcon());
        setTipTxt(ebNotData.geteTipTxt());
        setActionTxt(ebNotData.geteActionTxt());
        setVisibility(VISIBLE);
    }

    public void showNotNet(){
        setIcRes(ebNotNet.geteIcon());
        setTipTxt(ebNotNet.geteTipTxt());
        setActionTxt(ebNotNet.geteActionTxt());
        setVisibility(VISIBLE);
    }

    public  void showError(){
        setIcRes(ebError.geteIcon());
        setTipTxt(ebError.geteTipTxt());
        setActionTxt(ebError.geteActionTxt());
        setVisibility(VISIBLE);
    }

    public void showCustomEmotion(){
        setIcRes(ebCustom.geteIcon());
        setTipTxt(ebCustom.geteTipTxt());
        setActionTxt(ebCustom.geteActionTxt());
        setVisibility(VISIBLE);
    }

    public void showCustomEmotion(EmotionBean emotoin){
        setIcRes(emotoin.geteIcon());
        setTipTxt(emotoin.geteTipTxt());
        setActionTxt(emotoin.geteActionTxt());
        setVisibility(VISIBLE);
    }

    public void close(){
        setVisibility(GONE);
    }
}
