package com.rental.android.sixt.models;

import java.io.Serializable;

/**
 * Created by Anuja on 8/31/17.
 */

public class MarkerData implements Serializable {
    Double latitude;
    Double longitude;

    public MarkerData(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
