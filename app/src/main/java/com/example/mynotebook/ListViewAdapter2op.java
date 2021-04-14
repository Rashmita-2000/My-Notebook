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

public class ListViewAdapter2op extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    List<Model> modelList;
    ArrayList<Model> arrayList;

    public ListViewAdapter2op(Context context, List<Model> modelList){
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
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "History of India");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Society"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Society");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Freedom struggle"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Freedom struggle");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Indian Culture"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Indian Culture");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("International Relationship"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "International Relationship");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Ethics"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Ethics");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Pre-historic"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Pre-historic");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Pre-historic"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Pre-historic");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Religious movement"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Religious movement");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }if(modelList.get(position).getTitle().equals("Gupta Period"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Gupta Period");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Early medieval period"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Early medieval period");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Art & culture"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Art & culture");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Mughal empire"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Mughal empire");
                    intent.putExtra("pdf","Notes.pdf");
                    mContext.startActivity(intent);
                }
                if(modelList.get(position).getTitle().equals("Post Mughal"))
                {
                    //Start new activity
                    Intent intent=new Intent(mContext,NewActivity.class);
                    intent.putExtra("actionBarTitle", "Post Mughal");
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
