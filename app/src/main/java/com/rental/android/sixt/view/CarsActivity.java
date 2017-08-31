package com.rental.android.sixt.view;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rental.android.sixt.CarsBaseApplication;
import com.rental.android.sixt.R;
import com.rental.android.sixt.models.CarDetailsResponse;
import com.rental.android.sixt.models.MarkerData;
import com.rental.android.sixt.networking.Service;

import java.util.ArrayList;

import javax.inject.Inject;

public class CarsActivity extends CarsBaseApplication implements CarsView {

    private RecyclerView list;
    private FloatingActionButton maps;
    @Inject
    public Service service;
    private ProgressBar progressBar;
    private ArrayList<MarkerData> mMarkerDataArrayList;
    private ImageView retry;
    private TextView networkError;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCarsComponent().inject(this);
        renderView();
        init();
        CarsPresenter presenter = new CarsPresenter(service, this);
        presenter.getCarsList();
    }

    public void renderView() {
        setContentView(R.layout.activity_cars);
        list = (RecyclerView) findViewById(R.id.listCars);
        progressBar = (ProgressBar) findViewById(R.id.progressListCars);
        maps = (FloatingActionButton) findViewById(R.id.maps);
        retry = (ImageView) findViewById(R.id.retry);
        networkError = (TextView) findViewById(R.id.showError);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retry.setVisibility(View.GONE);
                networkError.setVisibility(View.GONE);
                CarsPresenter presenter = new CarsPresenter(service, CarsActivity.this);
                presenter.getCarsList();
            }
        });

        maps.setVisibility(View.GONE);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CarsActivity.this, MapActivity.class);
                intent.putExtra("markerData", mMarkerDataArrayList);
                startActivity(intent);
            }
        });
    }

    public void init() {
        list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        networkError.setVisibility(View.GONE);
        retry.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {
        networkError.setVisibility(View.VISIBLE);
        retry.setVisibility(View.VISIBLE);
    }

    @Override
    public void getCarsList(ArrayList<CarDetailsResponse> carDetailsResponse) {
        CarsAdapter adapter = new CarsAdapter(getApplicationContext(), carDetailsResponse,
                new CarsAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(CarDetailsResponse Item) {
                      /*  Toast.makeText(getApplicationContext(), Item.getName(),
                                Toast.LENGTH_LONG).show();*/
                    }
                });

        list.setAdapter(adapter);
    }

    @Override
    public void getMarker(ArrayList<CarDetailsResponse> carDetailsResponse) {
        ArrayList<MarkerData> markerData = new ArrayList<>();
        for (int i = 0; i < carDetailsResponse.size(); i++) {
            markerData.add(new MarkerData(carDetailsResponse.get(i).getLatitude(), carDetailsResponse.get(i).getLongitude()));
        }
        mMarkerDataArrayList = markerData;
        maps.setVisibility(View.VISIBLE);

    }


}
