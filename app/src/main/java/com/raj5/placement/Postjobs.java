package com.raj5.placement; /**
 * Created by Hp on 11/27/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import static android.content.ContentValues.TAG;



/**
 * Created by Hp on 12/02/2017.
 */

public class Postjobs extends Fragment implements View.OnClickListener{

    private ImageView mFilters;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View view = inflater.inflate(R.layout.viewjobs, container, false);
        mFilters = (ImageView) view.findViewById(R.id.ic_search);
        init();
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Search");
    }

    @Override
    public void onClick(View v) {

    }
    private void init(){
                mFilters.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Log.d(TAG, "onClick: navigating to filters activity.");
                                Intent intent = new Intent(getActivity(), FiltersActivity.class);
                                startActivity(intent);
                            }
                    });
           }
}
