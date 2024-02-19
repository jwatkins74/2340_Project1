package com.example.a2340anothertry;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.example.a2340anothertry.assignmentsRecyclerStuff.assignments;
import com.example.a2340anothertry.classRecyclerStuff.classes;
import com.example.a2340anothertry.examRecyclerStuff.exams;
import com.example.a2340anothertry.todoRecyclerStuff.todos;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2340anothertry.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    public  static ArrayList<exams> examList = new ArrayList<>();
    public static ArrayList<assignments> assignments = new ArrayList<>();
    public static ArrayList<classes> classes1 = new ArrayList<>();
    public static ArrayList<todos> todoList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_classes)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //Initial data
        examList.add(new exams("12:04", "1/23/2024", "Howey", "Exam 1"));
        examList.add(new exams("1:00", "3/5/2024", "Howey", "Exam 1"));
        examList.add(new exams("5:50", "3/5/2024", "Stamps", "Exam 2"));
        assignments.add(new assignments("Project 1", "Cs 2340", "3/5/2024"));
        classes1.add(new classes("9:30", "IC Building", "Combo", "Dan"));
        classes1.add(new classes("8:00", "Howey", "Objects and Design", "Pedro"));
        todoList.add(new todos("Project 1", "Hehe", "11:59 pm", "02/06/2024"));
        todoList.add(new todos("Project 2", "Hehe", "11:59 pm", "05/23/2024"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}