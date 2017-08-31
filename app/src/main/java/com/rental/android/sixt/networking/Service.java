package com.rental.android.sixt.networking;

import android.util.Log;

import com.rental.android.sixt.models.CarDetailsResponse;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Anuja on 8/30/17.
 */

public class Service {
    private final NetworkService networkService;

    public interface GetCarsListCallback {
        void onSuccess(ArrayList<CarDetailsResponse> cityListResponse);

        void onError(NetworkError networkError);
    }

    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription getCarsList(final GetCarsListCallback carsListCallback) {
        return networkService.getCarsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ArrayList<CarDetailsResponse>>>() {
                    @Override
                    public Observable<? extends ArrayList<CarDetailsResponse>> call(Throwable throwable) {
                        throwable.printStackTrace();
                        Log.e("onFailure =>", throwable.toString());
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<ArrayList<CarDetailsResponse>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        carsListCallback.onError(new NetworkError(e));
                    }


                    @Override
                    public void onNext(ArrayList<CarDetailsResponse> carDetailsResponse) {
                        carsListCallback.onSuccess(carDetailsResponse);
                    }
                });
    }
}
