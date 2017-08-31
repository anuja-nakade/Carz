package com.rental.android.sixt.view;

import com.rental.android.sixt.models.CarDetailsResponse;
import com.rental.android.sixt.models.MarkerData;
import com.rental.android.sixt.networking.NetworkError;
import com.rental.android.sixt.networking.Service;

import java.util.ArrayList;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Anuja on 8/30/17.
 */

public class CarsPresenter {

    private final Service service;
    private final CarsView view;
    private CompositeSubscription subscriptions;
    private ArrayList<MarkerData> markerData;


    public CarsPresenter(Service service, CarsView view) {
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void getCarsList() {
        view.showWait();

        Subscription subscription = service.getCarsList(new Service.GetCarsListCallback() {
            @Override
            public void onSuccess(ArrayList<CarDetailsResponse> carDetailsResponse) {
                view.removeWait();
                view.getCarsList(carDetailsResponse);
                view.getMarker(carDetailsResponse);
            }

            @Override
            public void onError(NetworkError networkError) {
                view.removeWait();
                view.onFailure(networkError.getAppErrorMessage());
            }

        });

        subscriptions.add(subscription);
        return ;
    }


    public void onStop() {
        subscriptions.unsubscribe();
    }

}
