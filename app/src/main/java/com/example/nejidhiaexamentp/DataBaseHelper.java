package com.example.nejidhiaexamentp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="DbGestionPersonnel";
    private static final int DATABASE_VERSION=2;
    private static final String SQLLITE_TABLE="personnel";
    private static final String KEY_ROWID="id";
    private static final String KEY_MATRICULE="matricule";
    private static final String KEY_NOM="nom";
    private static final String KEY_PRENOM="prenom";
    private static final String KEY_SERVICE="service";
    public DataBaseHelper(Context ctx)
    {
        super(ctx,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sc="CREATE TABLE "+SQLLITE_TABLE+"("+KEY_ROWID+
                " TEXT PRIMARY KEY,"+KEY_MATRICULE+" TEXT ,"+KEY_NOM+" TEXT ,"+KEY_PRENOM+" TEXT,"+KEY_SERVICE+" TEXT"+")";
        db.execSQL(sc);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SQLLITE_TABLE);
        onCreate(db);
    }
    public void addPersonnel(Personnel p)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cn=new ContentValues();
        cn.put(KEY_ROWID,p.getMatricule());
        cn.put(KEY_MATRICULE,p.getMatricule());
        cn.put(KEY_NOM,p.getNom());
        cn.put(KEY_PRENOM,p.getPrenom());
        cn.put(KEY_SERVICE,p.getService());
        db.insert(SQLLITE_TABLE,null,cn);
    }
    public Cursor getAll()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("select * from "+SQLLITE_TABLE,null);
    }
    public void delete()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(SQLLITE_TABLE,null,null);
    }
}
