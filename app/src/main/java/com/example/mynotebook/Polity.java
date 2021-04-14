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

public class Polity extends AppCompatActivity {
    ListView listView;
    private FirebaseAuth firebaseAuth;
    ListViewAdapterPolity adapter;
    String[]title;
    String[] description;
    int[] icon;
    ArrayList<Model> arrayList=new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Polity");
        title=new String[]{"Constitutional Framework","Fundamental Rights","DPSP & FD's","Union Executive","Union Legislative","State Executive","State Legislative & UTs","Local Bodies","Judiciary","Committees","Basic structure & Emergency","Constitutional Bodies","Centre-State Relation","Political Dynamics","Miscellaneous"};
        description=new String[]{"Constitutional Framework","Fundamental Rights","DPSP & FD's","Union Executive","Union Legislative","State Executive","State Legislative & UTs","Local Bodies","Judiciary","Committees","Basic structure & Emergency","Constitutional Bodies","Centre-State Relation","Political Dynamics","Miscellaneous"};
        icon=new int[]{R.drawable.constitution, R.drawable.rights,R.drawable.dpsp,R.drawable.union,R.drawable.union,R.drawable.states,R.drawable.states,R.drawable.local,R.drawable.judiciary,R.drawable.committee,R.drawable.basicstruct,R.drawable.bodies,R.drawable.centerstate,R.drawable.politicaldynamics,R.drawable.miscellaneous};
        listView=findViewById(R.id.listView);

        for(int i=0;i<title.length;i++){
            Model model = new Model(title[i],description[i],icon[i]);
            arrayList.add(model);
        }
        adapter=new ListViewAdapterPolity(this, arrayList);
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
        startActivity(new Intent(Polity.this, Login.class));
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
