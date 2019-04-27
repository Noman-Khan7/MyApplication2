package com.example.nk.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class contact extends AppCompatActivity {


    private static final String TAG = "contact";
    private TextView messNameView;
    private TextView menusTextView;
    private TextView feastTextView;
    private TextView servicesTextView;
    private TextView addressTypeTextView;
    private TextView contactTextView;
    private TextView guestTiffinChargesTextView;
    private TextView messOwnerTextView;
    private TextView messRateTextView;
    private TextView remarksTextiew;



    // Initialize Firebase components
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        messNameView=(TextView)findViewById(R.id.messName);
        feastTextView=(TextView)findViewById(R.id.feast);
        servicesTextView=(TextView)findViewById(R.id.Services);
        addressTypeTextView=(TextView)findViewById(R.id.Address);
        contactTextView=(TextView)findViewById(R.id.contactNumber);
        guestTiffinChargesTextView=(TextView)findViewById(R.id.guestTiffinCharges);
        messOwnerTextView=(TextView)findViewById(R.id.messOwner);
        messRateTextView=(TextView)findViewById(R.id.messRate);
        remarksTextiew=(TextView)findViewById(R.id.remarks);
        menusTextView=(TextView)findViewById(R.id.Menus);






//        mFirebaseDatabase = FirebaseDatabase.getInstance();
//        mMessDatabaseReference = mFirebaseDatabase.getReference().child("messdet");
//        messNameView.setText(str);
//        mMessDatabaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                for(DataSnapshot ds : dataSnapshot.getChildren()) {
//                    MessCompleteDetail messCompleteDetail = ds.getValue(MessCompleteDetail.class);
                    messNameView.setText(getIntent().getExtras().getString("MESSNAME"));
                    feastTextView.setText(getIntent().getExtras().getString("MESSNAME"));
                    servicesTextView.setText(getIntent().getExtras().getString("MESSNAME"));
                    addressTypeTextView.setText(getIntent().getExtras().getString("MESSADD"));
                    contactTextView.setText(getIntent().getExtras().getString("MESSNAME"));
                    guestTiffinChargesTextView.setText(getIntent().getExtras().getString("MESSNAME"));
                    messOwnerTextView.setText(getIntent().getExtras().getString("MESSOWNER"));
                    messRateTextView.setText(getIntent().getExtras().getString("MESSRATE"));
                    remarksTextiew.setText(getIntent().getExtras().getString("MESSNAME"));
                    menusTextView.setText(getIntent().getExtras().getString("MESSNAME"));
//
//                }
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });


    }
}
