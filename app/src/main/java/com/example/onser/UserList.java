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
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        setupRecyclerView();

        dialog = new ProgressDialog(UserList.this);
        dialog.setTitle("Loading User List");
        dialog.setMessage("Please Wait...");
        dialog.setCanceledOnTouchOutside(false); // Prevent dialog from being dismissed on outside touch
        dialog.show();

        fetchDataFromFirebase();
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.userlist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new userlist_adapter(this, list);
        recyclerView.setAdapter(adapter);
    }

    private void fetchDataFromFirebase() {
        databaseReference = FirebaseDatabase.getInstance().getReference("Getuser");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear(); // Clear the list before adding new data
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    Getuser getuser = snapshot1.getValue(Getuser.class);
                    list.add(getuser);
                }

                adapter.notifyDataSetChanged();
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Dismiss dialog if activity is destroyed
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
