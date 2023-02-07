package com.beatrizcriado.prueba_1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.beatrizcriado.prueba_1.dummy.AddEventFragment;
import com.beatrizcriado.prueba_1.dummy.ItemEventInfo;
import com.beatrizcriado.prueba_1.dummy.MapsFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ItemListFragment fragmentList;
    AddEventFragment fragmentAddEvent;
    Toolbar toolbar;
    public ArrayList<ItemEventInfo> itemList;
    MapsFragment mapsFragment;
    public int position;
    ImageView unicorn;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //List
        itemList = new ArrayList<>();
        fragmentList = new ItemListFragment();
        fragmentAddEvent = new AddEventFragment();

        toolbar = findViewById(R.id.toolbarComponent);
        setSupportActionBar(toolbar);
        unicorn = findViewById(R.id.unicorn);


        //contenedor de fragments
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameBase, fragmentList)
                .commit();

    }

    public void showFragmentAddEvent() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameBase, new AddEventFragment(), "new event fragment")
                .addToBackStack(null)
                .commit();

    }

    public void deleteFragmentAddEvent(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameBase, fragmentList, "delete event fragment")
                .addToBackStack(null)
                .commit();
    }

    public void addItemToList(ItemEventInfo itemEventInfo) {
        unicorn.setVisibility(View.GONE);
        deleteFragmentAddEvent(null);
        itemList.add(itemEventInfo);

    }

    public void showMap(int position) {
        this.position = position;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameBase, new MapaBaseFragment(), "open map fragment")
                .addToBackStack(null)
                .commit();

    }

}



