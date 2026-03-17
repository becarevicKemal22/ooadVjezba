package com.example.lv09.controller;

import com.example.lv09.model.Predmet;
import com.example.lv09.model.PredmetModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class PredmetController {
    @FXML
    private Label porukaLabel;

    @FXML
    private TextField nazivField;

    @FXML
    private TextField ECTSField;

    @FXML
    private Button dodajPredmetButton;

    private PredmetModel model;

    public PredmetController(PredmetModel model){
        this.model = model;
    }

    @FXML
    public void initialize(){
        //Kod za testiranje baze
        PredmetModel.kreirajTabeluAkoNePostoji();
        PredmetModel.napuniInicijalnimPodacima();
        Predmet p = PredmetModel.dajPredmetPoId(1);
        System.out.println(p.toString());
        PredmetModel.azurirajPredmet(1, "Novi naziv predmeta", null);
        p = PredmetModel.dajPredmetPoId(1);
        System.out.println(p.toString());
        PredmetModel.obrisiPredmetPoId(1);
        p = PredmetModel.dajPredmetPoId(1);
        if(p == null){
            System.out.println("Predmet je uspjesno obrisan.");
        }
        PredmetModel.isprazniTabeluPredmeta();
        PredmetModel.napuniInicijalnimPodacima();

//        dodajPredmetButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                dodajPredmet();
//            }
//        });
    }

    private static Integer idBrojac = 0;

//    private void dodajPredmet(){
//        String naziv = nazivField.getText();
//        String ECTS = ECTSField.getText();
//
//        if(naziv.isEmpty() || ECTS.isEmpty()){
//            porukaLabel.setText("Sva polja moraju biti popunjena!");
//            return;
//        }
//
//        Integer velicinaPrije = model.dajBrojPredmeta();
//
//        String poruka = "";
//        Double dECTS = (double) 0;
//        try{
//            dECTS = Double.parseDouble(ECTS);
//        }catch(NumberFormatException e){
//            poruka = "ECTS poeni moraju biti realan broj!";
//        }
//        if(poruka.isEmpty()){
//            poruka = model.dodajPredmet(idBrojac, naziv, dECTS);
//            idBrojac++;
//        }
//
//        porukaLabel.setText(poruka);
//
//        if(model.dajBrojPredmeta() > velicinaPrije){
//            System.out.println("Ispis svih predmeta: ");
//            for(Predmet p : model.dajSvePredmete()){
//                System.out.print(p.toString());
//            }
//            nazivField.setText("");
//            ECTSField.setText("");
//        }
//    }

//    public void dajPredmeteIzXMLDatoteke(String datoteka){
//        try{
//            List<Predmet> predmeti = Predmet.ucitajPredmeteIzXMLDatoteke(datoteka);
//            String poruka = "Osobe ucitane iz xml datoteke su:\n";
//            for(Predmet p : predmeti){
//                poruka += p.toString();
//            }
//            view.setPoruka(poruka);
//        }catch(Exception e){
//            view.setPoruka("Greska: " + e.getMessage());
//        }
//    }
//
//    public void azurirajNaziv(){
//        try{
//            model.setNaziv(view.getUlazniTekst());
//            view.setPoruka("Ime je uspjesno azurirano!");
//        }catch(Exception e){
//            view.setPoruka("Greska: " + e.getMessage());
//        }
//    }
//
//    public void azurirajECTS(){
//        try{
//            model.setECTS(Double.parseDouble(view.getUlazniTekst()));
//            view.setPoruka("ECTS bodovi su uspjesno azurirani!");
//        }catch(Exception e){
//            view.setPoruka("Greska: " + e.getMessage());
//        }
//    }
//
//    public OsobaView getView() {
//        return view;
//    }
//
//    public void setView(OsobaView view) {
//        this.view = view;
//    }
//
//    public Predmet getModel() {
//        return model;
//    }
//
//    public void setModel(Predmet model) {
//        this.model = model;
//    }
}
