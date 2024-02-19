package com.example.a2340anothertry.ui.b;

import android.app.TimePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.a2340anothertry.MainActivity;
import com.example.a2340anothertry.R;
import com.example.a2340anothertry.classRecyclerStuff.classes;
import com.example.a2340anothertry.databinding.FragmentABinding;
import com.example.a2340anothertry.databinding.FragmentBBinding;
import com.example.a2340anothertry.examRecyclerStuff.exams;
import com.example.a2340anothertry.ui.a.aFragment;
import com.example.a2340anothertry.ui.a.aViewModel;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class bFragment extends Fragment {
    private FragmentBBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bViewModel bViewModel =
                new ViewModelProvider(this).get(bViewModel.class);

        binding = FragmentBBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button button = root.findViewById(R.id.button6);

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

        button.setOnClickListener(new View.OnClickListener() {
            EditText location = root.findViewById(R.id.description);
            EditText name = root.findViewById(R.id.name1);
            EditText professor = root.findViewById(R.id.a_text2);

            String time = "";

            boolean booleanLocation = false;
            boolean booleanName = false;
            boolean booleanProfessor = false;
            boolean booleanTime = false;

            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(location.getText())){
                    location.setError("Location is required!");
                } else {
                    booleanLocation = true;
                }

                if (TextUtils.isEmpty(name.getText())){
                    name.setError("Class name is required!");
                } else {
                    booleanName = true;
                }
                if (TextUtils.isEmpty(professor.getText())){
                    professor.setError("Professor name is required!");
                } else {
                    booleanProfessor = true;
                }
                if (!pickTime.getText().toString().equals("Pick time")) {
                    booleanTime = true;
                }
                time += pickTime.getText().toString();

                if (booleanName && booleanProfessor && booleanLocation && booleanTime) {
                    MainActivity.classes1.add(new classes(time,
                            location.getText().toString(), name.getText().toString(), professor.getText().toString()));

                    NavHostFragment.findNavController(bFragment.this)
                            .navigate(R.id.action_nav_b_to_nav_classes);
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
