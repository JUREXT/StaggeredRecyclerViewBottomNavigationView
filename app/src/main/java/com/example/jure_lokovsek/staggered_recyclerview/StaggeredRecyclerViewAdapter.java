package com.example.jure_lokovsek.staggered_recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * Created by Jure_Lokovsek on 03. 03. 2019.
 */

public class StaggeredRecyclerViewAdapter extends RecyclerView.Adapter<StaggeredRecyclerViewAdapter.ViewHolder>{

    private ArrayList<Card> cardList;
    private Context context;

    public StaggeredRecyclerViewAdapter(Context context, ArrayList<Card> cardList) {
        this.cardList = cardList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grid_item, parent, false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);

        Glide.with(context).load(cardList.get(holder.getAdapterPosition()).getImage()).apply(requestOptions).into(holder.image);
        holder.content1.setText(cardList.get(holder.getAdapterPosition()).getContent1());
        holder.content2.setText(cardList.get(holder.getAdapterPosition()).getContent2());



        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GalleryActivity.class);
                intent.putExtra(GalleryActivity.IMAGE, cardList.get(position).getImage());
                intent.putExtra(GalleryActivity.CONTENT1, cardList.get(position).getContent1());
                intent.putExtra(GalleryActivity.CONTENT2, cardList.get(position).getContent2());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView content1;
        TextView content2;

        ViewHolder(View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.image);
            this.content1 = itemView.findViewById(R.id.contentMain1);
            this.content2 = itemView.findViewById(R.id.contentMain2);
        }
    }




}
