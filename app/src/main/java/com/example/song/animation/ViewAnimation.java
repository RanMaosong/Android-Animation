package com.example.song.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class ViewAnimation extends AppCompatActivity {
    private Button mView;
    private Button mScale;
    private Button mTranslate;
    private Button mRotate;
    private Button mAlpha;
    private Button mAnimationSet;
    private Button mXML;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation_code);

        initVIew();
        addEvent();
    }

    private void initVIew() {
        mView = (Button) findViewById(R.id.anim_view);
        mScale = (Button) findViewById(R.id.scale);
        mTranslate = (Button) findViewById(R.id.translate);
        mRotate = (Button) findViewById(R.id.rotate);
        mAlpha = (Button) findViewById(R.id.alpha);
        mAnimationSet = (Button) findViewById(R.id.animationset);
        mXML = (Button) findViewById(R.id.xml);
    }

    private void addEvent() {
        mScale.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                ScaleAnimation anim = new ScaleAnimation(0,2, 0, 2,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                anim.setDuration(4000);
                anim.setFillAfter(true);
                mView.startAnimation(anim);

            }
        });
        mTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAnimation anim = new TranslateAnimation(0, 200, 0, 200);
                anim.setDuration(4000);
                anim.setFillAfter(true);
                mView.startAnimation(anim);
            }
        });

        mRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RotateAnimation anim = new RotateAnimation(0, 120,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                anim.setDuration(4000);
                anim.setFillAfter(true);
                mView.startAnimation(anim);
            }
        });

        mAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation anim = new AlphaAnimation(0, 1);
                anim.setDuration(4000);
                anim.setFillAfter(true);
                mView.startAnimation(anim);
            }
        });

        mAnimationSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

                AnimationSet animSet = new AnimationSet(true);

                animSet.addAnimation(anim1);
                animSet.addAnimation(anim2);
                animSet.addAnimation(anim3);
                animSet.addAnimation(anim4);
                animSet.setFillAfter(true);
                animSet.setRepeatCount(Animation.INFINITE);
                animSet.setRepeatMode(Animation.RESTART);
                mView.startAnimation(animSet);
                animSet.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.v("rms", "starting...");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.v("rms", "ending...");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Log.v("rms", "repeatingg...");
                    }
                });
            }
        });
        mXML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation  anim = AnimationUtils.loadAnimation(ViewAnimation.this, R.anim.view_anim);
                mView.startAnimation(anim);



            }
        });
    }
}
