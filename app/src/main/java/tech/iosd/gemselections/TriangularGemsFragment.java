package tech.iosd.gemselections;

import android.app.Dialog;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 26/6/17.
 */

public class TriangularGemsFragment extends Fragment implements View.OnClickListener {

    private ImageView _1, _2, _3, _4, _5, _6, _7, _8;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(tech.iosd.gemselections.R.layout.frag_triangular_gems, container, false);
        _1 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.triangular1);     _1.setOnClickListener(this);
        _2 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.triangular2);     _2.setOnClickListener(this);
        _3 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.triangular3);     _3.setOnClickListener(this);
        _4 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.triangular4);     _4.setOnClickListener(this);
        _5 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.triangular5);     _5.setOnClickListener(this);
        _6 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.triangular6);     _6.setOnClickListener(this);
        _7 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.triangular7);     _7.setOnClickListener(this);
        _8 = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.triangular8);     _8.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        load_images();
        getActivity().setTitle("Triangular Gemstones");
    }

    private void load_images() {
        InputStream is;
        try{
            is = getActivity().getAssets().open("images/Triangular-Golden-Topaz.jpg");
            _1.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/Triangular-Lemon-Topaz.jpg");
            _2.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/Triangular-Green-Amethyst.jpg");
            _3.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/Triangular-rose-quartz.jpg");
            _4.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/Triangular-green-fluorite.jpg");
            _5.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/Triangular-Smoky-Topaz.jpg");
            _6.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/Triangular-Green-Onyx.jpg");
            _7.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/Triangular-White-Quartz.jpg");
            _8.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }
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

    @Override
    public void onClick(View v) {
        if(v==_1){
            show_dialog("Golden Topaz(Triangular)", tech.iosd.gemselections.R.string.triangular3);
        }
        if(v==_2){
            show_dialog("Lemon Topaz(Triangular)", tech.iosd.gemselections.R.string.triangular4);
        }
        if(v==_3){
            show_dialog("Green Amethyst(Triangular)", tech.iosd.gemselections.R.string.triangular5);
        }
        if(v==_4){
            show_dialog("Rose Quartz(Triangular)", tech.iosd.gemselections.R.string.triangular6);
        }
        if(v==_5){
            show_dialog("Green Fluorite(Triangular)", tech.iosd.gemselections.R.string.triangular7);
        }
        if(v==_6){
            show_dialog("Smoky Topaz(Triangular)", tech.iosd.gemselections.R.string.triangular8);
        }
        if(v==_7){
            show_dialog("Green Onyx(Triangular)", tech.iosd.gemselections.R.string.triangular9);
        }
        if(v==_8){
            show_dialog("White Quartz(Triangular)", tech.iosd.gemselections.R.string.triangular10);
        }
    }
}
