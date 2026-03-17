package com.example.lv09.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PredmetModel {
    private ObservableList<Predmet> predmeti;

    private static final String DATABASE_URL = "jdbc:sqlite:baza.db";

    private PredmetModel() { predmeti = FXCollections.observableArrayList(); }

    private static PredmetModel instance = null;

    public static PredmetModel getInstance() {
        if (instance == null) {
            instance = new PredmetModel();
        }
        return instance;
    }

    public static void removeInstance() {
        instance = null;
    }

//    public String dodajPredmet(String naziv, Double ECTS){
//        try{
//            Predmet newPredmet = new Predmet(naziv, ECTS);
//            predmeti.add(newPredmet);
//            return "Predmet je uspjesno dodan!";
//        }catch(IllegalArgumentException e){
//            return e.getMessage();
//        }
//    }

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }

    public static void kreirajTabeluAkoNePostoji() {
        String kreirajPredmetTabeluSql = """
                CREATE TABLE IF NOT EXISTS Predmet (
                    id INTEGER,
                    naziv TEXT,
                    ECTS REAL
                );
                """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(kreirajPredmetTabeluSql);
            System.out.println("Tabela je kreirana ili vec postoji!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void napuniInicijalnimPodacima() {
        String insertSQL = """
                   INSERT INTO Predmet (id, naziv, ECTS)
                   VALUES (?, ?, ?);
                """;


        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {


            pstmt.setInt(1, 1);
            pstmt.setString(2, "Prvi Predmet");
            pstmt.setDouble(3, 7.5);
            pstmt.executeUpdate();


            pstmt.setInt(1, 2);
            pstmt.setString(2, "Drugi Predmet");
            pstmt.setDouble(3, 8.0);
            pstmt.executeUpdate();


            System.out.println("Ubaceni pocetni podaci!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void isprazniTabeluPredmeta() {
        String upit = "DELETE FROM Predmet";


        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            int brojObrisanihRedova = stmt.executeUpdate(upit);
            System.out.println("Obrisani redovi tabele. Broj obrisanih redova: " + brojObrisanihRedova);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Predmet> dajSvePredmete() {
        List<Predmet> predmeti = new ArrayList<>();
        String upit = "SELECT * FROM Predmet";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(upit)) {


            while (rs.next()) {
                Predmet predmet = new Predmet(
                        rs.getInt("id"),
                        rs.getString("naziv"),
                        rs.getDouble("ECTS")
                );
                predmeti.add(predmet);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return predmeti;
    }

    public static Predmet dajPredmetPoId(Integer id) {
        Predmet predmet = null;
        String upit = "SELECT * FROM Predmet WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(upit)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                predmet = new Predmet(
                        rs.getInt("id"),
                        rs.getString("naziv"),
                        rs.getDouble("ECTS")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return predmet;
    }
    public static String azurirajPredmet(Integer id, String noviNaziv, Double noviECTS) {
        StringBuilder upit = new StringBuilder("UPDATE Predmet SET ");
        boolean imaPromjene = false;
        // lista koja cuva parametre
        List<Object> parametri = new ArrayList<>();

        // provjera vrijednosti pojedinih polja (da li su prazna ili ne)
        if (noviNaziv != null && !noviNaziv.isEmpty()) {
            upit.append("naziv = ?, ");
            parametri.add(noviNaziv);
            imaPromjene = true;
        }
        if (noviECTS != null) {
            upit.append("ECTS = ?, ");
            parametri.add(noviECTS);
            imaPromjene = true;
        }

        // izadji ranije ako nema polja za azuriranje
        if (!imaPromjene) {
            return "Sva polja su ista kao i prije!";
        }

        // uklanjanje zareza na kraju upita i razmaka iz SQL upita
        upit.delete(upit.length() - 2, upit.length());
        upit.append(" WHERE id = ?");
        parametri.add(id);

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(upit.toString())) {


            // dodavanje parametara u PreparedStatement
            for (int i = 0; i < parametri.size(); i++) {
                pstmt.setObject(i + 1, parametri.get(i));
            }


            int promijenjeniRedovi = pstmt.executeUpdate();
            if (promijenjeniRedovi > 0) {
                return "Predmet je uspjesno azuriran";
            } else {
                return "Ne postoji predmet sa datim id-em";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public static String obrisiPredmetPoId(Integer id) {
        String upit = "DELETE FROM Predmet WHERE id = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(upit)) {
            pstmt.setInt(1, id);
            int rs = pstmt.executeUpdate();
            if (rs == 0) {
                return "Ne postoji predmet sa datim id-em";
            }
            return "Predmet je uspjesno obrisan";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public Integer dajBrojPredmeta(){
        return predmeti.size();
    }
}
