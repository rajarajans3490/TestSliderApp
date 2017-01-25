package com.slider.sample.sliderapp.Activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
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
import com.slider.sample.sliderapp.databinding.ActivitySliderBinding;

public class SliderActivity extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener {
    private Context mContext = null;
    private CustomFragmentPagerAdapter mCustomFragmentPagerAdapter = null;
    private int mPageCount;
    private ImageView[] mImages = null;
    ActivitySliderBinding binding;

    public SliderActivity (){
        mContext = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_slider);
        mCustomFragmentPagerAdapter = new CustomFragmentPagerAdapter(getSupportFragmentManager(), mContext);
        binding.viewpager.setAdapter(mCustomFragmentPagerAdapter);
        setPageIndicators();
        binding.Button1.setOnClickListener((View.OnClickListener) mContext);
        binding.Button2.setOnClickListener((View.OnClickListener) mContext);
        binding.Button3.setOnClickListener((View.OnClickListener) mContext);
        binding.itemtext1.setOnClickListener((View.OnClickListener) mContext);
        binding.itemtext2.setOnClickListener((View.OnClickListener) mContext);
        binding.itemtext3.setOnClickListener((View.OnClickListener) mContext);
        binding.itemtext4.setOnClickListener((View.OnClickListener) mContext);
        binding.itemtext5.setOnClickListener((View.OnClickListener) mContext);
        binding.viewpager.addOnPageChangeListener((ViewPager.OnPageChangeListener) mContext);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Button1:
                binding.relativeid4.setBackgroundResource(R.color.red);
                break;
            case R.id.Button2:
                binding.relativeid4.setBackgroundResource(R.color.blue);
                break;
            case R.id.Button3:
                binding.relativeid4.setBackgroundResource(R.color.green);
                break;
            case R.id.itemtext1:
                binding.textview4.setText(R.string.itemtext1);
                break;
            case R.id.itemtext2:
                binding.textview4.setText(R.string.itemtext2);
                break;
            case R.id.itemtext3:
                binding.textview4.setText(R.string.itemtext3);
                break;
            case R.id.itemtext4:
                binding.textview4.setText(R.string.itemtext4);
                break;
            case R.id.itemtext5:
                binding.textview4.setText(R.string.itemtext5);
                break;
            default:
                break;
        }
    }

    //To set PageIndicators to the ViewPager Fragments.
    private void setPageIndicators()
    {
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
            binding.pageind.addView(mImages[i], params);
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
