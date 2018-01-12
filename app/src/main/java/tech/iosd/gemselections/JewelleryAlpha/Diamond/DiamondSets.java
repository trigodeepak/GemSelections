package tech.iosd.gemselections.JewelleryAlpha.Diamond;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import tech.iosd.gemselections.Adapters.VictorianAdapter;
import tech.iosd.gemselections.DataProviders.Victorian;
import tech.iosd.gemselections.JewelleryAlpha.Victorian.VictorianActivity;
import tech.iosd.gemselections.R;

/**
 * Created by anonymous on 5/10/17.
 */

public class DiamondSets extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VictorianAdapter adapter;
    private List<Victorian> victorianList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamondsets);

        recyclerView = (RecyclerView)findViewById(R.id.diamondsetrecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(DiamondSets.this));
        set_data();
    }

    private void set_data() {

//        String temp = "DJS 7129";

        int temp = 7129000;

        StorageReference storageReference = FirebaseStorage.getInstance()
                .getReference("jewellery-images/diamond/set/");
        String[] product_code = new String[81];

        for(int i=0;i<81;i++){
            product_code[i] = "DJS " + String.valueOf(temp + (i+1));
        }

        victorianList = new ArrayList<>();

        for (int i=0; i<81;i+=3){
            Victorian vic = new Victorian("","","",product_code[i],product_code[i+1],product_code[i+2]);
            victorianList.add(vic);
        }
        adapter = new VictorianAdapter(DiamondSets.this, victorianList,storageReference);

        recyclerView.setAdapter(adapter);

    }
}
