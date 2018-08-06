#### Summary
---
情感图库,包含一个图标Icon，一个提示语，一个功能按键。包含四种状态：无网络、无数据、其他异常、自定义

#### Getting Started
---
加入依赖
```Java
allprojects {
  repositories {
	  ...
		maven { url 'https://jitpack.io' }
	}
}

dependencies {
  compile 'com.github.huangshunbo:reloadtipview:lastest.release'
}
```
覆盖reloadtip_default_attr设置全局style
```Java
<style name="reloadtip_default_attr" parent="Theme.AppCompat.Light.NoActionBar">
    <item name="tip_txt_size">18dp</item>
    <item name="action_txt_size">15dp</item>
    <item name="tip_txt_color">#333333</item>
    <item name="action_txt_color">#999999</item>
    <item name="tip_txt_topmargin">20dp</item>
    <item name="action_txt_topmargin">15dp</item>
    <item name="content_minheigh">400dp</item>
    <item name="content_topmargin">-30dp</item>

    <item name="notdata_icon">@mipmap/default_no_data</item>
    <item name="notdata_tip_txt">真的暂无数据</item>
    <item name="notdata_actoin_txt">点击刷新</item>
    <item name="notnet_icon">@mipmap/default_no_network</item>
    <item name="notnet_tip_txt">网络不给力，请稍候重试</item>
    <item name="notnet_actoin_txt">点击刷新</item>
    <item name="error_icon">@mipmap/default_no_network</item>
    <item name="error_tip_txt">服务器异常</item>
    <item name="error_actoin_txt">点击刷新</item>
</style>
```
ReloadTipView暴露的方法
```Java
reloadTipView.getIvIc();
reloadTipView.getTvTip();
reloadTipView.getTvAction();

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

```

#### Known Issues
---
暂时没有收到任何反馈，有任何疑问或需求，可提issue。
#### Support
---
黄顺波