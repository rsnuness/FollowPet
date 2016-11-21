package com.projeto.followpet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

public class CadastroVacinaActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pet);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_cadastro_pet);
        mToolbar.setTitle(R.string.tb_cadastro_vacina);
        mToolbar.setLogo(R.drawable.ic_inter);
        setSupportActionBar(mToolbar);

        //ativando o botao de voltar
        mToolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_white);//definindo a imagem
        mToolbar.setNavigationContentDescription("Retornar");
        //funçao do botao
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(CadastroVacinaActivity.this, PetPerfilActivity.class),1);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_tb_novo_vacina, menu);

        return true;
    }
}
