package com.example.magazyn;

public class Produkt {
    String nazwa;
    double cena;
    int ilosc;
    public Produkt(String nazwa, double cena, int ilosc)
    {
        this.nazwa=nazwa.toLowerCase();
        this.cena=Math.round(cena*100)/100.0;
        this.ilosc=ilosc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getCena() {
        return cena;
    }


    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
    public String toString()
    {
        return nazwa+" cena "+String.format("%.2f",cena);
    }
}
