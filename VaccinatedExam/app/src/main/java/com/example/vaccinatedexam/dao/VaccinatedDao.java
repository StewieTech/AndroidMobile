package com.example.vaccinatedexam.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.vaccinatedexam.model.Vaccinated;

import java.util.List;

@Dao
public interface VaccinatedDao {
    @Query("SELECT * FROM Vaccinated")
    List<Vaccinated> getAll();

    @Insert
    void insert(Vaccinated person);

}
