package com.moscon.tails;

public class Punto {
    private double latitude = 0.0;
    private double longitude = 0.0;

    // definiendo
    public Punto(double latitude, double longitude) {

        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
