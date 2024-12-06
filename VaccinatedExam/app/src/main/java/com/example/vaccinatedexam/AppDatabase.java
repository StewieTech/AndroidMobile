package com.example.vaccinatedexam;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.vaccinatedexam.dao.PersonDao;
import com.example.vaccinatedexam.dao.VaccinatedDao;
import com.example.vaccinatedexam.model.Person;
import com.example.vaccinatedexam.model.Vaccinated;

@Database(entities = {Person.class, Vaccinated.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PersonDao personDao();
    public abstract VaccinatedDao vaccinatedDao();
}
