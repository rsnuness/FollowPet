package com.projeto.followpet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by eduardo on 05/12/16.
 */

public class MedicamentoActivity extends AppCompatActivity {

    private Toolbar mToolbar;//Variavel necessaria para usar o toolbar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamento);

        // TODO ToolbarProprientario
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
                startActivityForResult(new Intent(MedicamentoActivity.this, MainActivity.class),1);
            }
        });

        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //fim do toolbar

    }
}
