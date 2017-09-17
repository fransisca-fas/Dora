package map.fas.mapproject;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    PSIResponseModel responseModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        responseModel = new Gson().fromJson(Constants.json, PSIResponseModel.class);

        LatLngBounds.Builder boundBuilder = new LatLngBounds.Builder();
        for (PSIResponseModel.Region_metadata region : responseModel.getRegion_metadata()) {
            // Add a marker
            if (region.getLabel_location().getLatitude() == 0 && region.getLabel_location().getLongitude() == 0) {
                continue;
            }
            LatLng regionCoordinate = new LatLng(region.getLabel_location().getLatitude(), region.getLabel_location().getLongitude());
            mMap.addMarker(new MarkerOptions().position(regionCoordinate).title(region.getName()));

            boundBuilder.include(regionCoordinate);
        }

        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        int padding = (int) (getResources().getDisplayMetrics().widthPixels * 0.10);
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(boundBuilder.build(), width, height,  padding));
    }
}
