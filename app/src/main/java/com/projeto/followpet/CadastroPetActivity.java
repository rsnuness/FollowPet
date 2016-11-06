package com.projeto.followpet;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class CadastroPetActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    public static final int IMAGEM_INTERNA = 12;//usada para pega um imagem
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pet);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_cadastro_pet);
        mToolbar.setTitle(R.string.tb_cadastro_pet);
        //mToolbar.setLogo(R.drawable.ic_inter);
        setSupportActionBar(mToolbar);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

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

    //TODO Pegando Imagem
    /*O comando aseguir pega uma imagem no celular para ser usada dentro do app*/
    public void pegarImg(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGEM_INTERNA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == IMAGEM_INTERNA) {
            if (resultCode == RESULT_OK) {
                Uri imagemSelecionada = intent.getData();

                String[] colunas = {MediaStore.Images.Media.DATA};

                Cursor cursor = getContentResolver().query(imagemSelecionada, colunas, null, null, null);
                cursor.moveToFirst();

                int indexColunas = cursor.getColumnIndex(colunas[0]);
                String pathImg = cursor.getString(indexColunas);
                cursor.close();

                Bitmap bitmap = BitmapFactory.decodeFile(pathImg);
                ImageView imageView = (ImageView) findViewById(R.id.img_perfil);
                imageView.setImageBitmap(bitmap);
            }
        }
    }


}
