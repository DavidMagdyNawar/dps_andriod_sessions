package com.dps;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dps.model.SoftwareEngineer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyAdapter mAdapter;
    private List<SoftwareEngineer> softwareEngineerList = new ArrayList<SoftwareEngineer>();

    // TODO 1- Add recycler view dependency in the " build.gradle " ( app module ) file
    // TODO 2- Go to the activity_main and add a view for your awesome recycler view
    /*
    TODO 3- create a layout for the recycler view item
     for the sake of the example I'm using Card View ( add card view dependency in " build.gradle " ( app module )
     */
    // TODO 4- create an Adapter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cast recycler view
        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);

        mAdapter = new MyAdapter( softwareEngineerList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareSoftwareEngineerData();
    }

    private void prepareSoftwareEngineerData() {
        SoftwareEngineer softwareEngineer = new SoftwareEngineer("Daniel Bedo", "Head of Software Engineering","");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("Bela Sinoimeri","Software Engineer","");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("David Riad","Android developer","");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("Thanos","Software Engineer - Web","");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("Thilakar","Software Engineer - Mobile ","");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("Magda","Software Engineer - iOS","");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("Manoj","Software Engineer - React Native ","");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("Natasha","Software Engineer - Backend","");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("Chris","Software Engineer - Node.js","");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("Daniel","Software Engineer - Android","");
        softwareEngineerList.add(softwareEngineer);


        mAdapter.notifyDataSetChanged();

    }
}