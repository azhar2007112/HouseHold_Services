package com.example.onser;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    ArrayList<Getuser> list;
    userlist_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        // Singleton Pattern: Obtaining a reference to the Firebase database
        ProgressDialog dialog=new ProgressDialog(UserList.this);
        dialog.setTitle("Loading User List");
        dialog.setMessage("Please Wait...");
        dialog.show();

        recyclerView=findViewById(R.id.userlist);
        // Singleton Pattern: Obtaining a reference to the Firebase database
        databaseReference= FirebaseDatabase.getInstance().getReference("Getuser");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list= new  ArrayList<>();
        adapter =new userlist_adapter(this,list);
        recyclerView.setAdapter(adapter);

        // Observer Pattern: Listening for data changes in the Firebase database
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1: snapshot.getChildren()){

                    Getuser getuser= snapshot1.getValue(Getuser.class);
                    list.add(getuser);

                }

                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
