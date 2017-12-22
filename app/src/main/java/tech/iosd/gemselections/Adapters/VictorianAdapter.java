package tech.iosd.gemselections.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.List;

import tech.iosd.gemselections.DataProviders.Victorian;
import tech.iosd.gemselections.R;

/**
 * Created by anonymous on 28/8/17.
 */

public class VictorianAdapter extends RecyclerView.Adapter<VictorianAdapter.ViewHolder> {


    StorageReference mStorageRef ;
    private Context context;
    private List<Victorian> victorianList;

    public VictorianAdapter(Context context, List<Victorian> victorianList , StorageReference mStorageRef) {
        this.context = context;
        this.victorianList = victorianList;
        this.mStorageRef = mStorageRef;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.jewellery_items, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        mStorageRef.child(victorianList.get(position).getCode1()+".png")
                .getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(context.getApplicationContext())
                        .load(uri.toString())
                        .centerCrop()
                        .into(holder.img1);
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                /*TODO: set progressbar visibility to gone*/
                    }
                });

        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prompt(victorianList.get(position).getCode1(), victorianList.get(position).getCode1());
            }
        });

        mStorageRef.child(victorianList.get(position).getCode2()+".png")
                .getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(context.getApplicationContext())
                        .load(uri.toString())
                        .centerCrop()
                        .into(holder.img1);
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                /*TODO: set progressbar visibility to gone*/
                    }
                });
        holder.img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prompt(victorianList.get(position).getUrl2(), victorianList.get(position).getCode2());
            }
        });

        mStorageRef.child(victorianList.get(position).getCode3()+".png")
                .getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(context.getApplicationContext())
                        .load(uri.toString())
                        .centerCrop()
                        .into(holder.img1);
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                /*TODO: set progressbar visibility to gone*/
                    }
                });

        holder.img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prompt(victorianList.get(position).getUrl3(), victorianList.get(position).getCode3());
            }
        });
    }

    private void prompt(String url, String code) {

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_order_layout);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.copyFrom(dialog.getWindow().getAttributes());

        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;

        dialog.getWindow().setAttributes(params);

        dialog.show();

        EditText _code = (EditText) dialog.findViewById(R.id.prompt_code);
        _code.setText(code);

        ImageView img = (ImageView) dialog.findViewById(R.id.prompt_image);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            img.setImageDrawable(context.getDrawable(R.drawable.ic_thankyou));
        }

        Button submit = (Button) dialog.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Request Sent Successfully", Toast.LENGTH_SHORT).show();
                dialog.dismiss();

                new AlertDialog.Builder(context)
                        .setMessage("Thank you for your interest. Gem Selections will send you the price quotation for the same on your email or phone within 1 working day.\n\n ©Khanna Gems Pvt. Ltd.")
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setIcon(R.drawable.ic_thankyou)
                        .setTitle("THANK YOU")
                        .create().show();
            }
        });


        /* LOAD IMAGE FROM URL HERE */


    }

    @Override
    public int getItemCount() {
        return victorianList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img1, img2, img3;

        public ViewHolder(View itemView) {
            super(itemView);
            img1 = (ImageView) itemView.findViewById(R.id.jewel_image);
            img2 = (ImageView) itemView.findViewById(R.id.jewel_image1);
            img3 = (ImageView) itemView.findViewById(R.id.jewel_image2);
        }
    }
}
