package com.example.a2340anothertry.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2340anothertry.MainActivity;
import com.example.a2340anothertry.R;
import com.example.a2340anothertry.assignmentsRecyclerStuff.assignments;
import com.example.a2340anothertry.assignmentsRecyclerStuff.assignments_adapter;
import com.example.a2340anothertry.assignmentsRecyclerStuff.sortAssignments;
import com.example.a2340anothertry.assignmentsRecyclerStuff.sortAssignmentsDeclaration;
import com.example.a2340anothertry.databinding.FragmentGalleryBinding;
import com.example.a2340anothertry.examRecyclerStuff.exam_adapter;
import com.example.a2340anothertry.examRecyclerStuff.exams;
import com.example.a2340anothertry.ui.c.cEditFragment;
import com.example.a2340anothertry.ui.slideshow.SlideshowFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class GalleryFragment extends Fragment implements assignments_adapter.ItemClickListener{

    private FragmentGalleryBinding binding;

    public static GalleryFragment newInstance() {
        GalleryFragment fragment = new GalleryFragment();
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        ArrayList<assignments> assignments = MainActivity.assignments;

        RecyclerView recyclerView = binding.classRecycler;
        assignments_adapter assignmentsAdapter = new assignments_adapter(assignments, requireContext(), this::onItemClick);
        recyclerView.setAdapter(assignmentsAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        Collections.sort(assignments, sortAssignments.NameComparator);

        Switch switchView = root.findViewById(R.id.switchsort);
        if (switchView.isChecked()) {
            Collections.sort(assignments, sortAssignments.DateComparator);
        } else {
            Collections.sort(assignments, sortAssignments.NameComparator);
        }
        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton switchView, boolean isChecked) {
                if (switchView.isChecked()) {
                    Collections.sort(assignments, sortAssignments.DateComparator);
                } else {
                    Collections.sort(assignments, sortAssignments.NameComparator);
                }
                assignmentsAdapter.notifyDataSetChanged();
            }
        });

        //add Button
        Button button = root.findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(GalleryFragment.this)
                        .navigate(R.id.action_nav_gallery_to_nav_c);
            }
        });

        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(assignments assignment) {
        NavHostFragment.findNavController(GalleryFragment.this)
                .navigate(R.id.action_nav_gallery_to_nav_c_edit);
        Fragment fragment = cEditFragment.newInstances(assignment.getName(), assignment.getClass1(), assignment.getDuedate());

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();


        transaction.replace(R.id.frame_c_edit, fragment, "fragment_c_edit");
        //transaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("gallery_frag"));
        //transaction.add(R.id.frame_c_edit, fragment);
        //transaction.addToBackStack(null);
        transaction.commit();

    }
}