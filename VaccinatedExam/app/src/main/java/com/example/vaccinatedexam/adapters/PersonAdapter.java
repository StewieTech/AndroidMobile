package com.example.vaccinatedexam.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vaccinatedexam.R;
import com.example.vaccinatedexam.model.Person;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private List<Person> persons ;
    private ClickedListener clickedListener;

    public interface ClickedListener {
        void clickedListenerClicked(Person person);
    }

    public PersonAdapter(List<Person> persons, ClickedListener clickedListener ) {
        this.persons = persons;
        this.clickedListener = clickedListener;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_row_layout,parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.PersonViewHolder holder, int position) {
        Person person = persons.get(position);
        holder.firstname.setText(person.getFirstName());
        holder.lastname.setText(person.getLastName());
        holder.gender.setText(person.getGender());
        holder.vaccinationImage.setOnClickListener(tmp -> {
            if (clickedListener != null) {
                clickedListener.clickedListenerClicked(person);
            }
        });


    }

    public void InfoUpdate(List<Person> updatedInfoList) {
        this.persons = updatedInfoList;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class PersonViewHolder extends  RecyclerView.ViewHolder{
        TextView firstname, lastname, gender;
        ImageView vaccinationImage;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            firstname = itemView.findViewById(R.id.FirstNameTxt);
            lastname = itemView.findViewById(R.id.LastNameTxt);
            gender = itemView.findViewById(R.id.GenderTxt);
            vaccinationImage = itemView.findViewById(R.id.VaccinatedImage);
        }
    }
}
