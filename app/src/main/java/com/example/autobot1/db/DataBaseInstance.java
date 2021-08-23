package com.example.autobot1.db;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class DataBaseInstance extends RoomDatabase {
    private static DataBaseInstance instance;
    public abstract RoomDataBaseDao getRoomDataBaseDao();
    public DataBaseInstance getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context,DataBaseInstance.class,"Autobot_DataBase")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
