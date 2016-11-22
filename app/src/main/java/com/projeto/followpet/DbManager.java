package com.projeto.followpet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by eduardo on 20/11/16.
 */

public class DbManager {

    private SQLiteDatabase db;
    private DbFollowpet banco;



    public  DbManager(Context context){
        banco = new DbFollowpet(context);
    }

    public String inserePet(String nome, String data_nascimento)

}
