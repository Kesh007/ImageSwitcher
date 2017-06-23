package com.example.dell.imageswitcher;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private ImageSwitcher simpleImageSwitcher;
    Button button;

    int imageIds[] = {R.drawable.image1,R.drawable.image2,R.drawable.image3};
    int count = imageIds.length;
    int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        simpleImageSwitcher = (ImageSwitcher)findViewById(R.id.simpleImageSwitcher);
        simpleImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ConstraintLayout.LayoutParams.FILL_PARENT,ConstraintLayout.LayoutParams.FILL_PARENT));
                return imageView;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);

        simpleImageSwitcher.setAnimation(in);
        simpleImageSwitcher.setAnimation(out);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if(currentIndex==count)
                {
                    currentIndex=0;
                }
                simpleImageSwitcher.setImageResource(imageIds[currentIndex]);
            }
        });
    }
}
