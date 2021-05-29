package com.ganny.imglibd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private final String android_image_urls[] = {
            "https://gamedata.britishcouncil.org/sites/default/files/attachment/number-1_1.jpg",
            "https://gamedata.britishcouncil.org/sites/default/files/attachment/number-2_1.jpg",
            "https://gamedata.britishcouncil.org/sites/default/files/attachment/number-3_1.jpg",
            "https://gamedata.britishcouncil.org/sites/default/files/attachment/number-4_1.jpg",
            "https://gamedata.britishcouncil.org/sites/default/files/attachment/number-5_1.jpg",
            "https://gamedata.britishcouncil.org/sites/default/files/attachment/number-6_1.jpg",
            "https://gamedata.britishcouncil.org/sites/default/files/attachment/number-7_0.jpg",
            "https://gamedata.britishcouncil.org/sites/default/files/attachment/number-8_1.jpg",
            "https://gamedata.britishcouncil.org/sites/default/files/attachment/number-9_1.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList androidVersions = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(),androidVersions);
        recyclerView.setAdapter(adapter);

    }
    private ArrayList prepareData(){

        ArrayList android_version = new ArrayList<>();
        for(int i=0;i<android_image_urls.length;i++){
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }
}