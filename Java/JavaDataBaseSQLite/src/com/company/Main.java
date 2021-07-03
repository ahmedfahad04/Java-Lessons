package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Main obj = new Main();
		obj.insert("name",2,"dhaka");
        //obj.query();
        obj.update("Raiyyan", 54);
    }

    public Connection connect() {
        Connection conn = null;
        try {

            Class.forName("org.sqlite.JDBC"); // load and register the driver. its a must task. part 1

            String url = "jdbc:sqlite:src/StudentsInfo.db"; // part 2
            conn = DriverManager.getConnection(url); // part 3
            System.out.println("Connected!!");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void insert(String name, int id, String address){
        String sql = "INSERT INTO users(Name, Roll, Address) VALUES(?,?,?)";

        try{
            Connection conn = this.connect();                   // part 1
            PreparedStatement ps = conn.prepareStatement(sql);  // part 2
           
 		    // part 3
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.setString(3, address);

            // part 4
            ps.execute();
            ps.close(); // this is a must.
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void query(){
        String sql = "SELECT Name, Address From users WHERE Roll = 57";

        try{
            Connection conn = this.connect(); //part 1
            Statement s = conn.createStatement(); // part 2
            ResultSet rs = s.executeQuery(sql); // part 3

            // part 4
            while(rs.next()){
                String n = rs.getString("Name");
                String ad = rs.getString("Address");

                System.out.println(n + "\t\t" + ad);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void update(String name, int id){
        String sql = "UPDATE users set Name = ? WHERE Roll = ?";

        try{
            Connection conn = this.connect();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, id);

            ps.execute();
            ps.close();
            conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}

















package sample;

import java.sql.*;

public class DbConnection {
    public static Connection connect(){
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:src/sample/institutions.db");
            System.out.println("Connected to Database!!");
        } catch (ClassNotFoundException | SQLException throwables) {
            throwables.printStackTrace();
        }

        return con;
    }

    public static void insert(String name, String address, String icu, String oxygen, String contact){
        String sql = "INSERT INTO hospitals(Name, Address, ICU, Oxygen_Capacity, Contact) VALUES(?,?,?,?,?)";

        Connection con = connect();
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, icu);
            ps.setString(4, oxygen);
            ps.setString(5, contact);

            System.out.println("Data inserted Perfectly!!");

            ps.execute();
            ps.close();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void showData() {
        String sql = "SELECT * FROM hospitals";

        Statement s = null;
        try {
            s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()){
                String name = rs.getString("Name");
                String address = rs.getString("Address");
                String icu = rs.getString("ICU");
                String oxygen = rs.getString("Oxygen_Capacity");
                String contact = rs.getString("Contact");

                Hospital h2 = new Hospital(name, address, icu, oxygen, contact);
                //Controller.dataList.add(h2);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}












package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveData {
    public static void save(String name, String address, String icu, String oxygen, String contact) throws IOException {

    File f = new File("Institutions.txt");
    if(!f.exists()) f.createNewFile();

    FileWriter fw = new FileWriter(f,true);
    fw.write(name + "," +address+ ","+icu+ ","+oxygen+ ","+contact+"\n");
    fw.close();

    }

    public static void fetch() throws IOException {

        File f = new File("Institutions.txt");
        if(!f.exists()) f.createNewFile();

        Scanner sc = new Scanner(f);
        while(sc.hasNext()){
            String st = sc.nextLine();
            String parts[] = st.split(",");

            Hospital h2 = new Hospital(parts[0], parts[1], parts[2], parts[3], parts[4]);
//            Controller.dataList.add(h2);
//            Controller.dataList.clear();
        }
    }
}

