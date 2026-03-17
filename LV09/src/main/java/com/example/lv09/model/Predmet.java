package com.example.lv09.model;

import javafx.beans.property.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Predmet {
    private IntegerProperty id;
    private StringProperty naziv;
    private DoubleProperty ECTS;

    public Predmet(Integer id, String naziv, Double ECTS){
        this.id = new SimpleIntegerProperty(id);
        this.naziv = new SimpleStringProperty(naziv);
        this.ECTS = new SimpleDoubleProperty(ECTS);

        setId(id);
        setNaziv(naziv);
        setECTS(ECTS);
    }

    @Override
    public String toString(){
        return "Predmet{" +
                "naziv=" + naziv.get() +
                ", ects=" + ECTS.get() + " }\n";
    }

    public Integer getId() { return id.get(); }

    public IntegerProperty idProperty() { return id; }

    public void setId(Integer id){
        this.id.set(id);
    }

    public String getNaziv() {
        return naziv.get();
    }

    public StringProperty nazivProperty() { return naziv; }

    public void setNaziv(String naziv) {
        if(naziv.length() < 5 || naziv.length() > 50) throw new IllegalArgumentException("Naziv mora imati 5 do 50 karaktera!");
        this.naziv.set(naziv);
    }

    public Double getECTS() {
        return ECTS.get();
    }

    public DoubleProperty ECTSProperty() { return ECTS; }

    public void setECTS(Double ECTS) {
        if(ECTS < 5 || ECTS > 20){
            throw new IllegalArgumentException("ECTS bodovi moraju biti izmedju 5 i 20");
        }
        Double decimalni = ECTS - ECTS.intValue();
        decimalni *= 10;
        Integer prvaDec = (int)Math.round(decimalni);
        if(prvaDec != 0 && prvaDec != 5){
            throw new IllegalArgumentException("Prva decimala ECTS bodova mora biti 0 ili 5");
        }

        this.ECTS.set(ECTS);
    }


}
