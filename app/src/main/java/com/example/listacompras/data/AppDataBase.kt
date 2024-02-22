package com.example.listacompras.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Products::class],version= 1)
abstract class AppDataBase : RoomDatabase(){

    abstract fun productDao() : ProductDao
}