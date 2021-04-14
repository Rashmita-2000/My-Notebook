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

import com.example.mynotebook.ListViewAdapter2mag;
import com.example.mynotebook.Model;
import com.example.mynotebook.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class NewActivitymag extends AppCompatActivity {
    ListView listView;
    private FirebaseAuth firebaseAuth;
    ListViewAdapter2mag adapter;
    String[]title;
    String[] description;
    int[] icon;
    ArrayList<Model> arrayList=new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
        Intent intent=getIntent();
        String head=intent.getStringExtra("actionBarTitle");
        actionBar.setTitle(head);
        title=new String[]{"2020","2019"};
        description=new String[]{"2020 monthly magazines..","2019 monthly magazines.."};
        icon=new int[]{R.drawable.twenty, R.drawable.nineteen};
        listView=findViewById(R.id.listView);

        for(int i=0;i<title.length;i++){
            Model model = new Model(title[i],description[i],icon[i]);
            arrayList.add(model);
        }
        adapter=new ListViewAdapter2mag(this, arrayList);
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
        startActivity(new Intent(NewActivitymag.this, Login.class));
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
