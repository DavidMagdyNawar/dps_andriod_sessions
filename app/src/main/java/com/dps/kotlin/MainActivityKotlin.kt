package com.dps.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dps.R
import com.dps.adapter.MyAdapter
import com.dps.model.SoftwareEngineer
import com.dps.snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main_kotlin.*

class MainActivityKotlin : AppCompatActivity() {

    private var mAdapter: RecyclerViewAdapter? = null
    private val softwareEngineerList: MutableList<com.dps.kotlin.SoftwareEngineer> = ArrayList()

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
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kotlin)

        /* TODO : in Kotlin we don't need casting, just add Kotlin extension to your build.gradle ( app module )
            and access the view name property from the class directly */
//        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)

        //pass our software engineers list to our adapter
        mAdapter = RecyclerViewAdapter(softwareEngineerList, this)
        // set the layout manager for our recycler view as a lienar layout manager
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        myRecyclerViewKotlin.layoutManager = mLayoutManager
        //set some cool default animation
        myRecyclerViewKotlin.itemAnimator = DefaultItemAnimator()
        //attach our adapter with the recycler view
        myRecyclerViewKotlin.adapter = mAdapter

        firebasePrepareSoftwareEngineerData()
    }

    private fun firebasePrepareSoftwareEngineerData() {
        val db = FirebaseDatabase.getInstance()
        db.reference.child("se").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                softwareEngineerList.clear()
                for (datasnapshot in snapshot.children) {
                    val softwareEngineer = datasnapshot.getValue(com.dps.kotlin.SoftwareEngineer::class.java)
                    if (softwareEngineer != null) {
                        softwareEngineerList.add(softwareEngineer)
                    }
                }
                mAdapter?.notifyDataSetChanged()
                myLayout.snackbar("Data loaded successfully")
            }
            override fun onCancelled(error: DatabaseError) {}
        })
    }
}