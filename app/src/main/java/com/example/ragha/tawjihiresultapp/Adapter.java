package com.example.ragha.tawjihiresultapp;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolderAdapter>{
    private Context AdapterContext;
    private List<StudentGson> mItemList;
    private onItemClickListener myListener;


    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener (onItemClickListener Listener){
        myListener= Listener;
    }

    public Adapter(Context context, List<StudentGson> ItemList){
        AdapterContext=context;
        mItemList=ItemList;
    }

    @Override
    public ViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(AdapterContext).inflate(R.layout.card_view_item,parent,false);
        return new ViewHolderAdapter(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapter holder, int position) {
        StudentGson currentItem=mItemList.get(position);
        int year=currentItem.getYear();
        String name=currentItem.getName();
        double average=currentItem.getAverage();
        String school=currentItem.getSchool();
        String section=currentItem.getSection();

        holder.yearView.setText(year + "");
        holder.nameView.setText(name);
        holder.averageView.setText( average+"");
        holder.schoolView.setText(school);
        holder.sectionView.setText(section);
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public class ViewHolderAdapter extends RecyclerView.ViewHolder{
        public TextView yearView;
        public TextView nameView;
        public TextView averageView;
        public TextView schoolView;
        public TextView sectionView;
        public ImageView SectionImageView;
        public ViewHolderAdapter(View itemView) {
            super(itemView);
            yearView=itemView.findViewById(R.id.year_view);
            nameView=itemView.findViewById(R.id.name_view);
            averageView=itemView.findViewById(R.id.average_view);
            schoolView=itemView.findViewById(R.id.school_view);
            sectionView=itemView.findViewById(R.id.section_view);
            SectionImageView=itemView.findViewById(R.id.image_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (myListener!=null){
                        int position=getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            myListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
