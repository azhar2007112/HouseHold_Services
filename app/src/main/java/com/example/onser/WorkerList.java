package com.example.onser;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class WorkerList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private ArrayList<workers> workersList;
    private worker_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_list);

        setupRecyclerView();
        setupFirebase();
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.worker_details);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        workersList = new ArrayList<>();
        adapter = new worker_adapter(this, workersList);
        recyclerView.setAdapter(adapter);
    }

    private void setupFirebase() {
        databaseReference = FirebaseDatabase.getInstance().getReference("workers");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                workersList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    workers worker = dataSnapshot.getValue(workers.class);
                    worker.setKey(dataSnapshot.getKey());
                    workersList.add(worker);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Admin_panel.class));
        finish();
    }
}
