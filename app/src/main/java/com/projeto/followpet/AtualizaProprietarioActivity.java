package com.projeto.followpet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by eduardo on 06/12/16.
 */

public class AtualizaProprietarioActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_proprietario);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_atualizar_proprietario);
        mToolbar.setTitle(R.string.tb_atualizar_proprietario);
        setSupportActionBar(mToolbar);

        //ativando o botao de voltar
        mToolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_white);//definindo a imagem
        mToolbar.setNavigationContentDescription("Retornar");
        //funçao do botao
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(AtualizaProprietarioActivity.this, ProprietarioActivity.class),1);
            }
        });

    }
}
