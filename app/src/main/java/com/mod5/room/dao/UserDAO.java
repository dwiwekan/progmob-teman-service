package com.mod5.room.dao;

import com.mod5.room.entity.User;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

//DATA ACCESS OBJECT, TINGGAL PANGGIL UNTUK AKSESNYA
@Dao
public interface UserDAO {
    //buat login
    @Query("SELECT * FROM User WHERE telp = :telp AND password = :password")
    List<User> login(String telp, String password);

    //buat get user by id
    @Query("SELECT * FROM User WHERE id = :id")
    User getUserbyid(int id);

    //buat register user
    @Insert
    void RegisterUser(User... users);
}
