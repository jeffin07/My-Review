package com.nimkraft.myreview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/**
 * Created by Jeffin on 19-03-2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mctx;
    private  List<Anime> mdata;
    RequestOptions options;

    public RecyclerViewAdapter(Context mctx, List<Anime> mdata) {
        this.mctx = mctx;
        this.mdata = mdata;

        options=new RequestOptions().centerCrop().placeholder(R.drawable.loading_pic).error(R.drawable.loading_pic);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater=LayoutInflater.from(mctx);
        view=inflater.inflate(R.layout.anime_row,parent,false);

        final MyViewHolder myViewHolder =new MyViewHolder(view);

        myViewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(mctx,AnimeActivity.class);
                i.putExtra("anime_name",mdata.get(myViewHolder.getAdapterPosition()).getName());
                i.putExtra("anime_description",mdata.get(myViewHolder.getAdapterPosition()).getDescription());
                i.putExtra("anime_rating",mdata.get(myViewHolder.getAdapterPosition()).getRating());
                i.putExtra("anime_catagory",mdata.get(myViewHolder.getAdapterPosition()).getCatagorie());
                i.putExtra("anime_episode",mdata.get(myViewHolder.getAdapterPosition()).getEpisode());
                i.putExtra("anime_img",mdata.get(myViewHolder.getAdapterPosition()).getImg_url());

                mctx.startActivity(i);
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_name.setText(mdata.get(position).getName());
        holder.tv_rating.setText(mdata.get(position).getRating());
        holder.tv_categorie.setText(mdata.get(position).getCatagorie());

        Glide.with(mctx).load(mdata.get(position).getImg_url()).apply(options).into(holder.tv_thumbnail);

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name;
        TextView tv_rating;
        TextView tv_description;
        TextView tv_categorie;
        ImageView tv_thumbnail;
        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);
            view_container=itemView.findViewById(R.id.container);
            tv_name=itemView.findViewById(R.id.anime_title);
            tv_rating=itemView.findViewById(R.id.anime_rating);
            tv_categorie=itemView.findViewById(R.id.anime_categorie);
            tv_thumbnail=itemView.findViewById(R.id.thumbnail);
        }
    }
}
