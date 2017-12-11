package tech.iosd.gemselections.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import tech.iosd.gemselections.DataProviders.JewelTypes;
import tech.iosd.gemselections.JewelleryAlpha.DesignOwn.DesignOwnActivity;
import tech.iosd.gemselections.JewelleryAlpha.Diamond.DiamondActivity;
import tech.iosd.gemselections.JewelleryAlpha.GemStudded.GemStuddedActivity;
import tech.iosd.gemselections.JewelleryAlpha.Silver.SilverActivity;
import tech.iosd.gemselections.JewelleryAlpha.Victorian.VictorianActivity;
import tech.iosd.gemselections.R;

/**
 * Created by anonymous on 19/8/17.
 */

public class JewelTypesAdapater extends RecyclerView.Adapter<JewelTypesAdapater.ViewHolder>{

    private Context context;
    private List<JewelTypes> typesList;

    public JewelTypesAdapater(Context context, List<JewelTypes> typesList) {
        this.context = context;
        this.typesList = typesList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.jeweltypes_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(typesList.get(position).getText());
        //holder.image.setImageBitmap();
        final int pos = position;
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (pos){
                    case 0:
                        context.startActivity(new Intent(
                                context, DesignOwnActivity.class
                        ));

                        break;

                    case 1:
                        context.startActivity(new Intent(
                                context, DiamondActivity.class
                        ));

                        break;

                    case 2:
                        context.startActivity(new Intent(
                                context, VictorianActivity.class
                        ));

                        break;

                    case 3:
                        context.startActivity(new Intent(
                                context, GemStuddedActivity.class
                        ));

                        break;

                    case 4:

                        Toast.makeText(context, "Under Development", Toast.LENGTH_SHORT).show();
/*
                        context.startActivity(new Intent(
                                context, SilverActivity.class
                        ));
*/
                        break;

                    default:
                        Log.e("Jewel Types","Wrong item clicked");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return typesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView text;
        private ImageView image;
        private LinearLayout linearLayout;

        public ViewHolder(View itemView) {

            super(itemView);

            text = (TextView)itemView.findViewById(R.id.jewel_sample_text);
            image = (ImageView)itemView.findViewById(R.id.jewel_sample);
            linearLayout = (LinearLayout)itemView.findViewById(R.id._jeweltype_item);
        }
    }
}
