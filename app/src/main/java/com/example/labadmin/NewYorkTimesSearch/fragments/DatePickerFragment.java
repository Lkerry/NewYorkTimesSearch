package com.example.labadmin.NewYorkTimesSearch.fragments;

/**
 * Created by labadmin on 7/24/17.
 */

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DatePickerDialog.OnDateSetListener} interface
 * to handle interaction events.
 */
public class DatePickerFragment extends DialogFragment {

    public void setOndateSet(DatePickerDialog.OnDateSetListener ondateSet) {
        this.ondateSet = ondateSet;
    }

    DatePickerDialog.OnDateSetListener ondateSet;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of TimePickerDialog and return it
        return new DatePickerDialog(getActivity(), ondateSet, year, month, day);
    }
}
