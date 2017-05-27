# Android 动画机制

## View 动画框架

​      Animation动画框架定义了透明度、旋转、缩放和位移四种常见的动画，通过AlphaAnimation、RotateAnimation、ScaleAnimation、TranslateAnimation来实现，并提供了AnimationSet动画集合。

- 优点： 效率高、方便
- **缺点**： 元素发生试图动画后，其相应事件的位置没有发生改变，还是在之前的位置.

### 1 透明度动画

```java
AlphaAnimation anim = new AlphaAnimation(0, 1); 		# 0是动画开始的透明度，1为结束时的透明度
anim.setDuration(4000);			# 动画持续时间
anim.setFillAfter(true);		# true表示保持动画结束时的状态，false表示恢复为初始状态						
mView.startAnimation(anim)		# 开始动画， mVIew为动画的目标对象
```

代码效果

![alpha](/picture/alpha.gif)

### 2 旋转动画

```
RotateAnimation anim = new RotateAnimation(0, 120,	# 旋转角度，从0旋转到120度
      Animation.RELATIVE_TO_SELF, 0.5f,	# 设置旋转中心的X坐标，这里为元素中心
      Animation.RELATIVE_TO_SELF, 0.5f);# 设置旋转中心的y坐标，这里为元素中心
anim.setDuration(4000);
anim.setFillAfter(true);
mView.startAnimation(anim);
```

![rotate](/picture/rotate.gif)

### 3 位移动画

```
TranslateAnimation anim = new TranslateAnimation(0, 200, 0, 300);# 设置动画在x轴从0移动到200， y轴上从0移动到200
anim.setDuration(2000);
anim.setFillAfter(true);
mView.startAnimation(anim);
```

![translate](/picture/translate.gif)

### 4 缩放动画

```
ScaleAnimation anim = new ScaleAnimation(0,2, 0, 2,		# x,y轴方向上分别从0放大到2倍
         Animation.RELATIVE_TO_SELF, 0.5f,
         Animation.RELATIVE_TO_SELF, 0.5f); # 缩放中心
anim.setDuration(4000);
anim.setFillAfter(true);
mView.startAnimation(anim);
```

![scale](/picture/scale.gif)

### 5 动画集合

在同一个对象上使用多个动画效果

```
ScaleAnimation anim1 = new ScaleAnimation(0,2, 0, 2,
         Animation.RELATIVE_TO_SELF, 0.5f,
         Animation.RELATIVE_TO_SELF, 0.5f);
anim1.setDuration(4000);

 TranslateAnimation anim3 = new TranslateAnimation(0, 200, 0, 200);
 anim3.setDuration(4000);

 RotateAnimation anim2 = new RotateAnimation(0, 120,
         Animation.RELATIVE_TO_SELF, 0.5f,
         Animation.RELATIVE_TO_SELF, 0.5f);
 anim2.setDuration(4000);

 AlphaAnimation anim4 = new AlphaAnimation(0, 1);
 anim4.setDuration(4000);

 AnimationSet animSet = new AnimationSet(true); # true表示共享差值器

 animSet.addAnimation(anim1);
 animSet.addAnimation(anim2);
 animSet.addAnimation(anim3);
 animSet.addAnimation(anim4);
 
 animSet.setFillAfter(true);
 
 mView.startAnimation(animSet);
```

![set](/picture/set.gif)

### 6 View 动画在XML设置

xml 中 view 动画常用属性

```
-set
    |-android:interpolator -> 插值器，影响动画的速度
        |-默认值 -> @android:anim/accelerate_decelerate_interpolator
    |-android:shareInterpolator -> 集合所有动画是否使用同一插值器
    |-android:fillAfter -> 动画结束后View是否停留在结束的位置
    |-android:startOffset -> 动画多少秒之后执行
    |-android:repeatMode -> 重复的模式,默认为restart,即重头开始重新运行,reverse即从结束开始向前重新运行
-TranslateAnimation -> 移动View
    |-<translate>
        |-android:fillAfter ->
        |-android:duration -> 表示动画持续的时间
        |-android:fromXDelta -> 表示 x 的起始值
        |-android:toXDelta -> 表示 x 的结束值
        |-android:fromYDelta -> 表示 y 的起始值
        |-android:toYDelta -> 表示 y 的结束值
-scaleAnimation -> 放大或者缩小View
    |-<scale>
        |-android:duration -> 表示动画持续的时间
        |-android:fromXScale -> 表示水平方向缩放的起始值
        |-android:fromYScale -> 表示竖直方向缩放的起始值
        |-android:pivotX -> 表示缩放中心点的 X 坐标，纯数字表示相对于自身的坐标，百分数为相对自身的百分比，%p表示相对于父容器
        |-android:pivotY -> 表示缩放中心点的 Y 坐标
        |-android:toXScale -> 表示水平方向缩放的结束值
        |-android:toYScale -> 表示竖直方向缩放的结束值
-RotateAnimation -> 旋转View
    |-<rotate>
        |-android:duration -> 表示动画持续的时间
        |-android:fromDegrees -> 旋转开始的角度
        |-android:toDegrees -> 旋转结束的角度
        |-android:pivotX -> 旋转中心点的 X 坐标
        |-android:pivotY -> 旋转中心点的 Y 坐标
-AlphaAnimation -> 改变View的透明度
    |-<alpha>
        |-android:duration -> 表示动画持续的时间
        |-android:fromAlpha -> 透明度的起始值
        |-android:toAlpha -> 透明度的结束值
-自定义View动画 -> (不会,待实践中学习)
```

