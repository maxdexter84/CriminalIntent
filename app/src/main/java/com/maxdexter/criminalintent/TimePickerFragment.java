package com.maxdexter.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

import java.util.Date;
import java.util.GregorianCalendar;

public class TimePickerFragment extends DialogFragment {
    private static final String ARG_TIME = "hour";

    public static final String EXTRA_TIME = "time";
    private TimePicker mTimePicker;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return new AlertDialog.Builder(getActivity()).setTitle(R.string.time_picker_title)
                .setView( initView())//Назначаем представление диалоговому окну
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int hour = mTimePicker.getHour();
                        int minute = mTimePicker.getMinute();
                        String time = String.format("%d"+":"+"%d",hour,minute );

                        sendResult(Activity.RESULT_OK, time);
                    }
                }).create();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private View initView() {
        String time = getArguments().getString(ARG_TIME);
        String[]token = time.split(":");
        int hour = Integer.parseInt(token[0]);
        int minute = Integer.parseInt(token[1]);

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_time,null); //Заполняем представление
        mTimePicker = (TimePicker) view.findViewById(R.id.dialog_time_picker);
        mTimePicker.setIs24HourView(true);
        mTimePicker.setHour(hour);
        mTimePicker.setMinute(minute);
        return view;
    }

    public static TimePickerFragment newInstance(String time){ //Метод для создания аргументов фрагмента и присваивания им значений
        Bundle args = new Bundle();
        args.putString(ARG_TIME,time);


        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }
    private void sendResult(int resultCode, String time){
        if(getTargetFragment() == null){
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_TIME,time);
        getTargetFragment().onActivityResult(getTargetRequestCode(),resultCode,intent);
    }

}
