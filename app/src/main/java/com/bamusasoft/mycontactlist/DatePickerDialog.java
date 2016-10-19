package com.bamusasoft.mycontactlist;

/**
 * Created by Abdullah BaMusa on 10/19/2016.
 */
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;

public class DatePickerDialog extends DialogFragment{
public interface SaveDateListner{
    void didFinishDatePickerDialog(Time selecteTime);
}
    public DatePickerDialog()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstnaceState){
      final View view = inflater.inflate(R.layout.dateselect, container);
        getDialog().setTitle("Select Date");
        final DatePicker dp = (DatePicker) view.findViewById(R.id.birthdayPicker);
        Button saveButton = (Button) view.findViewById(R.id.btnOk);
        saveButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Time selectedTime = new Time();
                selectedTime.set(dp.getDayOfMonth(),dp.getMonth(), dp.getYear());
                saveItem(selectedTime);
            }
        });
        Button cancelButton = (Button )view.findViewById(R.id.btnCancel);
        cancelButton.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               getDialog().dismiss();
            }
        }
        );
        return view;

    }
    private void saveItem(Time selectedTime){
        SaveDateListner activity = (SaveDateListner) getActivity();
        activity.didFinishDatePickerDialog(selectedTime);
        getDialog().dismiss();
    }
}
