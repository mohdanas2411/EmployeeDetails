package com.employee;

import java.util.Objects;

public class Address {

    private String distric;
    private String city;
    private String state;
    private long pincode;
    private String country;


    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistric() {
        return distric;
    }

    public void setDistric(String distric) {
        this.distric = distric;
    }

    @Override
    public String toString() {
        return
                "distric='" + distric + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode=" + pincode +
                ", country='" + country + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return pincode == address.pincode && Objects.equals(distric, address.distric) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distric, city, state, pincode, country);
    }
}
