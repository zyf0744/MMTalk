package com.zyf;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class AdActivity extends AppCompatActivity {

    final static int COUNTS = 5;//点击次数
    final static long DURATION = 2 * 1000;//规定有效时间
    long[] mHits = new long[COUNTS];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        ImageView iv =(ImageView) findViewById(R.id.ad_imgView);
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    /**
                     * 点击的开始位置
                     */
                    case MotionEvent.ACTION_DOWN:
                        Log.i("",event.getX() +"  -  "+ event.getY());
                        if(event.getX()<150 && event.getY()<150){}
                        else{break;}

                        System.arraycopy(mHits, 1, mHits, 0, mHits.length - 1);
                        //实现左移，然后最后一个位置更新距离开机的时间，如果最后一个时间和最开始时间小于DURATION，即连续5次点击
                        mHits[mHits.length - 1] = SystemClock.uptimeMillis();
                        if (mHits[0] >= (SystemClock.uptimeMillis() - DURATION)) {
                            String tips = "您已在[" + DURATION + "]ms内连续点击【" + mHits.length + "】次了！！！";
                            // Toast.makeText(MainActivity.this, tips, Toast.LENGTH_SHORT).show();
                            // 给bnt1添加点击响应事件
                            Intent intent =new Intent(getApplicationContext(),BaseTalk.class);
                            //启动
                            intent.putExtra("adFlag", "true");
                            startActivity(intent);
                            finish();
                        }
                        break;
                     default:
                         break;
                }
                return false;
            }
        });
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    /**
                     * 实现双击方法
                     * src 拷贝的源数组
                     * srcPos 从源数组的那个位置开始拷贝.
                     * dst 目标数组
                     * dstPos 从目标数组的那个位子开始写数据
                     * length 拷贝的元素的个数
                     */
/*
                    System.arraycopy(mHits, 1, mHits, 0, mHits.length - 1);
                    //实现左移，然后最后一个位置更新距离开机的时间，如果最后一个时间和最开始时间小于DURATION，即连续5次点击
                    mHits[mHits.length - 1] = SystemClock.uptimeMillis();
                    if (mHits[0] >= (SystemClock.uptimeMillis() - DURATION)) {
                        String tips = "您已在[" + DURATION + "]ms内连续点击【" + mHits.length + "】次了！！！";
                       // Toast.makeText(MainActivity.this, tips, Toast.LENGTH_SHORT).show();
                        // 给bnt1添加点击响应事件
                        Intent intent =new Intent(getApplicationContext(),BaseTalk.class);
                        //启动
                        intent.putExtra("adFlag", "true");
                        startActivity(intent);
                        finish();
                    }

*/                }

        });
    }
}
