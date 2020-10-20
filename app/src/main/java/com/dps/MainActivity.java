package com.dps;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dps.adapter.MyAdapter;
import com.dps.model.SoftwareEngineer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    // TODO 4- create an Adapter for the recycler view
    // TODO 5- Create data model - in our case " SoftwareEngineer " Data Model
    // TODO 6- Attach the adapter to the recycler view with the prepared data
    // TODO 7- Adding firebase dependency to " app.module " file , adding google services and google plugins ( check firebase docmentation )

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //cast recycler view
        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);
        //pass our software engineers list to our adapter
        mAdapter = new MyAdapter(softwareEngineerList, this);
        // set the layout manager for our recycler view as a lienar layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        //set some cool default animation
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //attach our adapter with the recycler view
        recyclerView.setAdapter(mAdapter);

//        prepareSoftwareEngineerData();
          firebasePrepareSoftwareEngineerData();
    }

    private void firebasePrepareSoftwareEngineerData() {

        FirebaseDatabase db = FirebaseDatabase.getInstance();

        db.getReference().child("se").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                softwareEngineerList.clear();
                for (DataSnapshot datasnapshot : snapshot.getChildren()) {
                    SoftwareEngineer softwareEngineer = datasnapshot.getValue(SoftwareEngineer.class);
                    if(softwareEngineer!= null){
                        softwareEngineerList.add(softwareEngineer);
                    }
                }
                mAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void prepareSoftwareEngineerData() {
        SoftwareEngineer softwareEngineer = new SoftwareEngineer("Daniel Bedo", "Head of Software Engineering", "");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("Bela Sinoimeri", "Software Engineer", "");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("David Riad", "Android developer", "");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("Thanos", "Software Engineer - Web", "");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("Thilakar", "Software Engineer - Mobile ", "");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("Magda", "Software Engineer - iOS", "");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("Manoj", "Software Engineer - React Native ", "");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("Natasha", "Software Engineer - Backend", "");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("Chris", "Software Engineer - Node.js", "");
        softwareEngineerList.add(softwareEngineer);

        softwareEngineer = new SoftwareEngineer("Daniel", "Software Engineer - Android", "");
        softwareEngineerList.add(softwareEngineer);

        //notify the adapter that new data has to be shown on the recycler view
        mAdapter.notifyDataSetChanged();

    }
}