package com.bitcamp.app.kakao1.activity.com.bitcamp.app.kakao.mapper;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 1027 on 2018-02-06.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
  static final String DATABASE_NAME = "kakao.db";
  static final String TABLE_NAME = "member";
  static final String column_1 = "userid";
  static final String column_2 = "password";
  static final String column_3 = "name";
  static final String column_4 = "email";
  static final String column_5 = "phone_number";
  static final String column_6 = "profile_photo";
  static final String column_7 = "address";
  static abstract class QueryFactory{
      Context context;
      public QueryFactory (Context context){
          this.context = context;
      }
      public abstract SQLiteDatabase getDatabase();
  }
 // static class SQLiteHelper extends SQLiteOpenHelper{  }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(
               String.format("")
       );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " +  TABLE_NAME) ;
        onCreate(db);
    }
}
