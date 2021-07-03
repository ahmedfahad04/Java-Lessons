package Database;

import java.sql.*;

public class CreateDb {
  public Connection connect(){
      Connection con = null;

      try {
          Class.forName("org.sqlite.JDBC");
          con = DriverManager.getConnection("jdbc:sqlite:F:\\FAHADS FILES\\__JAVA__\\HOME\\IntelliJ\\TestingFx\\src\\StudentsInfo.db");
          System.out.println("Connected");

      } catch (ClassNotFoundException | SQLException e) {
          e.printStackTrace();
      }
   return con;
  }
}
