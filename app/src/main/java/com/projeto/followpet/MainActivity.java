package com.projeto.followpet;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onClickIncProprietario(View v){

        startActivityForResult(new Intent(this, ProprietarioActivity.class),1
        );
    }

    public void onClickIncPet(View v){

        startActivityForResult(new Intent(this, PetPerfilActivity.class),1
        );
    }

    public void onClickVacina(View v){

        startActivityForResult(new Intent(this, VacinaActivity.class),1
        );
    }
    public void onClickMedicamento(View v){

        startActivityForResult(new Intent(this, MedicamentoActivity.class),1
        );
    }


}
