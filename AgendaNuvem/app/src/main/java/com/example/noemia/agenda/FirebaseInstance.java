package com.example.noemia.agenda;

import com.firebase.client.Firebase;

/**
 * Created by Noemia on 22/04/2016.
 */
public class FirebaseInstance {
    private static Firebase firebase;
    private static final String URL = "https://aulanoemia.firebaseio.com/contatos";


    public static com.firebase.client.Firebase getInstance() {
        if (firebase == null) {
            firebase = new Firebase(URL);
        }
        return firebase;
    }
}
