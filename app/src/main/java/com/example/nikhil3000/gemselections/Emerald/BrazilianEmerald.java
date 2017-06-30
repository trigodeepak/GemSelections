package com.example.nikhil3000.gemselections.Emerald;

import android.app.Dialog;
import android.app.Fragment;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.nikhil3000.gemselections.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 29/6/17.
 */

public class BrazilianEmerald extends Fragment {

    private ImageView banner;
    private Spinner spinner;
    private ArrayAdapter<String> arrayAdapter;

    private String[] _options =
            {
                    "----- NONE -----",
                    "A Quality",
                    "B Quality",
                    "C Quality",
                    "D Quality"
            };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_brazilian_emerald, container, false);
        banner = (ImageView)view.findViewById(R.id.brazilian_emerald_banner);
        try{
            InputStream is = getActivity().getAssets().open("images/precious-gems/Emerald/african-emerald.jpg");
            banner.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }

        spinner = (Spinner)view.findViewById(R.id.emerald_brazilian_spinner);

        arrayAdapter =  new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, _options);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        break;
                    case 1:
                        show_dialog("A Grade", R.string.emerald_cabo1);
                        break;
                    case 2:
                        show_dialog("B Grade", R.string.emerald_cabo2);
                        break;
                    case 3:
                        show_dialog("C Grade", R.string.emerald_cabo3);
                        break;
                    case 4:
                        show_dialog("D Grade", R.string.emerald_cabo4);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                parent.setSelection(0);
            }
        });
        return view;
    }

    private void show_dialog(String title, int content) {
        Dialog dialog = new Dialog(getActivity());
        dialog.setTitle(title);
        dialog.setContentView(R.layout.dialog_bracelet);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());

        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);

        TextView textView  = (TextView)dialog.findViewById(R.id.content);
        textView.setText(getString(content));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
