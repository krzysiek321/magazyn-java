package com.example.magazyn;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Magazyn {
    ArrayList<Produkt>lista_produktow;
    public Magazyn()
    {
        lista_produktow=new ArrayList<>();
        Produkt p1=new Produkt("kawa",12.51,10);
        Produkt p2=new Produkt("herbata",8,10);
        Produkt p3=new Produkt("chleb",2.50,10);
        Produkt p4=new Produkt("masło",4.50,10);
        lista_produktow.add(p1);
        lista_produktow.add(p2);
        lista_produktow.add(p3);
        lista_produktow.add(p4);
    }
    public void dodaj_produkt(Produkt p1)
    {
        int pom=0;
        for(Produkt p:lista_produktow)
        {
            if(p.getNazwa().equals(p1.getNazwa()))
            {
                p.setCena(p1.getCena());
                p.setIlosc(p1.getIlosc());
                pom=1;
            }
        }
        if(pom==0) {
            lista_produktow.add(p1);
        }
    }
    public void usun_produkt(String s)
    {
        for(Produkt p:lista_produktow) {
            if(s.equals(p.toString())) {
                lista_produktow.remove(p);
                break;
            }
        }
    }
    public void zmien_ilosc(String s,int ilosc)
    {
        String[] tab=s.split(" ");
        for(Produkt p:lista_produktow)
        {
            if(tab[0].equals(p.getNazwa()))
            {
                p.setIlosc(ilosc);
            }
        }
    }
    public ObservableList<Produkt> get_lista_produktow()
    {
        ObservableList<Produkt>lista=FXCollections.observableArrayList();
        for(Produkt p:lista_produktow)
        {
            lista.add(p);
        }
        return lista;
    }
    public ObservableList<String> get_lista_produktow2()
    {
        ObservableList<String>lista=FXCollections.observableArrayList();
        for(Produkt p:lista_produktow)
        {
            lista.add(p.getNazwa()+" : "+String.format("%.2f",p.getCena())+" ilość: "+p.getIlosc());
        }
        return lista;
    }


}
