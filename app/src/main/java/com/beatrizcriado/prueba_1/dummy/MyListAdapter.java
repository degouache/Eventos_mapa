package com.beatrizcriado.prueba_1.dummy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.beatrizcriado.prueba_1.R;

import java.util.List;

public class MyListAdapter extends ArrayAdapter {
    TextView title, place, dateDay, dateTime;
    Context context;
    int itemLayout;
    List<ItemEventInfo> list;


    public MyListAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        itemLayout = resource;
        list = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(itemLayout, parent, false);

        }
        title = convertView.findViewById(R.id.title);
        title.setText(list.get(position).title);
        place = convertView.findViewById(R.id.place);
        place.setText(list.get(position).place);
        dateDay = convertView.findViewById(R.id.dateDay);
        dateDay.setText(list.get(position).dateAsString());
        dateTime = convertView.findViewById(R.id.dateTime);
        dateTime.setText(list.get(position).timeAsString());
        return convertView;

    }
}