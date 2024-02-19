package com.example.a2340anothertry.ui.classes;

import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2340anothertry.MainActivity;
import com.example.a2340anothertry.R;
import com.example.a2340anothertry.classRecyclerStuff.classes;
import com.example.a2340anothertry.classRecyclerStuff.classes_adapter;
import com.example.a2340anothertry.databinding.FragmentClassesBinding;
import com.example.a2340anothertry.databinding.FragmentGalleryBinding;
import com.example.a2340anothertry.databinding.FragmentSlideshowBinding;
import com.example.a2340anothertry.examRecyclerStuff.exam_adapter;
import com.example.a2340anothertry.examRecyclerStuff.exams;
import com.example.a2340anothertry.ui.gallery.GalleryViewModel;
import com.example.a2340anothertry.ui.slideshow.SlideshowFragment;
import com.example.a2340anothertry.ui.slideshow.SlideshowViewModel;

import java.util.ArrayList;
import java.util.Date;

public class ClassesFragment extends Fragment {

    private FragmentClassesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ClassesViewModel ClassesViewModel =
                new ViewModelProvider(this).get(ClassesViewModel.class);

        binding = FragmentClassesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        ClassesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        ArrayList<classes> classList = MainActivity.classes1;

        RecyclerView recyclerView = binding.classRecycler;
        classes_adapter classes_adapter = new classes_adapter(classList, requireContext());
        recyclerView.setAdapter(classes_adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //edit Button
        Button button = root.findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ClassesFragment.this)
                        .navigate(R.id.action_nav_classes_to_nav_b);
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