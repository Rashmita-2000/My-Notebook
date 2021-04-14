package com.example.mynotebook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    PDFView mpdfview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActionBar actionBar=getSupportActionBar();
        Intent intent=getIntent();
        String title=intent.getStringExtra("actionBarTitle");
        String content=intent.getStringExtra("pdf");
        actionBar.setTitle(title);
        mpdfview=(PDFView)findViewById(R.id.pdfView);
        mpdfview.fromAsset(content).load();
    }
    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(MainActivity2.this, Login.class));
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