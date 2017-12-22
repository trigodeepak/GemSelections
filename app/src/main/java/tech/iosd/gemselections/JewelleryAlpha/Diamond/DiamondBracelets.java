package tech.iosd.gemselections.JewelleryAlpha.Diamond;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import tech.iosd.gemselections.Adapters.VictorianAdapter;
import tech.iosd.gemselections.DataProviders.Victorian;
import tech.iosd.gemselections.R;

/**
 * Created by anonymous on 5/10/17.
 */

public class DiamondBracelets extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VictorianAdapter adapter;
    private List<Victorian> victorianList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamondbracelets);


        recyclerView = (RecyclerView)findViewById(R.id.diamondbraceletsrecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(DiamondBracelets.this));
        set_data();
    }

    private void set_data() {

//        String temp = "DB 980";
        StorageReference storageReference= FirebaseStorage.getInstance()
                .getReference("/jewellery-images/diamond/bracelet/");
        int temp= 98000;
        String[] product_code = new String[39];

        for(int i=0;i<39;i++){
            product_code[i] = "DB " + String.valueOf(temp + (i+1));
        }

        victorianList = new ArrayList<>();

        for (int i=0; i<39;i+=3){
            Victorian vic = new Victorian("","","",product_code[i],product_code[i+1],product_code[i+2]);
            victorianList.add(vic);
        }
        adapter = new VictorianAdapter(DiamondBracelets.this, victorianList,storageReference);

        recyclerView.setAdapter(adapter);

    }

}
