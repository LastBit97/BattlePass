package com.lastbit.battlepass;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterHelpMenu extends RecyclerView.Adapter<AdapterHelpMenu.ViewHolder>  {
    private ArrayList<ItemHelp> items = new ArrayList<ItemHelp>();

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final ItemHelp item = items.get(position);
        holder.question.setText(item.getQuestion());
        holder.response.setText("►"+item.getResponse());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_card_help, parent, false);

        RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) view.getLayoutParams();
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
        private TextView question,response;

        public ViewHolder(View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.question);
            response =  itemView.findViewById(R.id.response);
        }
    }

    public  void addAsk(ItemHelp item) {
        items.add(item);
        notifyItemChanged(items.size() - 1);
    }
}

