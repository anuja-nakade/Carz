package com.rental.android.sixt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rental.android.sixt.component.CarsComponent;
import com.rental.android.sixt.component.DaggerCarsComponent;
import com.rental.android.sixt.networking.NetworkModule;

import java.io.File;

/**
 * Created by Anuja on 8/30/17.
 */

public class CarsBaseApplication extends AppCompatActivity {
    CarsComponent carsComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  File cacheFile = new File(getCacheDir(), "responses");
        carsComponent = DaggerCarsComponent.builder().networkModule(new NetworkModule()).build();

    }

    public CarsComponent getCarsComponent() {
        return carsComponent;
    }
}
