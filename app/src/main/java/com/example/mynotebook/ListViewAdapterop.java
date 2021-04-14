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

public class ListViewAdapterop extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    List<Model> modelList;
    ArrayList<Model> arrayList;

    public ListViewAdapterop(Context context, List<Model> modelList){
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
                if(modelList.get(position).getTitle().equals("Sociology"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Sociologyop.class);
                    intent.putExtra("actionBarTitle", "Sociology");
                    //intent.putExtra("contentTv","this is sociology in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("History"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Historyop.class);
                    intent.putExtra("actionBarTitle", "History");
                    //intent.putExtra("contentTv","this is history in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Geography"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Geographyop.class);
                    intent.putExtra("actionBarTitle", "Geography");
                    //intent.putExtra("contentTv","this is Geography in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Political Science"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Polityop.class);
                    intent.putExtra("actionBarTitle", "Political Science");
                    //intent.putExtra("contentTv","this is Political Science in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Mechanical Engineering"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Mechanicalop.class);
                    intent.putExtra("actionBarTitle", "Mechanical Engineering");
                    //intent.putExtra("contentTv","this is Mechanical Engineering in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Civil Engineering"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Civilop.class);
                    intent.putExtra("actionBarTitle", "Civil Engineering");
                    //intent.putExtra("contentTv","this is Civil Engineering in detail");
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
