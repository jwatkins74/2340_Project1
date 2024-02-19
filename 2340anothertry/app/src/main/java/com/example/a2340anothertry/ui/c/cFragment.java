package com.example.a2340anothertry.ui.c;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.a2340anothertry.MainActivity;
import com.example.a2340anothertry.R;
import com.example.a2340anothertry.assignmentsRecyclerStuff.assignments;
import com.example.a2340anothertry.classRecyclerStuff.classes;
import com.example.a2340anothertry.databinding.FragmentCBinding;
import com.example.a2340anothertry.ui.b.bFragment;

import java.util.Calendar;
import java.util.Locale;

public class cFragment extends Fragment {
    private FragmentCBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cViewModel cViewModel =
                new ViewModelProvider(this).get(cViewModel.class);

        binding = FragmentCBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


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

            EditText class1 = root.findViewById(R.id.description);
            EditText name = root.findViewById(R.id.name1);
            String date = "";

            boolean booleanClass = false;
            boolean booleanName = false;
            boolean booleanTime = false;

            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(class1.getText())){
                    class1.setError("Class name is required!");
                } else {
                    booleanClass = true;
                }

                if (TextUtils.isEmpty(name.getText())){
                    name.setError("Assignment name is required!");
                } else {
                    booleanName = true;
                }

                if (!pickDate.getText().toString().equals("Pick date")) {
                    booleanTime = true;
                }

                date += pickDate.getText().toString();

                if (booleanName && booleanClass && booleanTime) {
                    MainActivity.assignments.add(new assignments(name.getText().toString(), class1.getText().toString(), date));
                    NavHostFragment.findNavController(cFragment.this)
                            .navigate(R.id.action_nav_c_to_nav_gallery);
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
