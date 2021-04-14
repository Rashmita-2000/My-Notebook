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

public class CalendarActivity extends AppCompatActivity {
    ListView listView;
    private FirebaseAuth firebaseAuth;
    ListViewAdapter3mag adapter;
    String[]title;
    String[] description;
    int[] icon;
    ArrayList<Model> arrayList=new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Yojana");
        title=new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
        description=new String[]{"","","","","","","","","","","",""};
        icon=new int[]{R.drawable.jan, R.drawable.feb,R.drawable.mar,R.drawable.apr,R.drawable.may,R.drawable.jun,R.drawable.jul,R.drawable.aug,R.drawable.sep,R.drawable.oct,R.drawable.nov,R.drawable.dec};
        listView=findViewById(R.id.listView);

        for(int i=0;i<title.length;i++){
            Model model = new Model(title[i],description[i],icon[i]);
            arrayList.add(model);
        }
        adapter=new ListViewAdapter3mag(this, arrayList);
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
        startActivity(new Intent(CalendarActivity.this, Login.class));
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
