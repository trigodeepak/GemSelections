package com.example.nikhil3000.gemselections;

import android.app.Dialog;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 26/6/17.
 */

public class MainCabochonFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private String[] options = {
            "----- NONE -----",
            "Ruby Cabochon",
            "Emerald Cabochon",
            "Blue Sapphire Cabochon"
    };

    private ArrayAdapter<String> arrayAdapter;
    private Spinner spinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main_cabochon, container, false);

        ScrollView scrollView = (ScrollView)view.findViewById(R.id.scroll);
        scrollView.setBackground(getResources().getDrawable(R.drawable.back));

        spinner = (Spinner)view.findViewById(R.id.cabochon_spinner);
        arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, options);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Cabochon Gems");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Fragment fragment = null;
        switch (position){
            case 0:
                break;

            case 1:
                fragment = new RubyCabochonFragment();
                break;

            case 2:
                show_dialog("Emerald Cabochon", R.string.cabochon3,"images/emerald-cabochon.jpg");
                break;

            case 3:
                fragment = new BlueSapphireCabochonFragment();
                break;
        }
        if (fragment!=null){
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.cabochon_container, fragment)
                    .commit();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        parent.setSelection(0);
    }

    private void show_dialog(String title, int content, String url) {
        Dialog dialog = new Dialog(getActivity());
        dialog.setTitle(title);
        dialog.setContentView(R.layout.dialog_yantra_layout);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());

        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);

        ImageView imageView = (ImageView)dialog.findViewById(R.id.yantra_image);
        InputStream is;
        try{
            is = getActivity().getAssets().open(url);
            imageView.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }
        TextView textView  = (TextView)dialog.findViewById(R.id.yantra_text);
        textView.setText(getString(content));
    }
}
