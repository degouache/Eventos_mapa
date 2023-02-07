package com.beatrizcriado.prueba_1.dummy;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.beatrizcriado.prueba_1.MainActivity;
import com.beatrizcriado.prueba_1.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsFragment extends Fragment {

    GoogleMap map;
    MainActivity mainActivity;



    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            String place = mainActivity.itemList.get(mainActivity.position).place;
            Geocoder geocoder = new Geocoder(getContext());
            try {
                List<Address> places = geocoder.getFromLocationName(place, 1);
                if (places.size() != 0) {
                    Address adress = places.get(0);
                    LatLng placeLatLng = new LatLng(adress.getLatitude(), adress.getLongitude());
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(placeLatLng));
                    googleMap.moveCamera(CameraUpdateFactory.zoomTo(8));
                    googleMap.addMarker(new MarkerOptions().position(placeLatLng).title("Your Event"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        this.mainActivity = (MainActivity) getActivity();
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }

    }


}
