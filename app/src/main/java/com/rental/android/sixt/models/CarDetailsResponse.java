package com.rental.android.sixt.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Anuja on 8/30/17.
 */

public class CarDetailsResponse implements Parcelable {

    @SerializedName("id")
    String id;

    @SerializedName("modelIdentifier")
    String modelId;

    @SerializedName("modelName")
    String modelName;

    @SerializedName("name")
    String carName;

    @SerializedName("make")
    String carMake;

    @SerializedName("group")
    String carGroup;

    @SerializedName("color")
    String carColor;

    @SerializedName("series")
    String carSeries;

    @SerializedName("fuelType")
    String fuelType;

    @SerializedName("fuelLevel")
    Double fuelLevel;

    @SerializedName("transmission")
    String transmission;

    @SerializedName("licensePlate")
    String liscensePlate;

    @SerializedName("latitude")
    Double latitude;

    @SerializedName("longitude")
    Double longitude;

    @SerializedName("innerCleanliness")
    String cleanliness;

    @SerializedName("carImageUrl")
    String imageURl;


    protected CarDetailsResponse(Parcel in) {
        id = in.readString();
        modelId = in.readString();
        modelName = in.readString();
        carName = in.readString();
        carMake = in.readString();
        carGroup = in.readString();
        carColor = in.readString();
        carSeries = in.readString();
        fuelType = in.readString();
        transmission = in.readString();
        liscensePlate = in.readString();
        cleanliness = in.readString();
        imageURl = in.readString();
    }

    public static final Creator<CarDetailsResponse> CREATOR = new Creator<CarDetailsResponse>() {
        @Override
        public CarDetailsResponse createFromParcel(Parcel in) {
            return new CarDetailsResponse(in);
        }

        @Override
        public CarDetailsResponse[] newArray(int size) {
            return new CarDetailsResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(modelId);
        parcel.writeString(modelName);
        parcel.writeString(carName);
        parcel.writeString(carMake);
        parcel.writeString(carGroup);
        parcel.writeString(carColor);
        parcel.writeString(carSeries);
        parcel.writeString(fuelType);
        parcel.writeString(transmission);
        parcel.writeString(liscensePlate);
        parcel.writeString(cleanliness);
        parcel.writeString(imageURl);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarGroup() {
        return carGroup;
    }

    public void setCarGroup(String carGroup) {
        this.carGroup = carGroup;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(Double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getLiscensePlate() {
        return liscensePlate;
    }

    public void setLiscensePlate(String liscensePlate) {
        this.liscensePlate = liscensePlate;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(String cleanliness) {
        this.cleanliness = cleanliness;
    }

    public String getImageURl() {
        return imageURl;
    }

    public void setImageURl(String imageURl) {
        this.imageURl = imageURl;
    }
}
