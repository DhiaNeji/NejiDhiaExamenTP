package com.example.nejidhiaexamentp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class Main2Activity extends AppCompatActivity {
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         i = getIntent();
        if (i != null) {
            if (i.hasExtra("matricule") && i.hasExtra("nom")) {
                EditText txt = (EditText) findViewById(R.id.txtAct2Mat);
                txt.setText(i.getStringExtra("nom").toString());
                Button btn=(Button)findViewById(R.id.btnAjouter);
                final CheckBox ckLic=(CheckBox)findViewById(R.id.txtActckLic);
                final CheckBox ckIng=(CheckBox)findViewById(R.id.txtActckIng);
                final CheckBox ckMas=(CheckBox)findViewById(R.id.txtActckMas);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Retrofit rf=new Retrofit.Builder().baseUrl("http://192.168.43.215/").addConverterFactory(GsonConverterFactory.create()).build();
                        ApiHandler api=rf.create(ApiHandler.class);
                        if(ckIng.isChecked())
                        {
                            Call<Personnel>insert=api.insert(i.getStringExtra("matricule"),i.getStringExtra("nom"),"Ingenieur");
                            insert.enqueue(new Callback<Personnel>() {
                                @Override
                                public void onResponse(Call<Personnel> call, Response<Personnel> response) {
                                    Toast.makeText(Main2Activity.this,"Ajouté",Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onFailure(Call<Personnel> call, Throwable t) {
                                    Toast.makeText(Main2Activity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        if(ckLic.isChecked())
                        {
                            Call<Personnel>insert=api.insert(i.getStringExtra("matricule"),i.getStringExtra("nom"),"Licence");
                            insert.enqueue(new Callback<Personnel>() {
                                @Override
                                public void onResponse(Call<Personnel> call, Response<Personnel> response) {
                                    Toast.makeText(Main2Activity.this,"Ajouté",Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onFailure(Call<Personnel> call, Throwable t) {
                                    Toast.makeText(Main2Activity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        if(ckMas.isChecked())
                        {
                            Call<Personnel>insert=api.insert(i.getStringExtra("matricule"),i.getStringExtra("nom"),"Master");
                            insert.enqueue(new Callback<Personnel>() {
                                @Override
                                public void onResponse(Call<Personnel> call, Response<Personnel> response) {
                                    Toast.makeText(Main2Activity.this,"Ajouté",Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onFailure(Call<Personnel> call, Throwable t) {
                                    Toast.makeText(Main2Activity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
            });
        }
    }
}
}