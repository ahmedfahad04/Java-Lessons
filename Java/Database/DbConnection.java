package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {
    public static Connection connect(){
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:src/Database/institutions.db");
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
}
