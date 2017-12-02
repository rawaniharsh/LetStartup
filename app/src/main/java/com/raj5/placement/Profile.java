package com.raj5.placement; /**
 * Created by Hp on 11/27/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;


/**
 * Created by Hp on 12/02/2017.
 */

public class Profile extends Fragment implements View.OnClickListener{

    public void onClick(View v) {

    }

    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private Button mSignOut;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        //return inflater.inflate(R.layout.profile, container, false);
        View view = inflater.inflate(R.layout.profile, container, false);
                mSignOut = (Button) view.findViewById(R.id.sign_out);

                      setupFirebaseListener();

                     mSignOut.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                       Log.d(TAG, "onClick: attempting to sign out the user.");
                                       FirebaseAuth.getInstance().signOut();
                                  }
                     });


        return view;


    }

    private void setupFirebaseListener(){
             Log.d(TAG, "setupFirebaseListener: setting up the auth state listener.");
              mAuthStateListener = new FirebaseAuth.AuthStateListener() {
                       @Override
                       public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                               FirebaseUser user = firebaseAuth.getCurrentUser();
                               if(user != null){
                                      Log.d(TAG, "onAuthStateChanged: signed_in: " + user.getUid());
                                    }else{
                                        Log.d(TAG, "onAuthStateChanged: signed_out");
                                  Toast.makeText(getActivity(), "Signed out", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getActivity(), Login.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                       startActivity(intent);
                                  }            }
                    };
            }



    @Override
        public void onStart() {
            super.onStart();
            FirebaseAuth.getInstance().addAuthStateListener(mAuthStateListener);
      }
       @Override
       public void onStop() {
                super.onStop();
                if(mAuthStateListener != null){
                        FirebaseAuth.getInstance().removeAuthStateListener(mAuthStateListener);
                   }
         }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("LogOut");
    }
}