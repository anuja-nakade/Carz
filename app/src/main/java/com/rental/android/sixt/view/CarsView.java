package com.rental.android.sixt.view;

import com.google.android.gms.maps.model.Marker;
import com.rental.android.sixt.models.CarDetailsResponse;
import com.rental.android.sixt.models.MarkerData;

import java.util.ArrayList;

/**
 * Created by Anuja on 8/30/17.
 */

public interface CarsView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getCarsList(ArrayList<CarDetailsResponse> carDetailsResponse);

    void getMarker(ArrayList<CarDetailsResponse> carDetailsResponse);
}
