package com.example.dummy;

public class Measure {

    private int kilos;
    private String date;

    private Measure(int kilos, String date){
        this.kilos = kilos;
        this.date = date;
    }

    public static Measure getInstance(int kilos, String date){

        if ( kilos < 0 ) return null;
        if ( kilos > 10 ) return null;

        return new Measure(kilos, date);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getKilos() {
        return kilos;
    }

    public void setKilos(int kilos) {
        if ( kilos > 0 )
        this.kilos = kilos;
        else this.kilos = 0;
    }


}
