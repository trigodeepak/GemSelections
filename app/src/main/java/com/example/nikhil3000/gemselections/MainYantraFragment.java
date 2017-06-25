package com.example.nikhil3000.gemselections;

import android.app.Dialog;
import android.graphics.BitmapFactory;
import android.media.Image;
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
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 24/6/17.
 */

public class MainYantraFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private String[] FramedArray = {
            "------ NONE ------",
            "SHRI. SURYA YANTRA ",
            "SHRI. CHANDRA YANTRA ",
            "SHRI. MANGAL YANTRA",
            "SHRI. BUDH YANTRA ",
            "SHRI. GURU YANTRA",
            "SHRI. SHUKRA YANTRA",
            "SHRI. SHANI YANTRA",
            "SHRI. RAHU YANTRA",
            "SHRI. KETU YANTRA",
            "SHRI. BAGALA MUKHI YANTRA",
            "SHRI. VASTU DOSH YANTRA",
            "SHRI. KUBER YANTRA",
            "SHRI. NAVGRAH YANTRA",
            "SHRI. SHRI YANTRA",
            "SHRI. MAHAMRITYUNJAY YANTRA",
            "SHRI. MAHALAXMI YANTRA",
            "SHRI. SARASWATI YANTRA",
            "SHRI. KALSARP YANTRA",
            "SHRI. DURGA BEESA YANTRA",
            "SHRI. DURGA AMBAJI YANTRA",
            "SHRI. GANPATI YANTRA",
            "SHRI. GAYATRI YANTRA",
            "SHRI. HANUMAN YANTRA",
            "SHRI. MAHAKALI YANTRA",
            "SHRI. NAV YANTRA",
            "SHRI. SANTAN GOPAL YANTRA"
    };

    private String[] LocketArray = {
            "---- NONE ----",
            "BUDH YANTRA",
            "LAXMI YANTRA",
            "SHUKRA YANTRA",
            "SHANI YANTRA",
            "CHANDRA YANTRA",
            "VASTUDOSH NIVARAN YANTRA",
            "GURU YANTRA",
            "VYAPAR VRIDDHI YANTRA",
            "SARV MANOKAMNA PRAPTI YANTRA",
            "MANGAL YANTRA",
            "KETU YANTRA",
            "RAHU YANTRA",
            "SURYA YANTRA",
            "YAKSHA KUBER YANTRA"
    };

    private String[] DaanArray = {
            "---- NONE ----",
            "RAHU DAN YANTRA",
            "KETU DAN YANTRA",
            "SHANI DAN YANTRA",
            "MANGAL DAN YANTRA",
            "CHANDRA DAN YANTRA"
    };

    private Spinner _framed, _locket, _daan;
    private ArrayAdapter<String> aa1, aa2, aa3;
    private ImageView banner;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.frag_main_yantra, container, false);

        banner = (ImageView)view.findViewById(R.id.yantra_banner);
        InputStream is;
        try{
            is = getActivity().getAssets().open("");
            banner.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }

        _framed = (Spinner)view.findViewById(R.id.framed_yantra_spinner);
        _locket = (Spinner)view.findViewById(R.id.locket_yantra_spinner);
        _daan = (Spinner)view.findViewById(R.id.daan_yantra_spinner);

        aa1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, FramedArray);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _framed.setAdapter(aa1);

        aa2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, LocketArray);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _locket.setAdapter(aa2);

        aa3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, DaanArray);
        aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _daan.setAdapter(aa3);

        _framed.setOnItemSelectedListener(this);
        _daan.setOnItemSelectedListener(this);
        _locket.setOnItemSelectedListener(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Yantra");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent == _framed){
            switch (position){
                case 0:
                    break;
                case 1:
                    show_dialog(FramedArray[1], R.string.framed1, "images/yantra/shri-surya-yantra.jpg");
                    break;
                case 2:
                    show_dialog(FramedArray[2], R.string.framed2, "images/yantra/shri-chandra-yantra.jpg");
                    break;
                case 3:
                    show_dialog(FramedArray[3], R.string.framed3, "images/yantra/shri-mangal-yantra.jpg");
                    break;
                case 4:
                    show_dialog(FramedArray[4], R.string.framed4, "images/yantra/shri-budh-yantra.jpg");
                    break;
                case 5:
                    show_dialog(FramedArray[5], R.string.framed5, "images/yantra/shri-guru-yantra.jpg");
                    break;
                case 6:
                    show_dialog(FramedArray[6], R.string.framed6, "images/yantra/shri-shukra-yantra.jpg");
                    break;
                case 7:
                    show_dialog(FramedArray[7], R.string.framed7, "images/yantra/shri-shani-yantra.jpg");
                    break;
                case 8:
                    show_dialog(FramedArray[8], R.string.framed8, "images/yantra/shri-rahu-yantra%20.jpg");
                    break;
                case 9:
                    show_dialog(FramedArray[9], R.string.framed9, "images/yantra/shri-ketu-yantra.jpg");
                    break;
                case 10:
                    show_dialog(FramedArray[10], R.string.framed10, "images/yantra/shri-bagla%20mukhi-yantra.jpg");
                    break;
                case 11:
                    show_dialog(FramedArray[11], R.string.framed11, "images/yantra/shri-vastu-dosh-nivaran-yantra.jpg");
                    break;
                case 12:
                    show_dialog(FramedArray[12], R.string.framed12, "images/yantra/shri-kuber-yantra.jpg");
                    break;
                case 13:
                    show_dialog(FramedArray[13], R.string.framed13, "images/yantra/shri-navgrah-yantra.jpg");
                    break;
                case 14:
                    show_dialog(FramedArray[14], R.string.framed14, "images/yantra/shri-shri-yantram.jpg");
                    break;
                case 15:
                    show_dialog(FramedArray[15], R.string.framed15, "images/yantra/mahamrityunjay.jpg");
                    break;
                case 16:
                    show_dialog(FramedArray[16], R.string.framed16, "images/yantra/mahalaxmi-yantra.jpg");
                    break;
                case 17:
                    show_dialog(FramedArray[17], R.string.framed17, "images/yantra/sri-saraswati-yantra.jpg");
                    break;
                case 18:
                    show_dialog(FramedArray[18], R.string.framed18, "images/yantra/kaal-sarp-yog-yantra.jpg");
                    break;
                case 19:
                    show_dialog(FramedArray[19], R.string.framed19, "images/yantra/durga-beesa-yantra.jpg");
                    break;
                case 20:
                    show_dialog(FramedArray[20], R.string.framed20, "images/yantra/sri-durga-ambaji-yantra.jpg");
                    break;
                case 21:
                    show_dialog(FramedArray[21], R.string.framed21, "images/yantra/ganesh-siddhi-yantra.jpg");
                    break;
                case 22:
                    show_dialog(FramedArray[22], R.string.framed22, "images/yantra/gayatri-yantra.jpg");
                    break;
                case 23:
                    show_dialog(FramedArray[23], R.string.framed23, "images/yantra/sri-hanumat-pujan-yantra.jpg");
                    break;
                case 24:
                    show_dialog(FramedArray[24], R.string.framed24, "images/yantra/maha-kali-yantra.jpg");
                    break;
                case 25:
                    show_dialog(FramedArray[25], R.string.framed25, "images/yantra/sri-nava-durga-yantra.jpg");
                    break;
                case 26:
                    show_dialog(FramedArray[26], R.string.framed26, "images/yantra/santan-gopal-yantra.JPG");
                    break;
            }
        }

        if(parent == _locket){
            switch (position){
                case 0:
                    break;
                case 1:
                    show_dialog(LocketArray[1], R.string.locket1, "images/locket-yantra/budh-yantra.jpg");
                    break;
                case 2:
                    show_dialog(LocketArray[2], R.string.locket2, "images/locket-yantra/shri-laxmi-yantra.jpg");
                    break;
                case 3:
                    show_dialog(LocketArray[3], R.string.locket3, "");
                    break;
                case 4:
                    show_dialog(LocketArray[4], R.string.locket4, "images/locket-yantra/shri-shani-yantra.jpg");
                    break;
                case 5:
                    show_dialog(LocketArray[5], R.string.locket5, "images/locket-yantra/chandra-yatra.jpg");
                    break;
                case 6:
                    show_dialog(LocketArray[6], R.string.locket6, "images/locket-yantra/shri-vastu-dosh-yantra.jpg");
                    break;
                case 7:
                    show_dialog(LocketArray[7], R.string.locket7, "images/locket-yantra/shri-guru-yantra.jpg");
                    break;
                case 8:
                    show_dialog(LocketArray[8], R.string.locket8, "images/locket-yantra/vyapar-vridhi-yantra.jpg");
                    break;
                case 9:
                    show_dialog(LocketArray[9], R.string.locket9, "images/locket-yantra/sarvmanokamana-prapti-yantra.jpg");
                    break;
                case 10:
                    show_dialog(LocketArray[10], R.string.locket10, "images/locket-yantra/shri-mangal-yantra.jpg");
                    break;
                case 11:
                    show_dialog(LocketArray[11], R.string.locket11, "images/locket-yantra/ketu-yantra.jpg");
                    break;
                case 12:
                    show_dialog(LocketArray[12], R.string.locket12, "images/locket-yantra/shri-rahu-yantra.jpg");
                    break;
                case 13:
                    show_dialog(LocketArray[13], R.string.locket13, "images/locket-yantra/shri-surya-yantra.jpg");
                    break;
                case 14:
                    show_dialog(LocketArray[14], R.string.locket14, "images/locket-yantra/shri-kuber-yantra.jpg");
                    break;
            }
        }

        if(parent == _daan){
            switch (position){
                case 0:
                    break;
                case 1:
                    show_dialog(DaanArray[1], R.string.daan1, "images/daan-yantra/rahu-daan-yantra.jpg");
                    break;
                case 2:
                    show_dialog(DaanArray[2], R.string.daan2, "images/daan-yantra/ketu-daan-yantra.jpg");
                    break;
                case 3:
                    show_dialog(DaanArray[3], R.string.daan3, "images/daan-yantra/shani-daan-yantra.jpg");
                    break;
                case 4:
                    show_dialog(DaanArray[4], R.string.daan4, "images/daan-yantra/mangal-daan-yantra.jpg");
                    break;
                case 5:
                    show_dialog(DaanArray[5], R.string.daan5, "images/daan-yantra/chandra-daan%20yantra.jpg");
                    break;
            }
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
