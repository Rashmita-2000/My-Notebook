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

public class ListViewAdapterEconomy extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    List<Model> modelList;
    ArrayList<Model> arrayList;

    public ListViewAdapterEconomy(Context context, List<Model> modelList){
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
                if(modelList.get(position).getTitle().equals("Basics of Economics"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Basics of Economics");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);

                }
                if(modelList.get(position).getTitle().equals("Banking Sector"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Banking Sector");
                    intent.putExtra("pdf","Notes.pdf");

                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Monetary policy"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Monetary policy");
                    intent.putExtra("pdf","Notes.pdf");

                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Inflation"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Inflation");
                    intent.putExtra("pdf","Notes.pdf");

                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Economic reforms"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Economic reforms");
                    intent.putExtra("pdf","Notes.pdf");

                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Agriculture"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Agriculture");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Service sector"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Service sector");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Financial sector"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Financial sector");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("External sector"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "External sector");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Fiscal sector"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Fiscal sector");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Budget"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Budget");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Eco survey"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Eco survey");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Economical development"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Economical development");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Industry"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Industry");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("5 year plan"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "5 year plan");
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
