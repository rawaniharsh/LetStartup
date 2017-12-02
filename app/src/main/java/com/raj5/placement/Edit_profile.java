package com.raj5.placement;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Edit_profile extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View view= inflater.inflate(R.layout.activity_edit_profile, container, false);

        Button name = (Button)view.findViewById(R.id.editname);
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Editname.class);
                startActivity(intent);
            }
        });

        Button photo = (Button)view.findViewById(R.id.editphoto);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),editphoto.class);
                startActivity(intent);
            }
        });

        Button resume = (Button)view.findViewById(R.id.updatecv);
        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),editresume.class);
                startActivity(in);
            }
        });

        Button email = (Button)view.findViewById(R.id.changeemail);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ins = new Intent(getActivity(),editemail.class);
                startActivity(ins);
            }
        });

        Button pass = (Button)view.findViewById(R.id.editpassword);
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sa = new Intent(getActivity(),editpassword.class);
                startActivity(sa);
            }
        });
        Button cv = (Button)view.findViewById(R.id.updatecv);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ca = new Intent(getActivity(),editresume.class);
                startActivity(ca);
            }
        });
        return view;


    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Edit Profile");
    }

    @Override
    public void onClick(View v) {

            }


    }

