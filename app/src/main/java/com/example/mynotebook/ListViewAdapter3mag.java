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

import androidx.appcompat.app.ActionBar;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter3mag extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    List<Model> modelList;
    ArrayList<Model> arrayList;

    public ListViewAdapter3mag(Context context, List<Model> modelList){
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
            public void onClick(View view)
            {
                if(modelList.get(position).getTitle().equals("January"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,MainActivity2.class);
                    intent.putExtra("actionBarTitle", "January");
                    intent.putExtra("pdf","yjan.pdf");
                    //intent.putExtra("contentTv","this is sociology in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("February"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,MainActivity2.class);
                    intent.putExtra("actionBarTitle", "February");
                    intent.putExtra("pdf","yjan.pdf");
                    //intent.putExtra("contentTv","this is history in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("March"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,MainActivity2.class);
                    intent.putExtra("actionBarTitle", "March");
                    intent.putExtra("pdf","yjan.pdf");
                    //intent.putExtra("contentTv","this is history in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("April"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,MainActivity2.class);
                    intent.putExtra("actionBarTitle", "April");
                    intent.putExtra("pdf","yjan.pdf");
                    //intent.putExtra("contentTv","this is history in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("May"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,MainActivity2.class);
                    intent.putExtra("actionBarTitle", "May");
                    intent.putExtra("pdf","yjan.pdf");
                    //intent.putExtra("contentTv","this is history in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("June"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,MainActivity2.class);
                    intent.putExtra("actionBarTitle", "June");
                    intent.putExtra("pdf","yjan.pdf");
                    //intent.putExtra("contentTv","this is history in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("July"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,MainActivity2.class);
                    intent.putExtra("actionBarTitle", "July");
                    intent.putExtra("pdf","yjan.pdf");
                    //intent.putExtra("contentTv","this is history in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("August"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,MainActivity2.class);
                    intent.putExtra("actionBarTitle", "August");
                    intent.putExtra("pdf","yjan.pdf");
                    //intent.putExtra("contentTv","this is history in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("September"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,MainActivity2.class);
                    intent.putExtra("actionBarTitle", "September");
                    intent.putExtra("pdf","yjan.pdf");
                    //intent.putExtra("contentTv","this is history in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("October"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,MainActivity2.class);
                    intent.putExtra("actionBarTitle", "October");
                    intent.putExtra("pdf","yjan.pdf");
                    //intent.putExtra("contentTv","this is history in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("November"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,MainActivity2.class);
                    intent.putExtra("actionBarTitle", "November");
                    intent.putExtra("pdf","yjan.pdf");
                    //intent.putExtra("contentTv","this is history in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("December"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,MainActivity2.class);
                    intent.putExtra("actionBarTitle", "December");
                    intent.putExtra("pdf","yjan.pdf");
                    //intent.putExtra("contentTv","this is history in detail");
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

