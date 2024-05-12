package org.example.UI;

import org.example.Custom;
import org.example.DuombaziuOjektai.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SQL_Manager_IMP implements SQL_Manager {

    private String URL;
    private String USERNAME;
    private String PASSWORD;

    public SQL_Manager_IMP(String URL, String USERNAME, String PASSWORD) {
        this.URL = URL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
    }

    @Override
    public List<Klientas> getKlientuList() {
        List<Klientas> klientasList = new ArrayList<>();

        String sql = "SELECT * FROM klientai";
        Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            Klientas klientas;
            while (resultSet.next()){
                int id = resultSet.getInt("kliento_id");
                String vardas = resultSet.getString("vardas");
                String pavarde = resultSet.getString("pavarde");
                String gimimo_data = resultSet.getString("gimimo_data");
                String registracijos_data = resultSet.getString("registracijos_data");
                boolean VIP = resultSet.getBoolean("VIP");

                klientas = new Klientas(id,vardas,pavarde, LocalDate.parse(gimimo_data, DateTimeFormatter.ofPattern("yyyy-MM-dd")),registracijos_data,VIP);
                klientasList.add(klientas);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return klientasList;
    }
    public List<Darbuotojas> getDarbuotojuList(){
        List<Darbuotojas> darbuotojasList = new ArrayList<>();

        String sql = "SELECT * FROM darbuotojai";
        Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            Darbuotojas darbuotojas;
            while (resultSet.next()){
                int id = resultSet.getInt("darbuotojo_id");
                String vardas_pavarde = resultSet.getString("vardas_pavarde");

                darbuotojas = new Darbuotojas(id,vardas_pavarde);
                darbuotojasList.add(darbuotojas);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return darbuotojasList;
    }

    public double getMokejimuSuma(){

        String sql = "SELECT SUM(mokejimo_suma) AS suma FROM java_data.mokejimai;";
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        double suma;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            resultSet.next();
            suma = resultSet.getDouble("suma");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return suma;
    }

    public double getMinMokejimas(){

        String sql = "SELECT MIN(mokejimo_suma) AS min FROM java_data.mokejimai;";
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        double min;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            resultSet.next();
            min = resultSet.getDouble("min");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return min;
    }

    public double getMaxMokejimas(){

        String sql = "SELECT MAX(mokejimo_suma) AS max FROM java_data.mokejimai;";
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        double max;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            resultSet.next();
            max = resultSet.getDouble("max");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return max;
    }

    public List<Paslauga> getPaslauguList(){
        List<Paslauga> paslaugaList = new ArrayList<>();

        String sql = "SELECT p.paslauga_id AS paslaugos_id, p.paslauga, k.paslaugos_kaina FROM paslaugos p LEFT JOIN paslaugos_kaina k ON p.paslauga_id = k.paslauga_id;";
        Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            Paslauga paslauga;

            while (resultSet.next()){
                int id = resultSet.getInt("paslaugos_id");
                String paslaugaString = resultSet.getString("paslauga");
                Double paslaugoskaina = resultSet.getDouble("paslaugos_kaina");
                if (paslaugoskaina == null) paslaugoskaina = 0.0;

                paslauga = new Paslauga(id,paslaugaString,paslaugoskaina);

                paslaugaList.add(paslauga);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return paslaugaList;
    }

    public List<Mokejimas> getMokejimuList(){
        List<Mokejimas> mokejimaiList = new ArrayList<>();

        String sql = "SELECT * FROM mokejimai";
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            Mokejimas mokejimas;

            while (resultSet.next()){
                int mokejimoID = resultSet.getInt("mokejimo_id");
                int klientoID = resultSet.getInt("kliento_id");
                int darbuotojoID = resultSet.getInt("darbuotojo_id");
                int paslaugaID = resultSet.getInt("paslauga_id");
                double paslaugaKaina = resultSet.getDouble("mokejimo_suma");

                mokejimas = new Mokejimas(mokejimoID,darbuotojoID,klientoID,paslaugaID,paslaugaKaina);
                mokejimaiList.add(mokejimas);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return mokejimaiList;
    }
    public List<Vizitas> getVizitaiList(){
        List<Vizitas> vizitaiList = new ArrayList<>();

        String sql = "SELECT * FROM vizitai";
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            Vizitas vizitas;
            while (resultSet.next()){
                int vizitaiID = resultSet.getInt("vizitai_id");
                int klientoID = resultSet.getInt("kliento_id");
                int paslaugaID = resultSet.getInt("paslauga_id");
                String rezervacijos_data = resultSet.getString("rezervacijos_laikas");

                vizitas = new Vizitas(vizitaiID,klientoID,paslaugaID, LocalDateTime.parse(rezervacijos_data, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                vizitaiList.add(vizitas);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return vizitaiList;

    }
    @Override
    public List<Klientas> findKlientas(String name, String surname) {
        List<Klientas> klientasList = new ArrayList<>();

        String sql = "Select * FROM klientai\n" +
                "WHERE vardas LIKE ? OR pavarde LIKE ?;";
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                statement = connection.prepareStatement(sql);

                statement.setString(1,"%" + name + "%");
                statement.setString(2,"%" + surname + "%");

                resultSet = statement.executeQuery();

                Klientas klientas;
                while (resultSet.next()){
                    int id = resultSet.getInt("kliento_id");
                    String vardas = resultSet.getString("vardas");
                    String pavarde = resultSet.getString("pavarde");
                    String gimimo_data = resultSet.getString("gimimo_data");
                    String registracijos_data = resultSet.getString("registracijos_data");
                    boolean VIP = resultSet.getBoolean("VIP");

                    klientas = new Klientas(id,vardas,pavarde, LocalDate.parse(gimimo_data, DateTimeFormatter.ofPattern("yyyy-MM-dd")),registracijos_data,VIP);
                    klientasList.add(klientas);
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return klientasList;
    }

    public void insertVizitas(Vizitas vizitas){

        String sql = "INSERT INTO vizitai (kliento_id,paslauga_id,rezervacijos_laikas)\n" +
                "VALUES (?,?,?);";
        Connection connection;
        PreparedStatement statement;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            statement.setInt(1, pasirinktiKlienta().getId());
            statement.setInt(2, pasirinktiPaslauga().getId());
            statement.setString(3, vizitas.getRegistracijosdata().toString());
            statement.executeUpdate();
            System.out.println("Vizitas Įvestas:");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Vizitas getArtimiusiasVizitas(){
        String sql = "SELECT * FROM vizitai ORDER BY rezervacijos_laikas";
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        Vizitas vizitas;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            if (!resultSet.next()){
                System.out.println("Registracijų nera.");
                return null;
            }
            int vizitaiID = resultSet.getInt("vizitai_id");
            int klientoID = resultSet.getInt("kliento_id");
            int paslaugaID = resultSet.getInt("paslauga_id");
            String rezervacijos_kaina = resultSet.getString("rezervacijos_laikas");
            LocalDateTime localDateTime = LocalDateTime.parse(rezervacijos_kaina, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            vizitas = new Vizitas(vizitaiID,klientoID,paslaugaID,localDateTime);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return vizitas;

    }

    public void atspauzdintiVizita(){
        Vizitas vizitas  = getArtimiusiasVizitas();
        Klientas klientas;
        int klientoID = vizitas.getKlientoID();

        String sql = "SELECT * FROM klientai WHERE kliento_id = ?;";
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1,klientoID);
            resultSet = statement.executeQuery();
            resultSet.next();
            int kliento_id = resultSet.getInt("kliento_id");
            String vardas = resultSet.getString("vardas");
            String pavarde = resultSet.getString("pavarde");
            String gimimo_data = resultSet.getString("gimimo_data");
            String registracijos_data = resultSet.getString("registracijos_data");
            boolean VIP = resultSet.getBoolean("VIP");

            klientas = new Klientas(kliento_id,vardas,pavarde, LocalDate.parse(gimimo_data, DateTimeFormatter.ofPattern("yyyy-MM-dd")),registracijos_data,VIP);
            System.out.println("Artimiausias vizitas:");
            System.out.println(vizitas);
            System.out.println("Klientas:");
            System.out.println(klientas);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Vizitas getKlientoVizitas(){

        int pasirinktasKlientoID = pasirinktiKlienta().getId();

        String sql = "SELECT * FROM vizitai \n" +
                "WHERE kliento_id = ?\n" +
                "ORDER BY rezervacijos_laikas";
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        Vizitas vizitas;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            statement.setInt(1,pasirinktasKlientoID);
            resultSet = statement.executeQuery();

            if (!resultSet.next()){
                System.out.println("Toks klientas neturi registracijos.");
                return getKlientoVizitas();
            }
            int vizitaiID = resultSet.getInt("vizitai_id");
            int klientoID = resultSet.getInt("kliento_id");
            int paslaugaID = resultSet.getInt("paslauga_id");

            String rezervacijos_kaina = resultSet.getString("rezervacijos_laikas");
            LocalDateTime localDateTime = LocalDateTime.parse(rezervacijos_kaina, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            vizitas = new Vizitas(vizitaiID,klientoID,paslaugaID,localDateTime);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return vizitas;

    }

    public void insertKlientas(Klientas klientas) {
        String sql = "INSERT INTO klientai (vardas,pavarde,gimimo_data,VIP)\n" +
                "VALUES (?,?,?,?);";
        Connection connection;
        PreparedStatement statement;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            statement.setString(1, klientas.getVardas());
            statement.setString(2, klientas.getPavarde());
            statement.setString(3, klientas.getGimimo_data().toString());
            statement.setBoolean(4, klientas.getVIP());
            statement.executeUpdate();
            System.out.println("Įvestas:");
            System.out.println(klientas);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    @Override
    public void insertPaslauga(Paslauga paslauga) {
        String sql = "INSERT INTO paslaugos (paslauga)\n" +
                "VALUES (?);";
        Connection connection;
        PreparedStatement statement = null;

        int key;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, paslauga.getPaslauga());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();

            key = rs.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        insertPaslaugosKaina(paslauga,key);
    }
    public void insertPaslaugosKaina(Paslauga paslauga, int key) {
        String sql = "INSERT INTO paslaugos_kaina (paslauga_id, paslaugos_kaina)\n" +
                "VALUES (?,?);";
        Connection connection;
        PreparedStatement statement;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            statement.setInt(1, key);
            statement.setDouble(2, paslauga.getKaina());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(paslauga);
}

    @Override
    public void insertDarbuotojas(Darbuotojas darbuotojas) {
        String sql = "INSERT INTO darbuotojai (vardas_pavarde)\n" +
                "VALUES (?);";
        Connection connection;
        PreparedStatement statement;

        {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                statement = connection.prepareStatement(sql);
                statement.setString(1, darbuotojas.getVardas_pavarde());
                statement.executeUpdate();
                System.out.println("Darbuotojas įvestas.");
                System.out.println(darbuotojas);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void cancelVizitas(Vizitas vizitas){
        String sql = "DELETE FROM vizitai\n" +
                "Where vizitai_id = ?;";
        Connection connection;
        PreparedStatement statement;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            statement.setInt(1, vizitas.getId());
            statement.executeUpdate();
            System.out.println("Vizitas ištrintas.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void cancelVizitas(){
        Vizitas vizitas = pasirinktiVizita();
        String sql = "DELETE FROM vizitai\n" +
                "Where vizitai_id = ?;";
        Connection connection;
        PreparedStatement statement;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            statement.setInt(1, vizitas.getId());
            statement.executeUpdate();
            System.out.println("Vizitas Ištrintas;");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void mokejimas(Darbuotojas darbuotojas, Paslauga paslauga, Klientas klientas, double suma) {
        String sql = "INSERT INTO mokejimai (kliento_id, darbuotojo_id, paslaugos_id, mokejimo_suma )\n" +
                "VALUES (?,?,?,?);";
        Connection connection;
        PreparedStatement statement;


        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            statement.setInt(1, klientas.getId());
            statement.setInt(2, darbuotojas.getId());;
            statement.setInt(3, paslauga.getId());
            statement.setDouble(4,suma);
            statement.executeUpdate();

            System.out.println("Mokejimas Ivestas");
            System.out.println(paslauga);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void mokejimas(Darbuotojas darbuotojas, Vizitas vizitas){

        String sql =    "SELECT v.kliento_id, v.paslauga_id,p.paslaugos_kaina, VIP FROM vizitai v " +
                        "LEFT JOIN paslaugos_kaina p " +
                        "ON p.paslauga_id =  v.paslauga_id " +
                        "INNER JOIN klientai k  " +
                        "ON k.kliento_id = v.kliento_id " +
                        "WHERE v.vizitai_id = ?;";

        int kliento_ID;
        int paslauga_id;
        double paslaugos_kaina;
        Boolean arVIP;
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            statement.setInt(1,vizitas.getId());
            resultSet = statement.executeQuery();

            resultSet.next();
            kliento_ID = resultSet.getInt("kliento_id");
            paslauga_id = resultSet.getInt("paslauga_id");
            paslaugos_kaina = resultSet.getDouble("paslaugos_kaina");
            arVIP = resultSet.getBoolean("VIP");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        sql = "INSERT INTO mokejimai (kliento_id,darbuotojo_id,paslauga_id,mokejimo_suma)\n" +
                "VALUES (?,?,?,?);";

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            statement.setInt(1, kliento_ID);
            statement.setInt(2, darbuotojas.getId());
            statement.setInt(3, paslauga_id);
            if(arVIP) statement.setDouble(4, paslaugos_kaina*0.75);
            else statement.setDouble(4, paslaugos_kaina);
            statement.executeUpdate();
            System.out.println("Mokejimas įvestas:");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        cancelVizitas(vizitas);
    }
    public Klientas pasirinktiKlienta(){
        List<Klientas> klientasList = getKlientuList();

        for (Klientas k : klientasList){
            System.out.println(k);
        }

        System.out.println("Pasirinkite kliento ID.");
        int pasirinktasID = Custom.nuskaitytiIntVerteCon();

        int index = -1;

        for(int i = 0; i < klientasList.size(); i++){
            if (pasirinktasID == klientasList.get(i).getId()){
                index = i;
                break;
            }
        }
        if (index == -1){
            System.out.println("Tokio ID nėra");
            return pasirinktiKlienta();
        }
        return klientasList.get(index);
    }
    public Paslauga pasirinktiPaslauga(){
        List<Paslauga> paslauguList = getPaslauguList();

        for (Paslauga k : paslauguList){
            System.out.println(k);
        }

        System.out.println("Pasirinkite paslaugos ID.");
        int pasirinktasID = Custom.nuskaitytiIntVerteCon();

        int index = -1;

        for(int i = 0; i < paslauguList.size(); i++){
            if (pasirinktasID == paslauguList.get(i).getId()){
                index = i;
                break;
            }
        }
        if (index == -1){
            System.out.println("Tokio ID nėra");
            return pasirinktiPaslauga();
        }
        return paslauguList.get(index);
    }
    public Darbuotojas pasirinkiteDarbuotoja(){
        List<Darbuotojas> darbuotojoList = getDarbuotojuList();

        for (Darbuotojas k : darbuotojoList){
            System.out.println(k);
        }

        System.out.println("Pasirinkite darbuotojo ID.");
        int pasirinktasID = Custom.nuskaitytiIntVerteCon();

        int index = -1;

        for(int i = 0; i < darbuotojoList.size(); i++){
            if (pasirinktasID == darbuotojoList.get(i).getId()){
                index = i;
                break;
            }
        }
        if (index == -1){
            System.out.println("Tokio ID nėra");
            return pasirinkiteDarbuotoja();
        }
        return darbuotojoList.get(index);
    }
    public Vizitas pasirinktiVizita(){
        List<Vizitas> vizitasList = getVizitaiList();

        for (Vizitas k : vizitasList){
            System.out.println(k);
        }

        System.out.println("Pasirinkite vizito ID.");
        int pasirinktasID = Custom.nuskaitytiIntVerteCon();

        int index = -1;

        for(int i = 0; i < vizitasList.size(); i++){
            if (pasirinktasID == vizitasList.get(i).getId()){
                index = i;
                break;
            }
        }
        if (index == -1){
            System.out.println("Tokio ID nėra");
            return pasirinktiVizita();
        }
        return vizitasList.get(index);
    }

    public void irasytiICSV(String PATH){
        List <Klientas> klientasList = getKlientuList();
        for(int i = 0 ; i < klientasList.size();i++)
        Custom.irasytiEiluteIFaila(klientasList.get(i).toCSVString(),PATH);    }

    public List<Klientas> importuotiIsCSV(String PATH){
            List<String> klientuStringList = Custom.nuskaitytiFaila(PATH);
            List<Klientas> klientuList = new ArrayList<>();

            for (int i = 0; i < klientuStringList.size(); i++){
                String[] kliento_parametrai = klientuStringList.get(i).split(",");


                Klientas klientas = new Klientas(   Integer.parseInt(kliento_parametrai[0]),
                                                    kliento_parametrai[1],
                                                    kliento_parametrai[2],
                                                    LocalDate.parse(kliento_parametrai[3], DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                                                    kliento_parametrai[4],Boolean.parseBoolean(kliento_parametrai[5]));
                klientuList.add(klientas);
            }
            return klientuList;
    }
}
