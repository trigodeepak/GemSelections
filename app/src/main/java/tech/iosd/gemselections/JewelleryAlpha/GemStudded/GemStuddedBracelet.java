package tech.iosd.gemselections.JewelleryAlpha.GemStudded;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tech.iosd.gemselections.Adapters.VictorianAdapter;
import tech.iosd.gemselections.DataProviders.Victorian;
import tech.iosd.gemselections.JewelleryAlpha.Diamond.DiamondBracelets;
import tech.iosd.gemselections.R;

/**
 * Created by anonymous on 5/10/17.
 */

public class GemStuddedBracelet extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VictorianAdapter adapter;
    private List<Victorian> victorianList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gemstuddedbracelet);

        recyclerView = (RecyclerView)findViewById(R.id.gemstuddedbraceletrecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(GemStuddedBracelet.this));
        set_data();
    }

    private void set_data() {

        String temp = "GSB 4983";

        String[] product_code = new String[36];

        for(int i=0;i<36;i++){
            product_code[i] = temp + String.valueOf(i+1);
        }

        victorianList = new ArrayList<>();

        for (int i=0; i<36;i+=3){
            Victorian vic = new Victorian("","","",product_code[i],product_code[i+1],product_code[i+2]);
            victorianList.add(vic);
        }
        adapter = new VictorianAdapter(GemStuddedBracelet.this, victorianList);

        recyclerView.setAdapter(adapter);

    }


}
