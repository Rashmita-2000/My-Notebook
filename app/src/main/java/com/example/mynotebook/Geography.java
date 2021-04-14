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

public class Geography extends AppCompatActivity {
    ListView listView;
    private FirebaseAuth firebaseAuth;
    ListViewAdapterGeography adapter;
    String[]title;
    String[] description;
    int[] icon;
    ArrayList<Model> arrayList=new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Geography");
        title=new String[]{"Origin of Earth","Basic of Geomorphology","Concept of Geomorphology","Landforms & its evolution","Climatology Part 1","Climatology Part 2","Oceanography","Physiography of India","Drainage of India","Climate of India","Maps of India & world","Human & Eco-geogrphy 1","Human & Eco-geogrphy 2","Transport","Migration"};
        description=new String[]{"Origin of Earth","Basic of Geomorphology","Concept of Geomorphology","Landforms & its evolution","Climatology Part 1","Climatology Part 2","Oceanography","Physiography of India","Drainage of India","Climate of India","Maps of India & world","Human & Eco-geogrphy 1","Human & Eco-geogrphy 2","Transport","Migration"};
        icon=new int[]{R.drawable.earth1, R.drawable.geomoorphology,R.drawable.geomoorphology,R.drawable.landform,R.drawable.climatology,R.drawable.climatology,R.drawable.oceanography,R.drawable.india,R.drawable.drainage,R.drawable.climate,R.drawable.worldmap,R.drawable.humanecogeo,R.drawable.humanecogeo,R.drawable.transport,R.drawable.migration};
        listView=findViewById(R.id.listView);

        for(int i=0;i<title.length;i++){
            Model model = new Model(title[i],description[i],icon[i]);
            arrayList.add(model);
        }
        adapter=new ListViewAdapterGeography(this, arrayList);
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
        startActivity(new Intent(Geography.this, Login.class));
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
