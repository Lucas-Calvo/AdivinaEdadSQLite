package es.android.adivinaedad;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BD extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "EdadEstimada.db";
    public BD(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Edades ("+
                "_ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "NOMBRE TEXT NOT NULL,"+
                "EDAD INTEGER NOT NULL);");
        EdadEstimada e1 = new EdadEstimada(23,"Maria",1);
        EdadEstimada e2 = new EdadEstimada(35,"Pedro", 2);
        EdadEstimada e3 = new EdadEstimada(49,"Luisa", 3);
        EdadEstimada e4 = new EdadEstimada(72,"Jacobo", 4);
        EdadEstimada e5 = new EdadEstimada(19,"Lily", 5);
        insercion(sqLiteDatabase,e1);
        insercion(sqLiteDatabase,e2);
        insercion(sqLiteDatabase,e3);
        insercion(sqLiteDatabase,e4);
        insercion(sqLiteDatabase,e5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insercion(SQLiteDatabase bd, EdadEstimada e){

        if(bd==null){
            bd = getWritableDatabase();
        }
        ContentValues values = new ContentValues();

        values.put("_ID", e.getCount());
        values.put("NOMBRE", e.getName());
        values.put("EDAD", e.getAge());

        bd.insert("Edades", null, values);
    }
    @SuppressLint("Range")
    public int getEdad(String e){

        int edad=0;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(
                "Edades",
                null,
                "NOMBRE=?",
                new String[]{e},
                null,
                null,
                null
        );
        while(c.getCount()>0 && c.moveToNext()){
            edad=c.getInt(c.getColumnIndex("EDAD"));
        }
        return edad;

    }
}
