package com.rental.android.sixt.component;

import com.rental.android.sixt.networking.NetworkModule;
import com.rental.android.sixt.view.CarsActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Anuja on 8/30/17.
 */

@Singleton
@Component(modules = {NetworkModule.class,})
public interface CarsComponent {
    void inject(CarsActivity carsActivity);

}
