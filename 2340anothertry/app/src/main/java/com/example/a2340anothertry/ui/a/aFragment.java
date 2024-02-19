package com.example.a2340anothertry.ui.a;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.a2340anothertry.MainActivity;
import com.example.a2340anothertry.R;
import com.example.a2340anothertry.classRecyclerStuff.classes;
import com.example.a2340anothertry.databinding.FragmentABinding;
import com.example.a2340anothertry.examRecyclerStuff.exams;
import com.example.a2340anothertry.ui.b.bFragment;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class aFragment extends Fragment {
    private FragmentABinding binding;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aViewModel aViewModel =
                new ViewModelProvider(this).get(aViewModel.class);

        binding = FragmentABinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button pickTime = root.findViewById(R.id.pickTime);
        pickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
                {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute)
                    {
                        pickTime.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), onTimeSetListener, hour, minute,
                        DateFormat.is24HourFormat(getActivity()));

                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });

        Button pickDate = root.findViewById(R.id.pickDate);
        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener()
                {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day)
                    {
                        pickDate.setText(String.format(Locale.getDefault(), "%02d/%02d/%04d",month, day, year));

                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(), onDateSetListener, year, month, day);

                datePickerDialog.setTitle("Select Date");
                datePickerDialog.show();

            }
        });

        Button button = root.findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            EditText location = root.findViewById(R.id.description);
            EditText name = root.findViewById(R.id.name1);

            String time = "";
            String date = "";

            boolean booleanLocation = false;
            boolean booleanName = false;
            boolean booleanDate = false;
            boolean booleanTime = false;

            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(location.getText())){
                    location.setError("Location is required!");
                } else {
                    booleanLocation = true;
                }

                if (TextUtils.isEmpty(name.getText())){
                    name.setError("Test name is required!");
                } else {
                    booleanName = true;
                }

                if (!pickTime.getText().toString().equals("Pick time")) {
                    booleanTime = true;
                }
                if (!pickDate.getText().toString().equals("Pick date")) {
                    booleanDate= true;
                }
                time += pickTime.getText().toString();
                date += pickDate.getText().toString();

                if (booleanName && booleanDate && booleanLocation && booleanTime) {
                    MainActivity.examList.add(new exams(time, date,
                            location.getText().toString(), name.getText().toString()));

                    NavHostFragment.findNavController(aFragment.this)
                            .navigate(R.id.action_nav_a_to_nav_slideshow);
                } else {
                    CharSequence text = "Please fill out the missing fields!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(getActivity(), text, duration);
                    toast.show();
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
