package com.projeto.followpet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class CadastroPetActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pet);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_cadastro_pet);
        mToolbar.setTitle(R.string.tb_cadastro_pet);
        //mToolbar.setLogo(R.drawable.ic_inter);
        setSupportActionBar(mToolbar);
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_tb_novopet, menu);

        return true;
    }

    //@Override
   // public boolean onOptionsItemSelected(MenuItem item) {
       // Intent it = null;

       // switch (item.getItemId()) {
            /*case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;*/

          //  case R.id.action_cadastro_pet:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                //return true;

             //   startActivityForResult(new Intent(this, CadastroPetActivity.class),1
            //    );

          //  default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
            //    return super.onOptionsItemSelected(item);

      //  }
   // }
}
