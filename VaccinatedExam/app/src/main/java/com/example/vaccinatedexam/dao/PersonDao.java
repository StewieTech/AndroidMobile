package com.example.vaccinatedexam.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.vaccinatedexam.model.Person;

import java.util.List;

@Dao
public interface PersonDao {
    @Query("SELECT * FROM Person")
    List<Person> getAll();

    @Insert
    void insertAll(List<Person> people);

    @Insert
    void insert(Person person);

    @Delete
    void delete(Person person);


}
