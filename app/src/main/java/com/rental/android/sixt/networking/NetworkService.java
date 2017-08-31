package com.rental.android.sixt.networking;

import com.rental.android.sixt.models.CarDetailsResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Anuja on 8/30/17.
 */

public interface NetworkService {
    @GET("cars.json")
    Observable<ArrayList<CarDetailsResponse>> getCarsList();
}

