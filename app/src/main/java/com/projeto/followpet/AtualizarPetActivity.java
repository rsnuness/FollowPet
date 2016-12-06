package com.projeto.followpet;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AtualizarPetActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_pet);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_cadastro_pet);
        mToolbar.setTitle(R.string.tb_atualizar_pet);
        mToolbar.setLogo(R.drawable.ic_inter);
        setSupportActionBar(mToolbar);

        //ativando o botao de voltar
        mToolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_white);//definindo a imagem
        mToolbar.setNavigationContentDescription("Retornar");
        //funçao do botao
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(AtualizarPetActivity.this, PetPerfilActivity.class),1);
            }
        });

        final EditText data_nascimento = (android.widget.EditText) findViewById(R.id.etxt_pet_nascimento);
        data_nascimento.addTextChangedListener(Mask.insert("##/##/####", data_nascimento));

        //lincando o banco
        db = openOrCreateDatabase("followpet.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);
        /**/

        //chamando o Intent
        final Intent it = getIntent();
        /**/
        final EditText edId = (EditText) findViewById(R.id.etxt_pet_id);
        final EditText edNome = (EditText) findViewById(R.id.etxt_pet_nome);
        final EditText edNascimento = (EditText) findViewById(R.id.etxt_pet_nascimento);
        final String sexo, especie;
        final EditText edRaca = (EditText) findViewById(R.id.etxt_pet_raca);


        edId.setText(it.getStringExtra("_id"));
        edNome.setText(it.getStringExtra("nome"));
        edNascimento.setText(it.getStringExtra("data_nascimento"));
        edRaca.setText(it.getStringExtra("raca"));
        /**/

    }
    //TODO Menu de incones laterais do main
    /*os codigos ai em baixo sao ultilizado para setar os icon de funçao
    * no lado direito do toolbar*/
    @Override
    public  boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_novo_pet, menu);// inicia os icon no toolbar

        return true;
    }
    //funçao para saber qual incone foi clickado e o deve fazer
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent it = null;

        switch (item.getItemId()) {
            case R.id.ic_content_save:


                ContentValues ctv = new ContentValues();
                ctv.put("nome"), edNome;

                startActivityForResult(new Intent(this, PetPerfilActivity.class), 1);
                finish();

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public
}
