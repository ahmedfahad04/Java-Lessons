package Database;

import java.sql.*;

public class DbConnection {
    public static Connection connect(){
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:src/Database/inputData.db"); //jdbc:sqlite:src/Database/abc.db
            //System.out.println("Conneted!!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static boolean query(String sql, String usermail, String userpass) throws SQLException {
        Statement st = connect().createStatement();
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()){
            String mail = rs.getString("Email");
            String pass = rs.getString("Password");

            //System.out.println("Email: " + mail + "\n" + "Password: " + pass + "\n");
            if(mail.equals(usermail) && pass.equals(userpass)) return true;
        }
        return false;
    }
}
