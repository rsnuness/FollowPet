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
import android.widget.RadioButton;
import android.widget.Toast;

public class CadastroPetActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    SQLiteDatabase db;

    private String sexo;
    private  String especie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pet);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_cadastro_pet);
        mToolbar.setTitle(R.string.tb_cadastro_pet);
        //mToolbar.setLogo(R.drawable.ic_inter);
        setSupportActionBar(mToolbar);

        //ativando o botao de voltar
        mToolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_white);//definindo a imagem
        mToolbar.setNavigationContentDescription("Retornar");
        //funçao do botao
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(CadastroPetActivity.this, MainActivity.class),1);
                finish();
            }
        });

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

        final EditText data_nascimento = (android.widget.EditText) findViewById(R.id.etxt_pet_nascimento);
        data_nascimento.addTextChangedListener(Mask.insert("##/##/####", data_nascimento));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_tb_novo_pet, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    Intent it = null;

    switch (item.getItemId()) {
           /* case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true; */

            case R.id.action_salva:
                //recuperando os campos
                EditText etxtNome = (EditText) findViewById(R.id.etxt_pet_nome);
                EditText etxtNascimento = (EditText) findViewById(R.id.etxt_pet_nascimento);
                EditText etxtraca = (EditText) findViewById(R.id.etxt_pet_raca);

                //comando sql para cadastras no banco
                ContentValues ctv = new ContentValues();
                ctv.put("nome", etxtNome.getText().toString());
                ctv.put("data_nascimento", etxtNascimento.getText().toString());
                ctv.put("raca" ,etxtraca.getText().toString());
                ctv.put("sexo",sexo);
                ctv.put("especie",especie);

                if(db.insert("pet", "_id", ctv) > 0){
                    //mesagem de salvamanto de dados
                    Toast.makeText(getBaseContext(), "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
                    startActivityForResult(new Intent(this, PetPerfilActivity.class),1);
                }
                else
                {
                    Toast.makeText(getBaseContext(), "Erro ao cadastrar!", Toast.LENGTH_LONG).show();
                    startActivityForResult(new Intent(this, PetPerfilActivity.class),1);
                }

            return true;

    //   startActivityForResult(new Intent(this, CadastroPetActivity.class),1
    //    );

            default:
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            return super.onOptionsItemSelected(item);

            }
    }
    //TODO RADIOBUTTON SEXO
    public void onRadioButtonClickedSexo(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbtn_pet_macho:
                if (checked)
                    sexo = "Macho";
                break;
            case R.id.rbtn_pet_femea:
                if (checked)
                    sexo = "Femea";
                break;
        }
    }

    //RadioButton Especie
    public void onRadioButtonClickedEspecie(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbtn_pet_cachorros:
                if (checked)
                    especie = "Cachorro";
                break;
            case R.id.rbtn_pet_gatos:
                if (checked)
                    especie = "Gato";
                break;
            case R.id.rbtn_pet_aves:
                if (checked)
                    especie = "Ave";
                break;
            case R.id.rbtn_pet_repteis:
                if (checked)
                    especie = "Reptil";
                break;
        }
    }




}