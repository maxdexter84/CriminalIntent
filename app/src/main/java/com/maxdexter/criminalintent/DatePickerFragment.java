package com.maxdexter.criminalintent;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


public class DatePickerFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity()) //Создаем экземпляр AlertDialog
                .setTitle(R.string.date_picker_title)//Присваиваем тайтл диалоговому окну
                .setPositiveButton(android.R.string.ok,null)// устанавливаем кнопку ОК в диалоговое окно
                .create();//Создаем диалоговое окно
    }
}
