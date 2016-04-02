package com.toys.breakable.lonelybit.bauddhikpatrak;

/**
 * Created by prafulljoshi on 02/04/16.
 */
public class Karyakarta {

    private String nagar;
    private String name;
    private String mobileNumber;
    private String email;


    private String dayitva;

    public Karyakarta(String nagar, String name, String mobileNumber, String email, String dayitva) {
        this.nagar = nagar;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.dayitva = dayitva;
    }

    public String getNagar() {
        return nagar;
    }

    public String getName() {
        return name;
    }


    public String getMobileNumber() {
        return mobileNumber;
    }


    public String getEmail() {
        return email;
    }

    public String getDayitva() {
        return dayitva;
    }
}
