package com.mod5.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//model user sbagai entity
@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id = 0;
    @ColumnInfo(name = "nama")
    public String nama;
    @ColumnInfo(name = "password")
    public String password;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "telp")
    public String telp;
    @ColumnInfo(name = "alamat")
    public String alamat;
    @ColumnInfo(name = "umur")
    public int umur;
    @ColumnInfo(name = "jenis_kelamin")
    public String jk;
}

