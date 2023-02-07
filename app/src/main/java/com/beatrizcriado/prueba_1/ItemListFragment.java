package com.beatrizcriado.prueba_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.beatrizcriado.prueba_1.dummy.MyListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ItemListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    public ItemListFragment() {
    }

    FloatingActionButton addButton;
    ListView list;
    MainActivity mainActivity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        mainActivity = (MainActivity) getActivity();
        addButton = view.findViewById(R.id.addButton);
        list = view.findViewById(R.id.list);
        addButton.setOnClickListener(v -> addEvent());

        list.setAdapter(new MyListAdapter(mainActivity, R.layout.item, mainActivity.itemList));
        list.setOnItemClickListener((parent, view1, position, id) -> mainActivity.showMap(position));




        return view;

    }

    public void addEvent() {
        mainActivity.showFragmentAddEvent();

    }

}


