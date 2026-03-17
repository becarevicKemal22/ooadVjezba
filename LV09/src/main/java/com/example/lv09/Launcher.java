package com.example.lv09;

import com.example.lv09.controller.OsobaController;
import com.example.lv09.model.OsobaModel;
import com.example.lv09.view.OsobaView;
import javafx.application.Application;

import java.sql.Connection;

public class Launcher {
    public static void main(String[] args) {
        Application.launch(HelloApplication.class, args);

//        OsobaModel osobaModel = new OsobaModel();
//        osobaModel.napuni();
//
//        OsobaView osobaView = new OsobaView();
//        osobaView.setUlazniTekst("Novo ime");
//
//
//        OsobaController osobaController = new OsobaController(osobaModel, osobaView);
//        osobaController.azurirajIme(1);
//
//
//        System.out.println("1) View ispisuje: " + osobaView.getPoruka());
//        System.out.println("   Azurirana osoba je: " + osobaController.dajOsobuPoId(1).toString());
//
//
//        osobaController.dajOsobeIzTxtDatoteke("src/data/osobe.txt");
//        System.out.println("2) View ispisuje: " + osobaView.getPoruka());
//
//
//        osobaController.dajOsobeIzXmlDatoteke("src/data/osobe.xml");
//        System.out.println("3) View ispisuje: " + osobaView.getPoruka());
//
//        //Test dajOsobuPoId
//        osobaModel.napuni();
//        osobaController.dajOsobuPoId(1);
//        System.out.println("4) View ispisuje: " + osobaView.getPoruka());
//        osobaController.dajOsobuPoId(1124);
//        System.out.println("5) View ispisuje: " + osobaView.getPoruka());
    }
}
