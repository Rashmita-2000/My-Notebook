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

public class ListViewAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    List<Model> modelList;
    ArrayList<Model> arrayList;

    public ListViewAdapter(Context context, List<Model> modelList){
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
                if(modelList.get(position).getTitle().equals("History of India"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,History.class);
                    intent.putExtra("actionBarTitle", "History of India");
                    //intent.putExtra("contentTv","this is sociology in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Society"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Society.class);
                    intent.putExtra("actionBarTitle", "Society");
                    //intent.putExtra("contentTv","this is sociology in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Freedom Struggle"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Freedom.class);
                    intent.putExtra("actionBarTitle", "Freedom Struggle");
                    //intent.putExtra("contentTv","this is sociology in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Indian Culture"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Culture.class);
                    intent.putExtra("actionBarTitle", "Indian Culture");
                    //intent.putExtra("contentTv","this is sociology in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Geography"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Geography.class);
                    intent.putExtra("actionBarTitle", "Geography");
                    //intent.putExtra("contentTv","this is sociology in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Polity"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Polity.class);
                    intent.putExtra("actionBarTitle", "Polity");
                    //intent.putExtra("contentTv","this is sociology in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Economy"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Economy.class);
                    intent.putExtra("actionBarTitle", "Economy");
                    //intent.putExtra("contentTv","this is sociology in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("International Relation"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,International.class);
                    intent.putExtra("actionBarTitle", "International Relation");
                    //intent.putExtra("contentTv","this is sociology in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Ethics"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Ethics.class);
                    intent.putExtra("actionBarTitle", "Ethics");
                    //intent.putExtra("contentTv","this is sociology in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Sociology PAPER1"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Sociology.class);
                    intent.putExtra("actionBarTitle", "Sociology PAPER1");
                    //intent.putExtra("contentTv","this is sociology in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("PAPER 2"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Paper.class);
                    intent.putExtra("actionBarTitle", "PAPER 2");
                    //intent.putExtra("contentTv","this is sociology in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Governance"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Governance.class);
                    intent.putExtra("actionBarTitle", "Governance");
                    //intent.putExtra("contentTv","this is sociology in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Environment"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Environment.class);
                    intent.putExtra("actionBarTitle", "Environment");
                    //intent.putExtra("contentTv","this is sociology in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("SCI and Tech"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,science.class);
                    intent.putExtra("actionBarTitle", "SCI and Tech");
                    //intent.putExtra("contentTv","this is sociology in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Optional Notes"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Optional.class);
                    intent.putExtra("actionBarTitle", "Optional Notes");
                    //intent.putExtra("contentTv","this is sociology in detail");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Magazines"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,Magazines.class);
                    intent.putExtra("actionBarTitle", "Magazines");
                    //intent.putExtra("contentTv","this is sociology in detail");
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
