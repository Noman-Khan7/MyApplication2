package com.example.nk.myapplication;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ListView mMessListView;
    private MessAdapter mMessAdapter;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessDatabaseReference;
    private ChildEventListener childEventListener;
    private DrawerLayout mDrawerLayout;
private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessListView = (ListView) findViewById(R.id.messageListView);


        // Initialize Firebase components
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessDatabaseReference = mFirebaseDatabase.getReference().child("messdet");


        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close );
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize message ListView and its adapter
        List<MessAbstract> mess = new ArrayList<>();
        mMessAdapter = new MessAdapter(this, R.layout.item_mess,mess);
        mMessListView.setAdapter(mMessAdapter);
        mMessDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                        MessAbstract messAbstract = ds.getValue(MessAbstract.class);
                        mMessAdapter.add(messAbstract);
                        Log.d("TAG", messAbstract.getMessName());
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

//if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//    NotificationChannel channel = new NotificationChannel("MyNotifications","MyNotification", NotificationManager.IMPORTANCE_DEFAULT);
//    NotificationManager manager = getSystemService(NotificationManager.class);
//    manager.createNotificationChannel(channel);
//        }
//
//        FirebaseMessaging.getInstance().subscribeToTopic("general")
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        String msg = "SuccessFull";
//                        if (!task.isSuccessful()) {
//                            msg ="Failed";
//                        }
//                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
//                    }
//                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
//    public void attachReadListener(){
//        childEventListener = new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                MessAbstract messAbstract =  dataSnapshot.getValue(MessAbstract.class);
//                   mMessAdapter.add(messAbstract);
//                mMessDatabaseReference.addChildEventListener(childEventListener);
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        };


}