view animation的xml文件放在res/anim/文件夹下

```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
     android:interpolator="@android:anim/accelerate_decelerate_interpolator"
     android:shareInterpolator="true"
     android:fillAfter="true"
     android:duration="2000"
    >
    <translate

        android:fromXDelta="0"
        android:toXDelta="100"
        android:fromYDelta="0"
        android:toYDelta="100"
        />
    <scale
        android:fromXScale="0"
        android:toXScale="1"
        android:fromYScale="0"
        android:toYScale="1"
        android:pivotX="50%"
        android:pivotY="50%"
        />
    <rotate
        android:fromDegrees="0"
        android:toDegrees="100"
        android:pivotX="50%"
        android:pivotY="50%"
        />
    <alpha
        android:fromAlpha="0"
        android:toAlpha="1"
        />

</set>
```

![layoutxml](/picture/layoutxml.gif)

### 3 Java中使用

```
View mView = findViewById(R.id.mView);
Animation mAnimation = AnimationUtils.loadAnimation(this,R.anim.slide_bottom_in);
mView.startAnimation(mAnimation);
```



![xml](/picture/xml.gif)

可以为动画添加事件

```
mAlphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //动画开始
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //动画重新运行
            }
        });
```

## Frame 动画

xml中属性

```
animation-list -> 帧动画列表
    |-android:oneshot -> true表示动画只播放一次停止在最后一帧上，false表示动画循环播放
    |-item -> 帧
        |-android:drawable -> 表示每一帧的值
        |-android:duration -> 表示每一帧停留的时间
```

xml文件放在drawable文件夹下

```
<?xml version="1.0" encoding="utf-8"?>
<animation-list xmlns:android="http://schemas.android.com/apk/res/android"
    android:oneshot="true">
    <item android:drawable="@drawable/image1" android:duration="500" />
    <item android:drawable="@drawable/image2" android:duration="500" />
    <item android:drawable="@drawable/image3" android:duration="500" />
</animation-list>
```

Java中调用

```
mView.setBackgroundResource(R.drawable.frame);
AnimationDrawable mAnimationDrawable = (AnimationDrawable) mView.getBackground();
mAnimationDrawable.start();
```

##　Layout 动画

布局动画是指作用在ViewGroup上,给ViewGroup添加元素时添加一个动画过度效果；

### 1 最简单 Layout 动画

最简单的布局动画实在ViewGroup的XML中添加如下代码

```
android：animateLayoutChanges="true"
```

![simple](/picture/simple.gif)

### 2 Layout 动画在XML中设置

- LayoutAnimation 属性

  ```
  LayoutAnimation -> 布局动画
      |-android:animation -> 孩子执行的动画资源
      |-android:animationOrder -> 子元素执行的顺序
          |-normal -> 顺序执行
          |-reverse -> 逆序执行
          |- 
      |-android:delay -> 子元素开始动画的延迟（每一个动画在上一个动画结束后延迟ms后执行）
  ```

view 动画 XML  -- 一个普通view动画的 xml 文件（anim/list_view.xml)_

```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="2000"
    android:shareInterpolator="true">
    <scale
        android:fromXScale="0"
        android:toXScale="1"
        android:fromYScale="0"
        android:toYScale="1"
        android:pivotX="50%"
        android:pivotY="50%"
        />
    <!--<rotate-->
        <!--android:fromDegrees="0"-->
        <!--android:toDegrees="360"-->
        <!--android:pivotX="50%"-->
        <!--android:pivotY="50%"-->
        <!--/>-->
</set>
```

- Layout动画 xml 设置（anim/list_anim.xml)_

```
<?xml version="1.0" encoding="utf-8"?>
<layoutAnimation xmlns:android="http://schemas.android.com/apk/res/android"
    android:animation="@anim/list_view"
    android:animationOrder="normal"
    android:delay="30%"
    >
</layoutAnimation>
```

