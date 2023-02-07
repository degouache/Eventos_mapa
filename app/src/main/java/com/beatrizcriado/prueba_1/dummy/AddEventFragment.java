package com.beatrizcriado.prueba_1.dummy;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.fragment.app.Fragment;

import com.beatrizcriado.prueba_1.MainActivity;
import com.beatrizcriado.prueba_1.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class AddEventFragment extends Fragment implements View.OnClickListener {
    //objects
    ItemEventInfo itemEventInfo;
    //Componentes
    EditText titleET;
    EditText place;
    Button dayBT;
    Button timeBT;
    Button addEvent;
    //Picker Dialogs
    TimePickerDialog pickerTimeDialog;
    DatePickerDialog pickerDateDialog;
    MainActivity mainActivity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_add_event, container, false);
        itemEventInfo = new ItemEventInfo();

        titleET = fragmentView.findViewById(R.id.titleET);
        place = fragmentView.findViewById(R.id.place);
        dayBT = fragmentView.findViewById(R.id.dayBT);
        dayBT.setOnClickListener((View.OnClickListener) this);
        timeBT = fragmentView.findViewById(R.id.timeBT);
        timeBT.setOnClickListener((View.OnClickListener) this);
        addEvent = fragmentView.findViewById(R.id.addEvent);
        addEvent.setOnClickListener((View.OnClickListener) this);
        mainActivity = (MainActivity) getActivity();

        //Picker Dialogs
        pickerTimeDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                itemEventInfo.setTime(hourOfDay, minute);

            }
        }, 12, 0, true);

        Calendar today = new GregorianCalendar();
        pickerDateDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                itemEventInfo.setDate(year, month, dayOfMonth);
            }
        }, today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));


        return fragmentView;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dayBT:
                pickerDateDialog.show();

                break;
            case R.id.timeBT:
                pickerTimeDialog.show();

                break;
            case R.id.addEvent:
                itemEventInfo.title = titleET.getText().toString();
                itemEventInfo.place = place.getText().toString();

                if (itemEventInfo.isCompleted()) {
                    mainActivity.addItemToList(itemEventInfo);
                } else {
                    Snackbar.make(v, "Completa los campos vacios", Snackbar.LENGTH_LONG)
                            .show();
                }

                break;
            default:
                break;
        }
    }
}