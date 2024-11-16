package com.example.databasefun;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CarDao {
    @Query("SELECT * from Car")
    List<Car> getAllCars();

    @Insert
    void insertAll(Car... car);

    @Query("Delete from Car where car_make = :carMake")
    void deleteByMake(String carMake) ;

}
