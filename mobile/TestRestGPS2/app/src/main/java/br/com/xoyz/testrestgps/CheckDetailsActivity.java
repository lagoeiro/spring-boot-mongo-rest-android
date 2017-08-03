package br.com.xoyz.testrestgps;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import br.com.xoyz.testrestgps.entity.Check;
import br.com.xoyz.testrestgps.gps.GPSTracker;
import br.com.xoyz.testrestgps.rest.ChekInOutController;

public class CheckDetailsActivity extends AppCompatActivity   implements OnMapReadyCallback {

    private Check check;
    private GoogleMap mMap;
    private TextView tvVenueName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       check = (Check) getIntent().getSerializableExtra(MainActivity.CHECK);
        if(check!=null){
            TextView tvDeviceModel = (TextView) findViewById(R.id.tvDeviceModel);
            TextView tvApplications = (TextView) findViewById(R.id.tvApplications);
            tvVenueName = (TextView) findViewById(R.id.tvLastVisitVenueName);
            TextView tvPeriod = (TextView) findViewById(R.id.tvLastVisitPeriod);
            TextView tvDuration = (TextView) findViewById(R.id.tvLastVisitDuration);

            tvDeviceModel.setText(check.getDeviceModel() + " (" + check.getDeviceId() + ") - " + check.getOs() + " " + check.getOsVersion());
            if(check.getIstInstalledApps()!=null &&  !"null".equals(check.getIstInstalledApps())) {
                tvApplications.setText(check.getIstInstalledApps().replaceAll("\\|", ", "));
            }
            if(check.getVenueName()!=null && !"null".equals(check.getVenueName())){
                tvVenueName.setText(check.getVenueName());
            }else{
                tvVenueName.setText("-");
            }
            if(check.getArrival()!=null){
                tvPeriod.setText(check.getArrival() + (check.getDeparture()!=null? " / "+ check.getDeparture(): "") );
                tvDuration.setText(check.getVenueTotalTime() + " " + getResources().getString(R.string.minutes)) ;

            }
        }

       SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map3);
        mapFragment.getMapAsync(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        final ChekInOutController chekInOutController = new ChekInOutController();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_checkin) {
            final GPSTracker gpsTracker = new GPSTracker(this);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle( getResources().getString(R.string.hint_text_venue));
            // I'm using fragment here so I'm using getView() to provide ViewGroup
            // but you can provide here any other instance of ViewGroup from your Fragment / Activity
            View viewInflated = LayoutInflater.from(this).inflate(R.layout.dialog_input_text, null, false);
            // Set up the input
            final EditText input = (EditText) viewInflated.findViewById(R.id.input);
            // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            builder.setView(viewInflated);
            // Set up the buttons
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    final String location =  gpsTracker.getLongitude() + " " + gpsTracker.getLatitude();
                    String venue = input.getText().toString();
                    chekInOutController.checkin(location, venue, check);
                    check.setVenueLngLat(location);
                    check.setVenueName(venue);
                    if(tvVenueName!=null){
                        tvVenueName.setText(venue);
                    }
                    dialog.dismiss();
                }
            });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
            return true;
        }else if (id==R.id.action_checkout){
            chekInOutController.checkout(check);
            return true;
        }

        return super.onOptionsItemSelected(item);
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

        if (check != null) {
             LatLngBounds.Builder b = new LatLngBounds.Builder();
            if (check.getWork() != null) {
                double[] coordinates = convertCoordinates(check.getWork());
                if (coordinates != null) {
                    b.include(new LatLng(coordinates[0], coordinates[1]));
                    mMap.addMarker(new MarkerOptions().position(new LatLng(coordinates[0], coordinates[1])).title("Work").snippet("Work").icon(BitmapDescriptorFactory.fromResource(android.R.drawable.ic_menu_compass)));
                }
            }

            if (check.getWork() != null) {
                double[] coordinates = convertCoordinates(check.getHome());
                if (coordinates != null) {
                    b.include(new LatLng(coordinates[0], coordinates[1]));
                    mMap.addMarker(new MarkerOptions().position(new LatLng(coordinates[0], coordinates[1])).title("Home").snippet("Home").icon(BitmapDescriptorFactory.fromResource(android.R.drawable.ic_dialog_map)));
                }
            }

            if (check.getVenueLngLat() != null) {
                double[] coordinates = convertCoordinates(check.getVenueLngLat());
                if (coordinates != null) {
                    b.include(new LatLng(coordinates[0], coordinates[1]));
                    mMap.addMarker(new MarkerOptions().position(new LatLng(coordinates[0], coordinates[1])).title("Last Visit").snippet("Last Visit").icon(BitmapDescriptorFactory.fromResource(android.R.drawable.ic_menu_mylocation)));
                }
            }
            LatLngBounds bounds = b.build();
            //Change the padding as per needed
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, 200,200, 1);
            mMap.animateCamera(cameraUpdate);

            mMap.getUiSettings().setCompassEnabled(true);
            mMap.getUiSettings().setZoomControlsEnabled(true);
        }
    }

    /**
     * Return a double array from string lat-long spaced
     * @latLng String with latitude and longitude splitted by space
     * @return a double array
     */
    private double[] convertCoordinates(String latLngJoined ){
        String[] latLng = latLngJoined.split(" ");
        if(latLng.length !=2){
            return null;
        }
        double[] coordinates = new double[] {Double.parseDouble(latLng[1]), Double.parseDouble(latLng[0])};
        return coordinates;

    }
}
