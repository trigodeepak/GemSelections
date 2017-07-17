package tech.iosd.gemselections;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by anonymous on 22/6/17.
 */

public class MainBirthstoneFragment extends Fragment {

    private Spinner spinner;
    private ArrayAdapter<String> arrayAdapter;
    private String[] _zodiac ={
            "---None---",
            "Aries",
            "Taurus",
            "Gemini",
            "Cancer",
            "Leo",
            "Virgo",
            "Libra",
            "Scorpio",
            "Sagittarius",
            "Capricorn",
            "Aquarius",
            "Pisces"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(tech.iosd.gemselections.R.layout.frag_main_birthstone, container, false);
        spinner = (Spinner)view.findViewById(tech.iosd.gemselections.R.id.zodiac_spinner);

        ScrollView scrollView = (ScrollView)view.findViewById(tech.iosd.gemselections.R.id.scroll);
        scrollView.setBackground(getResources().getDrawable(tech.iosd.gemselections.R.drawable.back));

        arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, _zodiac);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        break;
                    case 1:
                        show_dialog(_zodiac[position], tech.iosd.gemselections.R.string.aries);
                        break;
                    case 2:
                        show_dialog(_zodiac[position], tech.iosd.gemselections.R.string.taurus);
                        break;
                    case 3:
                        show_dialog(_zodiac[position], tech.iosd.gemselections.R.string.gemini);
                        break;
                    case 4:
                        show_dialog(_zodiac[position], tech.iosd.gemselections.R.string.cancer);
                        break;
                    case 5:
                        show_dialog(_zodiac[position], tech.iosd.gemselections.R.string.leo);
                        break;
                    case 6:
                        show_dialog(_zodiac[position], tech.iosd.gemselections.R.string.virgo);
                        break;
                    case 7:
                        show_dialog(_zodiac[position], tech.iosd.gemselections.R.string.libra);
                        break;
                    case 8:
                        show_dialog(_zodiac[position], tech.iosd.gemselections.R.string.scorpio);
                        break;
                    case 9:
                        show_dialog(_zodiac[position], tech.iosd.gemselections.R.string.sagittarious);
                        break;
                    case 10:
                        show_dialog(_zodiac[position], tech.iosd.gemselections.R.string.capricorn);
                        break;
                    case 11:
                        show_dialog(_zodiac[position], tech.iosd.gemselections.R.string.aquarious);
                        break;
                    case 12:
                        show_dialog(_zodiac[position], tech.iosd.gemselections.R.string.pisces);
                        break;
                }
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
        getActivity().setTitle("Birthstones");
    }

    private void show_dialog(String title, int content) {
        Dialog dialog = new Dialog(getActivity());
        dialog.setTitle(title);
        dialog.setContentView(tech.iosd.gemselections.R.layout.dialog_bracelet);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());

        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);

        TextView textView  = (TextView)dialog.findViewById(tech.iosd.gemselections.R.id.content);
        textView.setText(getString(content));
    }
}
