package com.example.autobot1.db;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.autobot1.models.User;

@Dao
public interface RoomDataBaseDao {
    @Insert
    Long insert(User user);
}
