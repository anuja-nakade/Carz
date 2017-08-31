package com.rental.android.sixt.networking;

/**
 * Created by Anuja on 8/30/17.
 */

public class NetworkError {
    private String appErrorMessage;

    public NetworkError(Throwable e) {

    }

    public String getAppErrorMessage() {
        return appErrorMessage;
    }
}
