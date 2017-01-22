package com.slider.sample.sliderapp.Activity;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.slider.sample.sliderapp.Adapter.CustomFragmentPagerAdapter;
import com.slider.sample.sliderapp.R;

public class SliderActivity extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener {
    private RelativeLayout mRelativelayout =null;
    private TextView mTextview4 = null;
    private Context mContext = null;
    private CustomFragmentPagerAdapter mCustomFragmentPagerAdapter = null;
    private int mPageCount;
    private ImageView[] mImages = null;

    public SliderActivity (){
        mContext = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        mRelativelayout = (RelativeLayout) findViewById(R.id.relativeid4);
        Button mButton1 = (Button) findViewById(R.id.Button1);
        Button mButton2 = (Button) findViewById(R.id.Button2);
        Button mButton3 = (Button) findViewById(R.id.Button3);
        TextView mtextview1 = (TextView) findViewById(R.id.itemtext1);
        TextView mtextview2 = (TextView) findViewById(R.id.itemtext2);
        TextView mtextview3 = (TextView) findViewById(R.id.itemtext3);
        TextView mtextview4 = (TextView) findViewById(R.id.itemtext4);
        TextView mtextview5 = (TextView) findViewById(R.id.itemtext5);

        mTextview4 = (TextView) findViewById(R.id.textview4);
        mCustomFragmentPagerAdapter = new CustomFragmentPagerAdapter(getSupportFragmentManager(), mContext);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mCustomFragmentPagerAdapter);
        setPageIndicators();
        mButton1.setOnClickListener((View.OnClickListener) mContext);
        mButton2.setOnClickListener((View.OnClickListener) mContext);
        mButton3.setOnClickListener((View.OnClickListener) mContext);
        mtextview1.setOnClickListener((View.OnClickListener) mContext);
        mtextview2.setOnClickListener((View.OnClickListener) mContext);
        mtextview3.setOnClickListener((View.OnClickListener) mContext);
        mtextview4.setOnClickListener((View.OnClickListener) mContext);
        mtextview5.setOnClickListener((View.OnClickListener) mContext);
        mViewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener) mContext);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Button1:
                mRelativelayout.setBackgroundResource(R.color.red);
                break;
            case R.id.Button2:
                mRelativelayout.setBackgroundResource(R.color.blue);
                break;
            case R.id.Button3:
                mRelativelayout.setBackgroundResource(R.color.green);
                break;
            case R.id.itemtext1:
                mTextview4.setText(R.string.itemtext1);
                break;
            case R.id.itemtext2:
                mTextview4.setText(R.string.itemtext2);
                break;
            case R.id.itemtext3:
                mTextview4.setText(R.string.itemtext3);
                break;
            case R.id.itemtext4:
                mTextview4.setText(R.string.itemtext4);
                break;
            case R.id.itemtext5:
                mTextview4.setText(R.string.itemtext5);
                break;
            default:
                break;
        }
    }

    //To set PageIndicators to the ViewPager Fragments.
    private void setPageIndicators()
    {
        LinearLayout mLinearLayout = (LinearLayout)findViewById(R.id.pageind);
        mPageCount = mCustomFragmentPagerAdapter.getCount();
        mImages = new ImageView[mPageCount];
        int mImagePadding = (int) (getResources().getDimension(R.dimen.image_padding)/getResources().getDisplayMetrics().density);
        int mMargin = (int) (getResources().getDimension(R.dimen.Linearlayout_margin)/getResources().getDisplayMetrics().density);
        int mNoMargin = (int) (getResources().getDimension(R.dimen.Linearlayout_nomargin)/getResources().getDisplayMetrics().density);
        for (int i = 0; i < mPageCount; i++) {
            mImages[i] = new ImageView(this);
            mImages[i].setPadding(mImagePadding, mImagePadding, mImagePadding, mImagePadding);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mImages[i].setImageDrawable(getResources().getDrawable(R.drawable.unselect, getApplicationContext().getTheme()));
            } else {
                mImages[i].setImageDrawable(getResources().getDrawable(R.drawable.unselect));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            );
            params.setMargins(mMargin, mNoMargin, mMargin, mNoMargin);
            params.gravity = (Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
            mLinearLayout.addView(mImages[i], params);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mImages[0].setImageDrawable(getResources().getDrawable(R.drawable.select,getApplicationContext().getTheme()));

        } else {
            mImages[0].setImageDrawable(getResources().getDrawable(R.drawable.select));
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        for (int i = 0; i < mPageCount; i++) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mImages[i].setImageDrawable(getResources().getDrawable(R.drawable.unselect, getApplicationContext().getTheme()));
            } else {
                mImages[i].setImageDrawable(getResources().getDrawable(R.drawable.unselect));
            }

        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mImages[position].setImageDrawable(getResources().getDrawable(R.drawable.select,getApplicationContext().getTheme()));

        } else {
            mImages[position].setImageDrawable(getResources().getDrawable(R.drawable.select));
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

}
