package com.sumayea.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.graphics.ColorSpace;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List <Model> models;
    Integer []colors= null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        models=new ArrayList <>();
        models.add(new Model(R.drawable.deco, "Image1"));
        models.add(new Model(R.drawable.decoo, "Image2"));
        models.add(new Model(R.drawable.wedding, "Image3"));


        adapter= new Adapter(models, this);

        viewPager=findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1)
        };

        colors=colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position<(adapter.getCount()-1)&& position< (colors.length-1)){
                    viewPager.setBackgroundColor(
                            (Integer)argbEvaluator.evaluate(positionOffset,colors[position], colors[position + 1]));
                }

                else {
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
