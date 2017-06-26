package com.example.nikhil3000.gemselections;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.nikhil3000.gemselections.SemiPreciousGems.AmethystFragment;
import com.example.nikhil3000.gemselections.SemiPreciousGems.AquamarineFragment;
import com.example.nikhil3000.gemselections.SemiPreciousGems.Beruj;
import com.example.nikhil3000.gemselections.SemiPreciousGems.BlackOnyxCabochon;
import com.example.nikhil3000.gemselections.SemiPreciousGems.BlackOnyxCut;
import com.example.nikhil3000.gemselections.SemiPreciousGems.BlackRainbow;
import com.example.nikhil3000.gemselections.SemiPreciousGems.BlackStar;
import com.example.nikhil3000.gemselections.SemiPreciousGems.BlueTopaz;
import com.example.nikhil3000.gemselections.SemiPreciousGems.Chandramani;
import com.example.nikhil3000.gemselections.SemiPreciousGems.Citrine;
import com.example.nikhil3000.gemselections.SemiPreciousGems.Dhunela;
import com.example.nikhil3000.gemselections.SemiPreciousGems.Feroja;
import com.example.nikhil3000.gemselections.SemiPreciousGems.Feroja2;
import com.example.nikhil3000.gemselections.SemiPreciousGems.Garnet;
import com.example.nikhil3000.gemselections.SemiPreciousGems.GoldenTopaz;
import com.example.nikhil3000.gemselections.SemiPreciousGems.GreenAmethyst;
import com.example.nikhil3000.gemselections.SemiPreciousGems.GreenFluorite;
import com.example.nikhil3000.gemselections.SemiPreciousGems.GreenGarnet;
import com.example.nikhil3000.gemselections.SemiPreciousGems.GreenOnyx;
import com.example.nikhil3000.gemselections.SemiPreciousGems.GreenTourmaline;
import com.example.nikhil3000.gemselections.SemiPreciousGems.Iolite;
import com.example.nikhil3000.gemselections.SemiPreciousGems.Jade;
import com.example.nikhil3000.gemselections.SemiPreciousGems.Kyanite;
import com.example.nikhil3000.gemselections.SemiPreciousGems.Labradorite;
import com.example.nikhil3000.gemselections.SemiPreciousGems.Lajwrat;
import com.example.nikhil3000.gemselections.SemiPreciousGems.LemonTopaz;
import com.example.nikhil3000.gemselections.SemiPreciousGems.Malachite;
import com.example.nikhil3000.gemselections.SemiPreciousGems.Maryam;
import com.example.nikhil3000.gemselections.SemiPreciousGems.Opal;
import com.example.nikhil3000.gemselections.SemiPreciousGems.Peridot;
import com.example.nikhil3000.gemselections.SemiPreciousGems.PinkTourmaline;
import com.example.nikhil3000.gemselections.SemiPreciousGems.RedOnyxCabochon;
import com.example.nikhil3000.gemselections.SemiPreciousGems.RedOnyxCut;
import com.example.nikhil3000.gemselections.SemiPreciousGems.RhodoliteGarnet;
import com.example.nikhil3000.gemselections.SemiPreciousGems.RoseQuartz;
import com.example.nikhil3000.gemselections.SemiPreciousGems.StarRuby;
import com.example.nikhil3000.gemselections.SemiPreciousGems.TigersEye;
import com.example.nikhil3000.gemselections.SemiPreciousGems.WhiteCoral;
import com.example.nikhil3000.gemselections.SemiPreciousGems.WhiteQuartz;
import com.example.nikhil3000.gemselections.SemiPreciousGems.WhiteRainbow;
import com.example.nikhil3000.gemselections.SemiPreciousGems.WhiteTopaz;
import com.example.nikhil3000.gemselections.SemiPreciousGems.Zircon;

/**
 * Created by anonymous on 22/6/17.
 */

public class MainSemiPreciousGems extends android.support.v4.app.Fragment implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private ArrayAdapter<String> arrayAdapter;
    private String[] _items =
            {
                    "----- NONE -----",
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

        spinner.setOnItemSelectedListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Semi Precious Gems");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Fragment fragment=null;
        switch (position){
            case 0:
                break;
            case 1:
                fragment = new AmethystFragment();
                break;
            case 2:
                fragment = new AquamarineFragment();
                break;
            case 3:
                fragment = new BlackOnyxCabochon();
                break;
            case 4:
                fragment = new BlackOnyxCut();
                break;
            case 5:
                fragment = new BlackRainbow();
                break;
            case 6:
                fragment = new BlackStar();
                break;
            case 7:
                fragment = new BlueTopaz();
                break;
            case 8:
                fragment = new Beruj();
                break;
            case 9:
                fragment = new Citrine();
                break;
            case 10:
                fragment = new Chandramani();
                break;
            case 11:
                fragment = new Dhunela();
                break;
            case 12:
                fragment = new Feroja();
                break;
            case 13:
                fragment = new Garnet();
                break;
            case 14:
                fragment = new GoldenTopaz();
                break;
            case 15:
                fragment = new GreenAmethyst();
                break;
            case 16:
                fragment = new GreenFluorite();
                break;
            case 17:
                fragment = new GreenGarnet();
                break;
            case 18:
                fragment = new GreenOnyx();
                break;
            case 19:
                fragment = new GreenTourmaline();
                break;
            case 20:
                fragment = new Iolite();
                break;
            case 21:
                fragment = new Jade();
                break;
            case 22:
                fragment = new AmethystFragment();
                break;
            case 23:
                fragment = new Iolite();
                break;
            case 24:
                fragment = new Kyanite();
                break;
            case 25:
                fragment = new Labradorite();
                break;
            case 26:
            case 27:
                fragment = new Lajwrat();
                break;
            case 28:
                fragment = new LemonTopaz();
                break;
            case 29:
                fragment = new Malachite();
                break;
            case 30:
                fragment = new Chandramani();
                break;
            case 31:
                fragment = new Opal();
                break;
            case 32:
                fragment = new GreenOnyx();
                break;
            case 33:
                fragment = new Peridot();
                break;
            case 34:
                fragment = new PinkTourmaline();
                break;
            case 35:
                fragment = new RedOnyxCabochon();
                break;
            case 36:
                fragment = new RedOnyxCut();
                break;
            case 37:
                fragment = new RhodoliteGarnet();
                break;
            case 38:
                fragment = new RoseQuartz();
                break;
            case 39:
                fragment = new Dhunela();
                break;
            case 40:
                fragment = new StarRuby();
                break;
            case 41:
                fragment = new Citrine();
                break;
            case 42:
                fragment = new Maryam();
                break;
            case 43:
                fragment = new StarRuby();
                break;
            case 44:
                fragment = new Garnet();
                break;
            case 45:
                fragment = new TigersEye();
                break;
            case 46:
                fragment = new Feroja2();
                break;
            case 47:
                fragment = new GreenGarnet();
                break;
            case 48:
                fragment = new WhiteCoral();
                break;
            case 49:
                fragment = new WhiteQuartz();
                break;
            case 50:
                fragment = new WhiteRainbow();
                break;
            case 51:
                fragment = new WhiteTopaz();
                break;
            case 52:
                fragment = new Zircon();
                break;
        }
        if(fragment!=null){
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.gems_container, fragment).commit();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        parent.setSelection(0);
    }
}
