package com.example.mynotebook;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter7op extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    List<Model> modelList;
    ArrayList<Model> arrayList;

    public ListViewAdapter7op(Context context, List<Model> modelList){
        this.mContext=context;
        this.modelList=modelList;
        inflater=LayoutInflater.from(mContext);
        this.arrayList=new ArrayList<Model>();
        this.arrayList.addAll(modelList);
    }
    public class ViewHolder{
        TextView mTitle, mDesc;
        ImageView micon;
    }
    public int getCount(){
        return modelList.size();
    }
    public Object getItem(int i){
        return modelList.get(i);
    }
    public long getItemId(int i){
        return i;
    }
    public View getView(int position, View view,ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);
            holder.mTitle = view.findViewById(R.id.mainTitle);
            holder.mDesc = view.findViewById(R.id.mainDesc);
            holder.micon = view.findViewById(R.id.mainIcon);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        holder.mTitle.setText(modelList.get(position).getTitle());
        holder.mDesc.setText(modelList.get(position).getDesc());
        holder.micon.setImageResource(modelList.get(position).getIcon());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(modelList.get(position).getTitle().equals("Strength of materials"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Strength of materials");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Geology"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Geology");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Concrete Technology"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Concrete Technology");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Structural analysis"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Structural analysis");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Building planning and Drawing"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Building planning and Drawing");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Question Paper 1"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Question Paper 1");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Question Paper 2"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Question Paper 2");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
            }
        });
        return view;
    }
    public void filter(String charText){
        charText=charText.toLowerCase(Locale.getDefault());
        modelList.clear();
        if(charText.length()==0){
            modelList.addAll(arrayList);
        }
        else{
            for(Model model:arrayList){
                if (model.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    modelList.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
}
