package co.com.newpandatv.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DaoUtil {
    private static DaoUtil daoUtil;
    private final DaoMaster.DevOpenHelper panda;

    public DaoUtil(Context context) {
        panda = new DaoMaster.DevOpenHelper(context, "pandadao");
    }

    public static DaoUtil getIn(Context context) {
        if (daoUtil == null) {
            daoUtil = new DaoUtil(context);
        }
        return daoUtil;
    }

    public SQLiteDatabase getW() {
        SQLiteDatabase writableDatabase = panda.getWritableDatabase();
        // SQLiteDatabase writableDatabase1 = student1.getWritableDatabase();
        return writableDatabase;
    }

    public SQLiteDatabase getR() {
        SQLiteDatabase readableDatabase = panda.getReadableDatabase();
        return readableDatabase;
    }
}