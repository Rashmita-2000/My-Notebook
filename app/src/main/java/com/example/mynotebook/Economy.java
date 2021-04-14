package com.example.mynotebook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SearchEvent;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Economy extends AppCompatActivity {
    ListView listView;
    private FirebaseAuth firebaseAuth;
    ListViewAdapterEconomy adapter;
    String[]title;
    String[] description;
    int[] icon;
    ArrayList<Model> arrayList=new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Economy");
        title=new String[]{"Basics of Economics","Banking Sector","Monetary policy","Inflation","Economic reforms","Agriculture","Service sector","Financial sector","External sector","Fiscal sector","Budget","Eco survey","Economical development","Industry","5 year plan"};
        description=new String[]{"Basics of Economics","Banking Sector","Monetary policy","Inflation","Economic reforms","Agriculture","Service sector","Financial sector","External sector","Fiscal sector","Budget","Eco survey","Economical development","Industry","5 year plan"};
        icon=new int[]{R.drawable.basicsofeconomy, R.drawable.bank,R.drawable.monetary,R.drawable.inflation,R.drawable.ecnomicreform,R.drawable.agriculture,R.drawable.service,R.drawable.financial,R.drawable.external,R.drawable.fiscal,R.drawable.budget,R.drawable.ecosurvey,R.drawable.ecodev,R.drawable.industry,R.drawable.fiveyear};
        listView=findViewById(R.id.listView);

        for(int i=0;i<title.length;i++){
            Model model = new Model(title[i],description[i],icon[i]);
            arrayList.add(model);
        }
        adapter=new ListViewAdapterEconomy(this, arrayList);
        listView.setAdapter(adapter);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem myActionMenuItem=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView)myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }
                else{
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }
    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(Economy.this, Login.class));
    }
    public boolean onOptionsItemsSelected(MenuItem item){
        switch(item.getItemId()) {
            case R.id.logoutMenu: {
                Logout();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
