package Database;

import java.sql.*;

public class DbOperations {
//    public static void main(String[] args) {
//        Database.Main obj = new Database.Main();
//        //obj.query();
//        obj.update("Raiyyan", 54);
//    }

    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC"); // load and register the driver. its a must task. part 1
            String url = "jdbc:sqlite:StudentsInfo.db"; // part 2
            conn = DriverManager.getConnection(url); // part 3
            System.out.println("Connected!!");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void insert(String name, String id, String address){
        String sql = "INSERT INTO users(Name, Roll, Address) VALUES(?,?,?)";

        try{
            Connection conn = this.connect();                   // part 1
            PreparedStatement ps = conn.prepareStatement(sql);  // part 2
            // part 3
            ps.setString(1, name);
            ps.setString(2, id);
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
