package com.example.googlemaps;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    boolean permissionGranted = false;
    FusedLocationProviderClient fusedLocationProviderClient;
    Location currentLocation;
    LatLng canWonderland = new LatLng(43.842512793822486, -79.54155882274044);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        supportMapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        gMap = googleMap;

        //        LatLng seneca = new LatLng(43.77639279942306, -79.49951649307177);
//        LatLng newPosition = new LatLng(43.77639279942306, -79.49951649307177);
//        gMap.addMarker(new MarkerOptions().position(seneca).title("Seneca"));
//        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seneca, 16));

//        Marker marker = gMap.addMarker(new MarkerOptions().position(newPosition));
//        marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));

        getLocationPermissions();
        getCurrentLocation();

    }

    void getLocationPermissions()
    {
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            permissionGranted = true;
        }
        else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1234);
        }

        MarkerOptions markerOptions = new MarkerOptions().position(canWonderland).title("Canada's Wonderland").snippet("Theme park");
       Marker marker = gMap.addMarker(markerOptions) ;
       gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(canWonderland, 16));
       gMap.setInfoWindowAdapter(new WonderInfoWinderAdapter());
    }

    void getCurrentLocation()
    {
        if (permissionGranted)
        {
            @SuppressLint("MissingPermission") Task<Location> location = fusedLocationProviderClient.getLastLocation();
            location.addOnCompleteListener(this, new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    if (task.isSuccessful())
                    {
                        currentLocation = task.getResult();

                        if (currentLocation != null)
                        {
                            gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()), 16));
                            gMap.addMarker(new MarkerOptions().position(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude())));
                        }
                    }
                }
            });
        }
    }

    private class WonderInfoWinderAdapter implements GoogleMap.InfoWindowAdapter {
        private View gWindow;

        WonderInfoWinderAdapter() {
            gWindow = getLayoutInflater().inflate(R.layout.wonderland_info_window, null);
        }

        private void render(Marker marker, View view) {
            ImageView imageView = view.findViewById(R.id.infoImgView);
            TextView titleWindow = view.findViewById(R.id.titleTxtView);
            TextView descriptionWindow = view.findViewById(R.id.descriptionTxtView);
            TextView addressWindow = view.findViewById(R.id.addressTxtView);
        }

        @Nullable
        @Override
        public View getInfoContents(@NonNull Marker marker) {
            return gWindow ;
        }

        @Nullable
        @Override
        public View getInfoWindow(@NonNull Marker marker) {
            return null ;
        }
    }
}