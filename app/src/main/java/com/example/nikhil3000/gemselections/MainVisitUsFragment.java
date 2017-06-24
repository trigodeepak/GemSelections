package com.example.nikhil3000.gemselections;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by anonymous on 18/6/17.
 */

public class MainVisitUsFragment extends Fragment {

    private Button _dir, _locate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_visit_us, container, false);
        _dir = (Button)view.findViewById(R.id.map_dir);
        _dir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_directions();
            }
        });

        _locate = (Button)view.findViewById(R.id.map_visit);
        _locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locate_this();
            }
        });
        return view;
    }

    private void locate_this() {
        startActivity(
                new Intent(Intent.ACTION_VIEW)
                        .setData(Uri.parse("https://www.google.co.in/maps/place/Gem+Selections/@28.6209117,77.076568,17z/data=!3m1!4b1!4m5!3m4!1s0x390d04c80f96cf4f:0xbb6c3f3efc72282f!8m2!3d28.620907!4d77.078762"))
        );
    }

    private void get_directions() {
        startActivity(
                new Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse("https://www.google.com/maps/dir/Janakpuri+West+Metro+Station,+Chatrapati+Shivaji+Marg,+Janakpuri,+New+Delhi,+Delhi,+India/Gem+Selections,+Shop+No.8+A-3+DDA+Market,+Janak+Puri,+New+Delhi+-110058,+New+Delhi,+Delhi+110058,+India/@28.6242847,77.0650698,15z/data=!3m1!4b1!4m13!4m12!1m5!1m1!1s0x390d04c0f23874db:0x7f63d009f51b7a06!2m2!1d77.077761!2d28.629448!1m5!1m1!1s0x390d04c80f96cf4f:0xbb6c3f3efc72282f!2m2!1d77.078762!2d28.620907"))
        );
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Visit Us");
    }
}
