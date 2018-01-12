package tech.iosd.gemselections.JewelleryAlpha.GemStudded;

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

public class GemStuddedTops extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VictorianAdapter adapter;
    private List<Victorian> victorianList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gemstuddedtops);

        recyclerView = (RecyclerView)findViewById(R.id.gemstuddedtopsrecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(GemStuddedTops.this));
        set_data();
    }

    private void set_data() {

//        String temp = "GSE 5983";

        int temp = 5983000;

        StorageReference storageReference = FirebaseStorage.getInstance()
                .getReference("jewellery-images/gem-studded/earrings/");


        String[] product_code = new String[102];

        for(int i=0;i<102;i++){
            product_code[i] ="GSE " + String.valueOf(temp + (i+1));
        }

        victorianList = new ArrayList<>();

        for (int i=0; i<102;i+=3){
            Victorian vic = new Victorian("","","",product_code[i],product_code[i+1],product_code[i+2]);
            victorianList.add(vic);
        }
        adapter = new VictorianAdapter(GemStuddedTops.this, victorianList,storageReference);

        recyclerView.setAdapter(adapter);

    }



}
