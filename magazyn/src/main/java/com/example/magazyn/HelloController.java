package com.example.magazyn;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class HelloController {
    Magazyn m=new Magazyn();
    static int ile=0;
    @FXML
    private ListView lista_pr;
    @FXML
    private VBox pole1;
    @FXML
    private VBox pole2;
    @FXML
    private VBox pole3;
    @FXML
    private VBox pole4;
    @FXML
    private VBox pole5;
    @FXML
    private TextField nazwa1;
    @FXML
    private TextField cena1;
    @FXML
    private TextField ilosc1;
    @FXML
    private ChoiceBox wybor1;
    @FXML
    private ChoiceBox wybor2;
    @FXML
    private TextField nowailosc;

    @FXML
    protected void przegladaj() {
        pole1.setVisible(false);
        pole2.setVisible(true);
        pole1.setPrefHeight(0);
        pole3.setPrefHeight(0);
        pole4.setPrefHeight(0);
        pole5.setPrefHeight(0);
        pole2.setPrefHeight(400);
        lista_pr.setItems(m.get_lista_produktow());
        pole2.setPrefHeight(400);
    }
    @FXML
    protected void dodajProdukt()
    {
        nazwa1.setText(null);
        ilosc1.setText(null);
        cena1.setText(null);
        pole1.setVisible(false);
        pole3.setVisible(true);
        pole1.setPrefHeight(0);
        pole2.setPrefHeight(0);
        pole4.setPrefHeight(0);
        pole5.setPrefHeight(0);
        pole3.setPrefHeight(400);
    }
    @FXML
    protected void usunProdukt()
    {
        pole1.setVisible(false);
        pole4.setVisible(true);
        pole1.setPrefHeight(0);
        pole2.setPrefHeight(0);
        pole3.setPrefHeight(0);
        pole5.setPrefHeight(0);
        wybor1.setItems(m.get_lista_produktow());
    }
    @FXML
    protected void zmienilosc()
    {

        pole1.setVisible(false);
        pole5.setVisible(true);
        pole1.setPrefHeight(0);
        pole2.setPrefHeight(0);
        pole3.setPrefHeight(0);
        pole4.setPrefHeight(0);
        nowailosc.setText(null);
        wybor2.setItems(m.get_lista_produktow2());
    }
    @FXML
    protected void cofnij()
    {
        pole1.setVisible(true);
        pole5.setVisible(false);
        pole2.setVisible(false);
        pole3.setVisible(false);
        pole4.setVisible(false);
    }
    @FXML
    protected void usun()
    {
        if(wybor1.getValue()!=null) {
            Object pom = wybor1.getValue();
            String wybor = pom.toString();
            m.usun_produkt(wybor);
            pole1.setVisible(true);
            pole4.setVisible(false);
        }
    }
    @FXML
    protected void zmien()
    {
        if (nowailosc.getText()!=""  && wybor2.getValue()!=null) {
            Object pom = wybor2.getValue();
            String ile=nowailosc.getText();
            String wybor = pom.toString();
            int ilosc = Integer.parseInt(ile);
            m.zmien_ilosc(wybor, ilosc);
            pole1.setVisible(true);
            pole5.setVisible(false);

        }
    }
    @FXML
    protected void dodaj()
    {
        if(nazwa1.getText()!="" && ilosc1.getText()!="" && cena1.getText()!="") {
            String nazwa = nazwa1.getText();
            Double cena = Double.valueOf(cena1.getText());
            int ilosc = Integer.parseInt(ilosc1.getText());
            Produkt p = new Produkt(nazwa, cena, ilosc);
            m.dodaj_produkt(p);
            pole1.setVisible(true);
            pole3.setVisible(false);
        }
    }
    @FXML
    protected void sprawdz3()
    {
        String s=ilosc1.getText();
        if(s.length()>0) {
            byte b = (byte) s.charAt(ilosc1.getCaretPosition() - 1);
            if(b<48 || b>57)
            {
                String s1=s.substring(0,ilosc1.getCaretPosition()-1);
                ilosc1.setText(s1);
                ilosc1.positionCaret(s1.length());
            }
        }
    }
    @FXML
    protected void sprawdz1()
    {
        String s=nowailosc.getText();
        if(s.length()>0) {
            byte b = (byte) s.charAt(nowailosc.getCaretPosition() - 1);
            if(b<48 || b>57)
            {
                String s1=s.substring(0,nowailosc.getCaretPosition()-1);
                nowailosc.setText(s1);
                nowailosc.positionCaret(s1.length());
            }
        }
    }
    @FXML
    protected void sprawdz2()
    {
        String s=cena1.getText();
        if(s.length()>0) {
            byte b = (byte) s.charAt(cena1.getCaretPosition() - 1);
            if((b<48 || b>57) && b!=46)
            {
                String s1 = s.substring(0, cena1.getCaretPosition() - 1);
                    cena1.setText(s1);
                    cena1.positionCaret(s1.length());

            }
            else if(b==46)
            {
                String s1 = s.substring(0, cena1.getCaretPosition() - 1);
                if(s1.contains(".")) {
                    cena1.setText(s1);
                    cena1.positionCaret(s1.length());
                }
            }
        }
    }


}