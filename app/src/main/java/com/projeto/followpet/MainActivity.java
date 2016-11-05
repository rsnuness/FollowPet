package com.projeto.followpet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;//Variavel necessaria para usar o toolbar

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
        getSupportActionBar().setLogo(R.drawable.ic_inter);// defina o icon de logo para toolbar
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //fim do toolbar
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
}
