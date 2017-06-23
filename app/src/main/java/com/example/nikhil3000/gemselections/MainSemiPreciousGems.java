package com.example.nikhil3000.gemselections;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by anonymous on 22/6/17.
 */

public class MainSemiPreciousGems extends android.support.v4.app.Fragment {

    private Spinner spinner;
    private ArrayAdapter<String> arrayAdapter;
    private String[] _items =
            {
                    "Amethyst (Katela)",
                    "Aquamarine (Beruj)",
                    "Black Onyx (Cabochon)",
                    "Black Onyx (Cut)",
                    "Black Rainbow",
                    "Black Star",
                    "Blue Topaz",
                    "Beruj",
                    "Citrine",
                    "Chandramani",
                    "Dhunela",
                    "Feroja",
                    "Garnet (Tamara)",
                    "Golden Topaz",
                    "Green Amethyst",
                    "Green Fluorite",
                    "Green Garnet(Vasonite)",
                    "Green Onyx",
                    "Green Tourmaline",
                    "Iolite (Kaka Neeli)",
                    "Jade",
                    "Kateala",
                    "Kakaneeli",
                    "Kyanite",
                    "Labrolite",
                    "Lajwrat",
                    "Lapis Lazuli",
                    "Lemon Topaz",
                    "Malachite",
                    "Moonstone (Chandramani)",
                    "Opal",
                    "Onyx",
                    "Peridot",
                    "Pink Tourmaline",
                    "Red Onyx (Cabochon)",
                    "Red Onyx (Cut)",
                    "Rhodolite Garnet (Cut)",
                    "Rose Quartz",
                    "Smoky Topaz (Dhunela)",
                    "Star Ruby",
                    "Sunehala",
                    "Sang-e-Maryam",
                    "Surya Kant Mani",
                    "Tamara",
                    "Tiger's Eye",
                    "Turquoise (Feroza)",
                    "Vasonite",
                    "White Coral",
                    "White Quartz",
                    "White Rainbow",
                    "White Topaz",
                    "Zircon"
            };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_semi_precious_gems, container, false);
        spinner = (Spinner)view.findViewById(R.id.gemstone_spinner);
        arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, _items);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Semi Precious Gems");
    }
}
