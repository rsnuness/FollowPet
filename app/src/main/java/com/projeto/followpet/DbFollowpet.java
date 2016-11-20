package com.projeto.followpet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by eduardo on 20/11/16.
 */

/*
 *   Esse classe é usada para cria o banco e suas tabelas
 */
public class DbFollowpet extends SQLiteOpenHelper {

    // Costantes
    private static  String DB_NAME = "FollowPet";
    private static  int DV_VIRSION = 1;

    // Tabelas
    private  static  String TABLE_USER = "CREATE TABLE IF NOT EXISTS user (" +
            "_id integer PRIMARY KEY AUTOINCREMENT," +
            "nome varchar," +
            "endereco varchar," +
            "telefone_r varchar," +
            "telefone_c varchar," +
            "email varchar," +
            "senha varchar," +
            "nivel integer," +
            "data_criacao varchar," +
            "data_inscrucao varchar," +
            "pet_id integer" +
            ");";

    private static  String TABLE_PET = "CREATE TABLE IF NOT EXISTS pet (" +
            "_id integer PRIMARY KEY AUTOINCREMENT," +
            "nome varchar," +
            "data_nascimento varchar," +
            "raca varchar," +
            "sexo varchar," +
            "tamanho varchar," +
            "peso varchar," +
            "vacina_id integer," +
            "medicamento_id integer" +
            ");";

    private static String TABLE_BANHO = "CREATE TABLE IF NOT EXISTS banho (" +
            "_id integer PRIMARY KEY AUTOINCREMENT," +
            "data_banho varchar," +
            "tipo_banho varchar," +
            "tipo_tosa varchar," +
            "user_id integer," +
            "pet_id integer" +
            ");";

    private static String TABLE_VACINA = "CREATE TABLE IF NOT EXISTS vacina (" +
            "_id integer PRIMARY KEY AUTOINCREMENT," +
            "nome varchar," +
            "descricao text," +
            "data_primeira varchar," +
            "data_proxima varchar" +
            ");";

    private static String TABLE_MEDICAMENTO = "CREATE TABLE IF NOT EXISTS medicamento (" +
            "_id integer PRIMARY KEY AUTOINCREMENT," +
            "nome varchar," +
            "descricao text," +
            "data_primeira varchar," +
            "data_proxima varchar" +
            ");";

    public DbFollowpet(Context context) {
        super(context, DB_NAME, null, DV_VIRSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //execultando comando para criar as tabelas
        db.execSQL(TABLE_USER);

        db.execSQL(TABLE_PET);

        db.execSQL(TABLE_VACINA);

        db.execSQL(TABLE_MEDICAMENTO);

        db.execSQL(TABLE_BANHO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versaoAntiga, int versaoAtual) {

    }
}
