package com.example.nikhil3000.gemselections.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikhil3000.gemselections.Lists.ConnectOptions;
import com.example.nikhil3000.gemselections.R;
import com.example.nikhil3000.gemselections.WebViewActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by anonymous on 8/7/17.
 */

public class ConnectAdapter extends RecyclerView.Adapter<ConnectAdapter.ViewHolder> {

    private List<ConnectOptions> list;
    private Context context;

    public ConnectAdapter(List<ConnectOptions> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.connect_item, parent, false);
        return new ViewHolder(view);
    }

    private Bitmap load_icon(String url){
        InputStream is = null;
        try {
            is = context.getAssets().open(url);
        }catch (IOException e){
            e.printStackTrace();
        }
        return BitmapFactory.decodeStream(is);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.text.setText(list.get(position).getText());
        holder.img.setImageBitmap(load_icon(list.get(position).getUrl()));
        holder.linearLayout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(position!=6){
                            open_link(list.get(position).getLink());
                        }
                        else {
                            new AlertDialog.Builder(context)
                                    .setTitle("Snapchat")
                                    .setMessage("Find Us On Snapchat as \'gemselections\'")
                                    .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .create().show();
                        }
                    }
                }
        );
    }

    private void open_link(String link) {
        context.startActivity(new Intent(context, WebViewActivity.class)
                                .putExtra("URL",link)
                                .putExtra("parent","MainActivity"));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView text;
        private LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.logo);
            text = (TextView)itemView.findViewById(R.id.logo_text);
            linearLayout = (LinearLayout)itemView.findViewById(R.id._connect_item);
        }
    }
}
