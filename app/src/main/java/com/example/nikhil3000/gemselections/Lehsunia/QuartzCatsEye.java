package com.example.nikhil3000.gemselections.Lehsunia;

import android.app.Dialog;
import android.app.Fragment;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nikhil3000.gemselections.Gomed.GomedActivity;
import com.example.nikhil3000.gemselections.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 29/6/17.
 */

public class QuartzCatsEye extends Fragment {

    private ImageView img;
    private Button btn1, btn2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_quartz_catseye, container, false);
        img = (ImageView)view.findViewById(R.id.img_quartz_catseye);
        try{
            InputStream is = getActivity().getAssets().open("images/precious-gems/gems/quartz-cats-eye.jpg");
            img.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }
        btn1 = (Button)view.findViewById(R.id.quartz_catseye1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_dialog("Quartz Cat's EYE : A", R.string.quartz_catseye1);
            }
        });
        btn2 = (Button)view.findViewById(R.id.quartz_catseye2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_dialog("Quartz Cat's EYE : B", R.string.quartz_catseye2);
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
