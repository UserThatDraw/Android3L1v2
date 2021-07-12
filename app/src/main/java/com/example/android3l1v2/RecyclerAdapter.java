package com.example.android3l1v2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3l1v2.databinding.BookItemBinding;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private List<BookModel> list;
    private LayoutInflater inflater;
    private Context context;
    private BookItemBinding itemBinding;

    public RecyclerAdapter (List<BookModel>list, Context context) {
        this.list = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.book_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        //holder.txtTitle.setText(list.get(position).getTitle());
        itemBinding.itemTitleTxt.setText(list.get(position).getTitle());
        //holder.iconImage.setImageResource(list.get(position).getIcon());
        itemBinding.itemIcon.setImageResource(list.get(position).getIcon());
        itemBinding.itemIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickI(position);
            }
        });
        itemBinding.itemTitleTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickI(position);
            }
        });
    }
    public void clickI(int position){
        Intent intent = new Intent(context, AboutFragment.class);
        intent.putExtra("book", list.get(position).getTitle());
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
