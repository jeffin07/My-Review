package com.nimkraft.myreview;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class AnimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);



        getSupportActionBar().hide();

        String name=getIntent().getExtras().getString("anime_name");
        String description=getIntent().getExtras().getString("anime_description");
        String rating=getIntent().getExtras().getString("anime_rating");

        String catagory=getIntent().getExtras().getString("anime_catagory");
        int episodes=getIntent().getExtras().getInt("anime_episode");
        String img=getIntent().getExtras().getString("anime_img");


        CollapsingToolbarLayout collapsingToolbarLayout=findViewById(R.id.collapsingtoolbar);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name=findViewById(R.id.aa_anime_title);
        TextView tv_catagory=findViewById(R.id.aa_anime_categorie);
        TextView tv_description=findViewById(R.id.nested_text);
        TextView tv_rating=findViewById(R.id.aa_anime_rating);
        ImageView tv_img=findViewById(R.id.aa_thumbnail);



        tv_name.setText(name);
        tv_description.setText(description);
        tv_catagory.setText(catagory);
        tv_rating.setText(rating);
        collapsingToolbarLayout.setTitle(name);
        RequestOptions requestOptions=new RequestOptions().centerCrop().placeholder(R.drawable.loading_pic).error(R.drawable.loading_pic);
        Glide.with(this).load(img).apply(requestOptions).into(tv_img);

    }
}
