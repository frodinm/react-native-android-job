package com.frodinm.rnandroidjob;

import android.database.Cursor;
import android.util.Log;

public class SQLHelper {

    public static void createTable(){
        RNAndroidJob.readableDatabase.execSQL("CREATE TABLE IF NOT EXISTS USER_TASKS( taskID INT PRIMARY KEY AUTOINCREMENT, description VARCHAR(50), created_at INTEGER )");
    }

    public void insertTask(String description, int date){
        RNAndroidJob.readableDatabase.execSQL("INSERT INTO USER_TASKS(description,date) VALUES ("+description+","+date+")");
    }
    public void getTask(String desc){
        Cursor result = RNAndroidJob.readableDatabase.rawQuery("SELECT * FROM USER_TASKS WHERE description ="+desc,null);
    }

    public String getAllTasks() {
        Log.d(RNAndroidJob.TAG,"tableToString called");
        String tableString = String.format("Table USER_TASKS:\n");
        Cursor allRows  = RNAndroidJob.readableDatabase.rawQuery("SELECT * FROM  USER_TASKS", null);
        tableString += cursorToString(allRows);

        return tableString;
    }

    private String cursorToString(Cursor cursor){
        String cursorString = "";
        if (cursor.moveToFirst() ){
            String[] columnNames = cursor.getColumnNames();
            for (String name: columnNames)
                cursorString += String.format("%s ][ ", name);
            cursorString += "\n";
            do {
                for (String name: columnNames) {
                    cursorString += String.format("%s ][ ",
                            cursor.getString(cursor.getColumnIndex(name)));
                }
                cursorString += "\n";
            } while (cursor.moveToNext());
        }
        return cursorString;
    }
}
