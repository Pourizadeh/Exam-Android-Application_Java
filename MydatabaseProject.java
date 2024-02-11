package p.zahra.testtbl.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lenovo Z on 08/02/2018.
 */

public class MydatabaseProject extends SQLiteOpenHelper{
    public final static String name ="mydb";
    public final static int version =1;
    public MydatabaseProject(Context context) {
        super(context, name, null, version);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
