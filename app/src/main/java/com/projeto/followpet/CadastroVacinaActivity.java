package com.projeto.followpet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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
    }
}
