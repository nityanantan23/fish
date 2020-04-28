package com.fish.eFish;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import es.dmoral.toasty.Toasty;

import static com.fish.eFish.camera.CameraActivity.Fish_name;

public class fish_detail extends AppCompatActivity {


    EditText price, locations, quantity;
    FirebaseAuth auth;
    FirebaseUser user;

    TextView name;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String arr[] = Fish_name.split(" ");
    String arrayname = arr[1];
    private int locationRequestCode = 1000;
    private double wayLatitude = 0.0, wayLongitude = 0.0;


    private static final String TAG = "fish_detail";
    private FusedLocationProviderClient mFusedLocationClient;

    public fish_detail() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_detail);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        price = findViewById(R.id.editprice);
        this.locations = findViewById(R.id.editlocation);

        quantity = findViewById(R.id.editquantity);
        name = findViewById(R.id.fish_name);
        name.setText(arr[1]);
        String arrayname = arr[1];

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        System.out.println(arrayname);


        // check permission
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    locationRequestCode);

        } else {
            // already permission granted
        }


        if (arrayname.equals("Stereolepis") || arrayname.equals("Thymichthys") || arrayname.equals("Zoogoneticus")) {
            Intent i = new Intent(getApplicationContext(), endangered.class);
            startActivity(i);
        } else if (arrayname.equals("Tuna")) {
            price.setText("RM " + 22);
        } else {
            price.setText("RM " + 16);

        }


    }


    public void fish_details(View view) {
        String fish_price = price.getText().toString().trim();
        String fish_location = locations.getText().toString().trim();
        String fish_quantity = quantity.getText().toString().trim();


        String fish_name = arr[1];

        Map<String, Object> fishes = new HashMap<>();
        fishes.put("Fish_name", fish_name);
        fishes.put("Fish_location", fish_location);
        fishes.put("quantity", fish_quantity);
        fishes.put("Fish_Price", fish_price);


        Map<String, Object> history = new HashMap<>();
        history.put("Fish_name", fish_name);
        history.put("quantity", fish_quantity);
        history.put("Fish_Price", fish_price);
        history.put("User_id", auth.getUid());


        if (arrayname.equals("Atlantic_halibut") || arrayname.equals("Thymichthys") || arrayname.equals("Zoogoneticus")) {
            Intent i = new Intent(getApplicationContext(), endangered.class);
            startActivity(i);
            finish();

        } else {

            db.collection("Fish").document(auth.getUid()).addSnapshotListener(new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
//                    String Seller_name = documentSnapshot.getString("Seller_name");
//                    String Seller_address = documentSnapshot.getString("Seller_address");
//                    String phone_number = documentSnapshot.getString("phone_number");

//                    if (documentSnapshot.contains("Fish_name")){
//                        Toasty.info(getApplicationContext()," fish founded in db").show();
//
//                    }else{


                    db.collection("Fish").document(auth.getUid()).set(fishes, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {

//                    ArrayList<String> name=new ArrayList<String>();
//                    name.add(fish_name);
//
//                    ArrayList<String> price=new ArrayList<String>();
//                    price.add(fish_price);
//
//                    ArrayList<String> qty=new ArrayList<String>();
//                    qty.add(fish_quantity);
//


                        }
                    });



                }


            });

            db.collection("History").document().set(history, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {

                    Intent i = new Intent(getApplicationContext(), HompageActivity.class);
                    startActivity(i);
                    finish();


                    Log.d(TAG, "DocumentSnapshot successfully written!");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.w(TAG, "Error writing document", e);
                }

            });
        }
    }
}