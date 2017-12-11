package tech.iosd.gemselections.MainContent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;

import tech.iosd.gemselections.SemiPreciousGems.AmethystFragment;
import tech.iosd.gemselections.SemiPreciousGems.AquamarineFragment;
import tech.iosd.gemselections.SemiPreciousGems.BlackOnyxCut;
import tech.iosd.gemselections.SemiPreciousGems.BlackRainbow;
import tech.iosd.gemselections.SemiPreciousGems.BlackStar;
import tech.iosd.gemselections.SemiPreciousGems.BlueTopaz;
import tech.iosd.gemselections.SemiPreciousGems.Chandramani;
import tech.iosd.gemselections.SemiPreciousGems.Citrine;
import tech.iosd.gemselections.SemiPreciousGems.Dhunela;
import tech.iosd.gemselections.SemiPreciousGems.Feroja;
import tech.iosd.gemselections.SemiPreciousGems.Feroja2;
import tech.iosd.gemselections.SemiPreciousGems.Garnet;
import tech.iosd.gemselections.SemiPreciousGems.GoldenTopaz;
import tech.iosd.gemselections.SemiPreciousGems.GreenAmethyst;
import tech.iosd.gemselections.SemiPreciousGems.GreenFluorite;
import tech.iosd.gemselections.SemiPreciousGems.GreenGarnet;
import tech.iosd.gemselections.SemiPreciousGems.GreenOnyx;
import tech.iosd.gemselections.SemiPreciousGems.GreenTourmaline;
import tech.iosd.gemselections.SemiPreciousGems.Iolite;
import tech.iosd.gemselections.SemiPreciousGems.Jade;
import tech.iosd.gemselections.SemiPreciousGems.Kyanite;
import tech.iosd.gemselections.SemiPreciousGems.Labradorite;
import tech.iosd.gemselections.SemiPreciousGems.Lajwrat;
import tech.iosd.gemselections.SemiPreciousGems.Malachite;
import tech.iosd.gemselections.SemiPreciousGems.Maryam;
import tech.iosd.gemselections.SemiPreciousGems.Opal;
import tech.iosd.gemselections.SemiPreciousGems.Peridot;
import tech.iosd.gemselections.SemiPreciousGems.PinkTourmaline;
import tech.iosd.gemselections.SemiPreciousGems.RedOnyxCabochon;
import tech.iosd.gemselections.SemiPreciousGems.RedOnyxCut;
import tech.iosd.gemselections.SemiPreciousGems.RhodoliteGarnet;
import tech.iosd.gemselections.SemiPreciousGems.StarRuby;
import tech.iosd.gemselections.SemiPreciousGems.WhiteCoral;
import tech.iosd.gemselections.SemiPreciousGems.WhiteQuartz;
import tech.iosd.gemselections.SemiPreciousGems.WhiteRainbow;
import tech.iosd.gemselections.SemiPreciousGems.WhiteTopaz;
import tech.iosd.gemselections.SemiPreciousGems.Zircon;
import tech.iosd.gemselections.SemiPreciousGems.Beruj;
import tech.iosd.gemselections.SemiPreciousGems.BlackOnyxCabochon;
import tech.iosd.gemselections.SemiPreciousGems.LemonTopaz;
import tech.iosd.gemselections.SemiPreciousGems.RoseQuartz;
import tech.iosd.gemselections.SemiPreciousGems.TigersEye;

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
        View view = inflater.inflate(tech.iosd.gemselections.R.layout.frag_semi_precious_gems, container, false);

        ScrollView scrollView = (ScrollView)view.findViewById(tech.iosd.gemselections.R.id.scroll);
        scrollView.setBackground(getResources().getDrawable(tech.iosd.gemselections.R.drawable.back));

        spinner = (Spinner)view.findViewById(tech.iosd.gemselections.R.id.gemstone_spinner);
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
                    .replace(tech.iosd.gemselections.R.id.gems_container, fragment).commit();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        parent.setSelection(0);
    }
}
