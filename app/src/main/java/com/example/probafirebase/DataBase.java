package com.example.probafirebase;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class DataBase {

    // Access a Cloud Firestore instance from your Activity

    static FirebaseFirestore db;
    static int iKont = 1;

    public static FirebaseFirestore getDb() {
        if (db == null){
            db = FirebaseFirestore.getInstance();
        }

        return db;
    }

    public static void crearUsuario (String first, String last, int born) {
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", first + " " + iKont);
        user.put("last", last + " " + iKont);
        user.put("born", born);
        iKont++;

        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

    public static void crearCoche (String sMarca, String sModelo, int iLanzamiento) {
        // Create a new user with a first and last name
        Map<String, Object> car = new HashMap<>();
        car.put("first", sMarca + " " + iKont);
        car.put("last", sModelo + " " + iKont);
        car.put("born", iLanzamiento);
        iKont++;

        // Add a new document with a generated ID
        db.collection("cars")
                .add(car)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }


}
