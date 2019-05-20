package com.lastbit.battlepass;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.shopgun.android.zoomlayout.ZoomLayout;
import com.shopgun.android.zoomlayout.ZoomOnDoubleTapListener;

import java.util.ArrayList;

public class AdapterChallenges extends RecyclerView.Adapter<AdapterChallenges.ViewHolder>  {

    private ArrayList<ItemChallenges> items = new ArrayList<ItemChallenges>();
    private int width;
    public static int fragment_id;
    private StorageReference mStorageRef;

    public AdapterChallenges(int width) {
        super();
        this.width = width;
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final ItemChallenges item = items.get(position);
        mStorageRef = FirebaseStorage.getInstance("gs://battlepass-b5f06.appspot.com/").getReference().child(item.getSeason_storage()+"/"+item.getSeason_path()+".jpg");

        Glide.with(holder.itemView.getContext()).load(mStorageRef)
                .thumbnail(0.5f)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progressVisibitity(false);

                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressVisibitity(false);

                        return false;
                    }
                })
//                    .override(1200, 1200)
                .into(holder.image);


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_challenges_card, parent, false);

        RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) view.getLayoutParams();
        lp.height = width;
        view.setLayoutParams(lp);

        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return viewHolder;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private ProgressBar progress_bar;
        private ZoomLayout mZoomLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            progress_bar =  itemView.findViewById(R.id.progress_bar);
            mZoomLayout = itemView.findViewById(R.id.zoomLayout);


            mZoomLayout.setMinScale(1f);
            mZoomLayout.setMaxScale(4f);
            mZoomLayout.addOnDoubleTapListener(new ZoomOnDoubleTapListener(false));
        }


        public void progressVisibitity(boolean b){
            if (b == true) {
                progress_bar.setVisibility(View.VISIBLE);
            } else {
                progress_bar.setVisibility(View.GONE);
            }
        }
    }

    public  void addMessage(ItemChallenges item) {
        items.add(item);
        notifyItemChanged(items.size() - 1);
    }
}