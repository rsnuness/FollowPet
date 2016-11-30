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

    private Toolbar mToolbar;//Variavel necessaria para usar o toolbar

    private SQLiteDatabase db = null;
    private SimpleCursorAdapter adt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO Toolbar main
        /* o toolbar é o sucessor do actionbar, ele é o a barra que aparece
            no topo da tela
        */
        mToolbar = (Toolbar) findViewById(R.id.toolbar_main); //recupera usa variavel para recupera o layout na activity_main
        mToolbar.setTitle(R.string.app_name);//define em codigo java o titulo do toolbar
        //mToolbar.setLogo(R.drawable.ic_inter);

        setSupportActionBar(mToolbar);//iniciar o toolbar
        //funçoes adicionais, deve consulta documentação
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.drawable.ic_inter);// defina o icon de logo para toolbar
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //fim do toolbar

        //COMANDO PARA criar o banco de dados
        db = openOrCreateDatabase("followpet.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        //comando para criar tabela
        String cliente = "CREATE TABLE IF NOT EXISTS  pet (" +
                "_id integer PRIMARY KEY AUTOINCREMENT," +
                "nome varchar," +
                "data_nascimento varchar," +
                "raca varchar," +
                "sexo varchar," +
                "especie varchar," +
                "vacina_id integer," +
                "medicamento_id integer" +
                ");";
        //execultado ocomando sql salvo na string
        db.execSQL(cliente);

    }

    //TODO Menu de incones laterais do main
    /*os codigos ai em baixo sao ultilizado para setar os icon de funçao
    * no lado direito do toolbar*/
    @Override
    public  boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_tb_main, menu);// inicia os icon no toolbar

        return true;
    }
    //funçao para saber qual incone foi clickado e o deve fazer
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent it = null;

        switch (item.getItemId()) {
            /*case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;*/

            case R.id.action_cadastro_pet:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                //return true;

                startActivityForResult(new Intent(this, CadastroPetActivity.class),1
                );

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
    //fim Menu de incones laterais do main

    @Override
    public void onResume(){
        super.onResume();

        //preencher o list
        Cursor cursor = db.query("pet", new String[]{"_id", "nome", "data_nascimento", "raca", "sexo", "especie"}, null, null, null, null, null);

        String[] campos = {"nome", "especie"};
        int[] ids = {R.id.model_nome, R.id.model_especie};

        adt = new SimpleCursorAdapter(getBaseContext(), R.layout.model_pet, cursor, campos, ids);
        ListView lv_mainpet = (ListView)findViewById(R.id.lv_mainpet);

        lv_mainpet.setAdapter(adt);

        lv_mainpet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor retornoCursor = (Cursor) adt.getItem(position);
                Intent it = new Intent(getBaseContext(), PetPerfilActivity.class);
                it.putExtra("_id", retornoCursor.getString(retornoCursor.getColumnIndex("_id")));
                it.putExtra("nome", retornoCursor.getString(retornoCursor.getColumnIndex("nome")));
                it.putExtra("data_nascimento", retornoCursor.getString(retornoCursor.getColumnIndex("data_nascimento")));
                it.putExtra("raca", retornoCursor.getString(retornoCursor.getColumnIndex("raca")));
                it.putExtra("sexo", retornoCursor.getString(retornoCursor.getColumnIndex("sexo")));
                it.putExtra("especie", retornoCursor.getString(retornoCursor.getColumnIndex("especie")));
                startActivity(it);
            }
        });
        /**/

    }
}
