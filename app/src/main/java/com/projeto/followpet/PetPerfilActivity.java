package com.projeto.followpet;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by User on 08/11/2016.
 */

public class PetPerfilActivity extends AppCompatActivity {

    private SQLiteDatabase db = null;
    private SimpleCursorAdapter adt = null;


    private Toolbar mToolbar;//Variavel necessaria para usar o toolbar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_pet);
        // TODO Toolbar main
        /* o toolbar é o sucessor do actionbar, ele é o a barra que aparece
            no topo da tela
        */
        mToolbar = (Toolbar) findViewById(R.id.toolbar_perfil_pet); //recupera usa variavel para recupera o layout na activity_main
        mToolbar.setTitle(R.string.app_name);//define em codigo java o titulo do toolbar
        //mToolbar.setLogo(R.drawable.ic_inter);

        setSupportActionBar(mToolbar);//iniciar o toolbar
        //funçoes adicionais, deve consulta documentação
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //ativando o botao de voltar
        mToolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_white);//definindo a imagem
        mToolbar.setNavigationContentDescription("Retornar");
        //funçao do botao
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(PetPerfilActivity.this, MainActivity.class),1);
                finish();
            }
        });

        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //fim do toolbar

        //lincando o banco
        db = openOrCreateDatabase("followpet.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        //comando para criar tabela
        String cliente = "REATE TABLE IF NOT EXISTS pet (" +
        "_id integer PRIMARY KEY AUTOINCREMENT," +
                "nome varchar," +
                "data_nascimento varchar," +
                "raca varchar," +
                "especie vachar," +
                "sexo varchar," +
                ");";
        //execultado ocomando sql salvo na string
        db.execSQL(cliente);

    }
    //TODO Menu de incones laterais do main
    /*os codigos ai em baixo sao ultilizado para setar os icon de funçao
    * no lado direito do toolbar*/
    @Override
    public  boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_tb_pet, menu);// inicia os icon no toolbar

        return true;
    }
    //funçao para saber qual incone foi clickado e o deve fazer
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent it = null;

        switch (item.getItemId()) {
            case R.id.action_cadastro_pet:

                startActivityForResult(new Intent(this, CadastroPetActivity.class),1);
                finish();

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }

        @Override
        public void onResume(){
            super.onResume();

            //preencher o list
            Cursor cursor = db.query("pet", new String[]{"_id", "nome", "data_nascimento","sexo", "especie", "raca" }, null, null, null, null, null);

            String[] campos = {"nome","raca"};
            int[] ids = {R.id.model_pet_nome, R.id.model_pet_raca};

            adt = new SimpleCursorAdapter(getBaseContext(), R.layout.model_pet, cursor, campos, ids);
            ListView ltwdados = (ListView)findViewById(R.id.lv_pet);

            ltwdados.setAdapter(adt);

            ltwdados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Cursor retornoCursor = (Cursor) adt.getItem(position);
                    Intent it = new Intent(getBaseContext(), AtualizarPetActivity.class);
                    it.putExtra("_id", retornoCursor.getString(retornoCursor.getColumnIndex("_id")));
                    it.putExtra("nome", retornoCursor.getString(retornoCursor.getColumnIndex("nome")));
                    it.putExtra("data_nascimento", retornoCursor.getString(retornoCursor.getColumnIndex("data_nascimento")));
                    it.putExtra("sexo", retornoCursor.getString(retornoCursor.getColumnIndex("sexo")));
                    it.putExtra("especie", retornoCursor.getString(retornoCursor.getColumnIndex("especie")));
                    it.putExtra("raca", retornoCursor.getString(retornoCursor.getColumnIndex("raca")));
                    startActivity(it);
                }
            });
        /**/

        }

    }
    //fim Menu de incones laterais do main







}
