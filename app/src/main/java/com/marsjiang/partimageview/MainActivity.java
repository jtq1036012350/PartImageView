package com.marsjiang.partimageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private PartImageView partImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        partImageView = (PartImageView) findViewById(R.id.partImageView);
        partImageView.setOnPartClickListener(new PartImageView.onPartClickCallBack() {
            @Override
            public void partClick() {
                Toast.makeText(MainActivity.this, "我特么被猥琐男点击了！", Toast.LENGTH_LONG).show();
            }
        });
    }
}
