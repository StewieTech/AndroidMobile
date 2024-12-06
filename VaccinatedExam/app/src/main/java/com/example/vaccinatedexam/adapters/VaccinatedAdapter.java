package com.example.vaccinatedexam.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vaccinatedexam.R;
import com.example.vaccinatedexam.model.Vaccinated;

import java.util.List;

public class VaccinatedAdapter extends RecyclerView.Adapter<VaccinatedAdapter.VaccinatedViewHolder> {

    private List<Vaccinated> vaccinatedPeople;

    public VaccinatedAdapter(List<Vaccinated> vaccinatedPeople ) {
        this.vaccinatedPeople = vaccinatedPeople;
    }

    @NonNull
    @Override
    public VaccinatedAdapter.VaccinatedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout_vaccinated, parent, false);
        return new VaccinatedViewHolder(view);
    }

    public void updateInfo(List<Vaccinated> updatedInfoList) {
        this.vaccinatedPeople = updatedInfoList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull VaccinatedAdapter.VaccinatedViewHolder holder, int position) {
        Vaccinated vaccinated = vaccinatedPeople.get(position);
        holder.firstName.setText(vaccinated.getFirstName());
        holder.lastName.setText(vaccinated.getLastName());
        holder.gender.setText(vaccinated.getGender());

    }

    @Override
    public int getItemCount() {
        return vaccinatedPeople.size();
    }

    public class VaccinatedViewHolder extends RecyclerView.ViewHolder {
        TextView firstName, lastName, gender ;
        public VaccinatedViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.FirstNameVaccinatedTxt);
            lastName = itemView.findViewById(R.id.LastNameVaccinatedTxt);
            firstName = itemView.findViewById(R.id.GenderTxt);
        }
    }
}
