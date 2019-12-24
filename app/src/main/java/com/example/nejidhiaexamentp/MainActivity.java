package com.example.nejidhiaexamentp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView txtMat;
    private TextView txtNom;
    private TextView txtPrenom;
    private TextView txtService;
    private RecyclerView recyclerView;
    private ArrayList<Personnel> al = new ArrayList<Personnel>();
    private PersonnelAdapter pa;
    public String matricule;
    public String nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMat = (TextView) findViewById(R.id.txtMat);
        txtNom = (TextView) findViewById(R.id.txtNom);
        txtPrenom = (TextView) findViewById(R.id.txtPrenom);
        txtService = (TextView) findViewById(R.id.txtService);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        DataBaseHelper db = new DataBaseHelper(getApplicationContext());
        db.addPersonnel(new Personnel("P01", "Bennour", "Ahmed", "Financier"));
        db.addPersonnel(new Personnel("P02", "Aloui", "Mouna", "Commercia"));
        db.addPersonnel(new Personnel("P03", "Sellami", "Ali", "Marketing"));
        Cursor cr = db.getAll();
        if (cr.moveToNext()) {
            do {
                al.add(new Personnel(
                        cr.getString(1), cr.getString(2), cr.getString(3), cr.getString(4)
                ));
            } while (cr.moveToNext());
        }
        RecyclerView.LayoutManager lm = new LinearLayoutManager((this));
        recyclerView.setLayoutManager(lm);
        DividerItemDecoration dvi = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dvi);
        this.pa = new PersonnelAdapter(al, getApplicationContext());
        recyclerView.setAdapter(pa);

    }
    public void goToActivity()
    {
        Intent i=new Intent(this,Main2Activity.class);
        startActivity(i);
    }
}