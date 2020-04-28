package com.fish.eFish;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class History extends AppCompatActivity {

    String[] s1 , s2, s3;
    RecyclerView recyclerView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "History";
    FirebaseAuth auth;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        recyclerView = findViewById(R.id.recyclerView);
        auth = FirebaseAuth.getInstance();


//        Intent i = getIntent();
//        Bundle b = i.getExtras();
//        if (b != null) {
//            ArrayList j = (ArrayList) b.get("key");
//            ArrayList k = (ArrayList) b.get("key1");
//            ArrayList l = (ArrayList) b.get("key2");
//
//
//            ArrayList jsave = (ArrayList) b.get("key");
//            ArrayList ksave = (ArrayList) b.get("key1");
//            ArrayList lsave = (ArrayList) b.get("key2");
//
//
//            if (j.size() < 0) {
//                if (jsave.size() < 0) {
//                }
//
//            }
//            System.out.println(j);
//
//            String[] array = new String[j.size()];
//
//            for (int i1 = 0; i1 < j.size(); i1++) {
//                array[i1] = (String) j.get(i1);
//            }
//            String[] array1 = new String[k.size()];
//
//            for (int i1 = 0; i1 < k.size(); i1++) {
//                array1[i1] = (String) k.get(i1);
//            }
//            String[] array2 = new String[l.size()];
//
//            for (int i1 = 0; i1 < l.size(); i1++) {
//                array2[i1] = (String) l.get(i1);
//            }
//
//            s1 = array;
//            s2 = array1;
//            s3 = array2;
//
//
//            ArrayList history;


            db.collection("History").get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            int flag = 0;
                            if (task.isSuccessful()) {

                                s1=new String[task.getResult().size()];
                                s2=new String[task.getResult().size()];
                                s3=new String[task.getResult().size()];

                                for (QueryDocumentSnapshot document : task.getResult()) {

                                    if (document.getData().get("User_id").toString().equals(auth.getUid())) {
                                        s1[flag] = document.getData().get("Fish_name").toString();
                                        s2[flag] = document.getData().get("Fish_Price").toString();
                                        s3[flag] = document.getData().get("quantity").toString();

//                                        Log.d(TAG, "jjj: "+document.getData().get("quantity").toString());
                                        flag = flag + 1;
                                    }
                                }
                                MyAdapter myAdapter = new MyAdapter(History.this, s1, s2, s3);
                                recyclerView.setAdapter(myAdapter);
                                recyclerView.setLayoutManager(new LinearLayoutManager(History.this));

                            } else {
                                Log.w(TAG, "Error getting documents.", task.getException());
                            }
                        }


                    });




        }


//        ArrayList<String> numbersList = (ArrayList<String>) getIntent().getSerializableExtra("key");
//        textView.setText(String.valueOf(numbersList));
//
//        ArrayList<String> numbersList = (ArrayList<String>) getIntent().getSerializableExtra("key");
//        textView.setText(String.valueOf(numbersList));
//
//        ArrayList<String> numbersList = (ArrayList<String>) getIntent().getSerializableExtra("key");
//        textView.setText(String.valueOf(numbersList));


    }