- 在ViewGroup中设置该Layout动画

  ```
  <ListView
          android:id="@+id/list_view1"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:layoutAnimation="@anim/list_anim"
          >

      </ListView>
  ```

![layoutxml](/picture/layoutxml.gif)

###　3 Java代码创建

```
//通过加载XML动画设置文件来创建一个Animation对象；
Animation animation=AnimationUtils.loadAnimation(this, R.anim.list_anim);
//得到一个LayoutAnimationController对象；
LayoutAnimationController mLayoutAnimationController = new LayoutAnimationController(animation);
//设置控件显示的顺序；
mLayoutAnimationController.setOrder(LayoutAnimationController.ORDER_REVERSE);
//设置控件显示间隔时间；
mLayoutAnimationController.setDelay(1);
//为ListView设置LayoutAnimationController属性；
mList.setLayoutAnimation(mLayoutAnimationController);
```

## Activity 动画

```
overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
```

必须在startActivity或finish之后



![activity](/picture/activity.gif)

## 属性动画

属性动画中常用的两个类是AnimatorSet和ObjectAnimator，只要View有setXXX()方法就可以使用属性动画。

### １　Java 代码

```
ObjectAnimator.ofFloat(mView, "translationY", 100).start();//默认时间内让mView在Y轴上平移100个像素
```

```
//3秒中内改变mView的背景颜色从0xffffffff到0xff000000
ValueAnimator colorAnim = ObjectAnimator.ofInt(mView, "backgroundColor", 0xffffffff, 0xff000000);
colorAnim.setDuration(3000);//动画执行时间
colorAnim.setEvaluator(new ArgbEvaluator());
colorAnim.setRepeatCount(ValueAnimator.INFINITE);//无限循环
colorAnim.setRepeatMode(ValueAnimator.REVERSE);//翻转执行
colorAnim.start();
```

```
AnimatorSet set = new AnimatorSet();
set.playTogether(
        ObjectAnimator.ofFloat(mView, "rotationX", 0, 360),
        ObjectAnimator.ofFloat(mView, "rotationY", 0, 180),
        ObjectAnimator.ofFloat(mView, "rotation", 0, 90),
        ObjectAnimator.ofFloat(mView, "translationX", 0, 90),
        ObjectAnimator.ofFloat(mView, "translationY", 0, 90),
        ObjectAnimator.ofFloat(mView, "scaleX", 1, 1.5f),
        ObjectAnimator.ofFloat(mView, "scaleY", 1, 1.5f),
        ObjectAnimator.ofFloat(mView, "alpha", 1, 1.5f, 1)
);
set.setDuration(5000).start();
```

可以为动画添加事件

```
anim.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
```

可以通过AnimatorListenerAdapter来进行选择必要的事件进行监听

```
ObjectAnimator anim1 = ObjectAnimator.ofArgb(mView, "alpha", 0.5f);
                anim1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                });
```

###  XML

```
objectAnimator
    |-android:propertyName     -> 表示属性动画作用的对象的属性的名称
    |-android:duration         -> 表示动画执行的时间
    |-android:repeatCount    -> 表示动画执行次数
    |-android:repeatMode    -> 表示动画执行类型
    |-android:startOffset    -> 表示动画执行延迟时间
    |-android:valueFrom        -> 表示属性执行初始值
    |-android:valueTo        -> 表示属性执行结束值
    |-android:valueType        -> 表示动画执行数值的类型
```



res/animator/xxx.xml

```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:ordering="sequentially">
    <objectAnimator
        android:duration="3000"
        android:propertyName="rotationX"
        android:repeatCount="infinite"
        android:repeatMode="reverse"
        android:startOffset="0"
        android:valueFrom="0"
        android:valueTo="360"
        android:valueType="intType" />

    <animator
        android:duration="3000"
        android:repeatCount="1"
        android:repeatMode="restart"
        android:startOffset="0"
        android:valueFrom="0"
        android:valueTo="100"
        android:valueType="intType" />

</set>
```

```
AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(), R.animator.property_animator);
set.setTarget(mView);
set.start();
```

```
<set>         =    AnimatorSet
<animator>    =    ValueAnimator
<objectAnimator>=    ObjectAnimator
```

## 插值器和估值器

```
TimeInterpolator
    |-LinearInterpolator                -> 线性插值器，匀速运动
    |-AccelerateDecelerateInterpolator    -> 加速减速插值器，动画两头慢，中间快
    |-DecelerateInterpolator            -> 减速插值器，动画越来越慢
    |-more

TypeEvaluator
    |-IntEvaluator
    |-FloatEvaluator
    |-ArgbEvaluator -> 针对Color属性
```

