package com.example.a2340anothertry.ui.c;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import com.example.a2340anothertry.databinding.FragmentCEditBinding;
import com.example.a2340anothertry.ui.b.bFragment;

import java.util.Calendar;
import java.util.Locale;

public class cEditFragment extends Fragment {
    private FragmentCEditBinding binding;
    private static final String ARG_assignmentName = "assignment name";
    private static final String ARG_description = "description";
    private static final String ARG_dueDate = "due date";
    private String assignmentName;
    private String description;
    private String dueDate;
    public static String assignmentName1;
    public static String description1;
    public static String dueDate1;

    public cEditFragment() {
        //empty
    }
    public static cEditFragment newInstances(String nameStr, String descriptionStr, String dateStr) {
        cEditFragment fragment = new cEditFragment();
        Bundle args = new Bundle();
        args.putString(ARG_assignmentName, nameStr);
        args.putString(ARG_description, descriptionStr);
        args.putString(ARG_dueDate, dateStr);
        fragment.setArguments(args);
        assignmentName1 = nameStr;
        description1 = descriptionStr;
        dueDate1 = dateStr;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            assignmentName = getArguments().getString(ARG_assignmentName);
            description = getArguments().getString(ARG_description);
            dueDate = getArguments().getString(ARG_dueDate);
        }
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        cEditViewModel cEditViewModel =
                new ViewModelProvider(this).get(cEditViewModel.class);

        binding = FragmentCEditBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button pickDate = root.findViewById(R.id.pickDate);
        EditText class1 = root.findViewById(R.id.description);
        EditText name = root.findViewById(R.id.name1);

        class1.setText(description);
        name.setText(assignmentName);
        pickDate.setText(dueDate);

        class1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                description = s.toString();
            }
        });

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                assignmentName = s.toString();
            }
        });

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
            String date = "";

            @Override
            public void onClick(View v) {
                date += pickDate.getText().toString();


                if (!TextUtils.isEmpty(name.getText()) & !TextUtils.isEmpty(class1.getText())) {
                    MainActivity.assignments.add(new assignments(assignmentName, description, date));
                    NavHostFragment.findNavController(cEditFragment.this)
                            .navigate(R.id.action_nav_c_edit_to_nav_gallery);
                } else if (!TextUtils.isEmpty(name.getText())) {
                    MainActivity.assignments.add(new assignments(assignmentName, description1, date));
                    NavHostFragment.findNavController(cEditFragment.this)
                            .navigate(R.id.action_nav_c_edit_to_nav_gallery);
                } else if (!TextUtils.isEmpty(class1.getText())){
                    MainActivity.assignments.add(new assignments(assignmentName1, description, date));
                    NavHostFragment.findNavController(cEditFragment.this)
                            .navigate(R.id.action_nav_c_edit_to_nav_gallery);
                }else {
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
