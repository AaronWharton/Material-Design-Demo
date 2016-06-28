# Material-Design-Demo
A demo of Android Material Design Learning

## Introduction
This is an exercise for Android Material-Design widget and Android 5.0 new features.

## Dependence
```java
  compile 'com.android.support:appcompat-v7:24.0.0'
  compile 'com.android.support:design:24.0.0'
  compile 'com.android.support:palette-v7:24.0.0'
```

## Detail

*Activity*  
A guide page and some detail activities(The guide page is also called SplashActivity,it is always used to guide the user's operation or be a welcome page,when it is used as a welcome page,you can know more by cicking [here](https://github.com/bingoogolapple/BGABanner-Android).).

*Widget*  
Add some frequently used widget,but I drop the FAB cause it has some controversy over the user experience,learn more about it [here](http://www.woshipm.com/ucd/166400.html).

### Others
- **Real transparent window**    
`Original window:`  
![](https://github.com/AaronWharton/Material-Design-Demo/blob/master/original_state.png)     
![](https://github.com/AaronWharton/Material-Design-Demo/blob/master/original_drawer.png)

`Previous transparent window:`  
![](https://github.com/AaronWharton/Material-Design-Demo/blob/master/original_state.png)     
![](https://github.com/AaronWharton/Material-Design-Demo/blob/master/half_transparent_drawer.png)

*In fact*:I think they are different just when they open the drawer,so I use the same state window picture for convenience.

`The real transparent window:`  
![](https://github.com/AaronWharton/Material-Design-Demo/blob/master/transparent_state.png)      
![](https://github.com/AaronWharton/Material-Design-Demo/blob/master/transparent_drawer.png)  

`Attention:`Don't forget add ```android:fitsSystemWindows="true"```in your XML and set the background cause the window is transparent.

- **Use palette**  
```java
  FrameLayout imageView2 = (FrameLayout) findViewById(R.id.item2);
  final RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.bottom2);
  Palette.generateAsync(drawableToBitmap(getResources().getDrawable(R.drawable.item2)), new Palette.PaletteAsyncListener() {
      @Override
      public void onGenerated(Palette palette) {
          Palette.Swatch swatch = palette.getVibrantSwatch();
          if (swatch != null) {
              relativeLayout2.setBackgroundColor(swatch.getRgb());
          }
      }
  });
```      
It makes the unified interface style and optimize the user experience(especially in photos Apps).

- **Animation**  
Use Animation in App.  
XML:
```XML
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:shareInterpolator="false">

    <alpha
        android:fromAlpha="0.5"
        android:toAlpha="1.0"
        android:duration="3000" />

    <scale
        android:fromXScale="1.0"
        android:toXScale="1.5"
        android:fromYScale="1.0"
        android:toYScale="1.5"
        android:pivotX="50%"
        android:pivotY="50%"
        android:duration="6000" />

</set>
```
Activity:
```java
  FrameLayout splash = (FrameLayout) findViewById(R.id.splash_background);
  Animation splashBackground = AnimationUtils.loadAnimation(this, R.anim.splash_background);
  splash.setAnimation(splashBackground);
```

- **Shared Element**  
Animation in different activities.  
set ```android:transitionName="xxx"``` in the XMLs,the name must be the same.Then change
```java
startActivity(intent);
```
into
```java
startActivity(intent, ActivityOptions
        .makeSceneTransitionAnimation(MainActivity.this, relativeLayout2, "item").toBundle());
```
Complete!

## FAQ
Practice makes perfect.
