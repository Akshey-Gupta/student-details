import java.sql.*;

    class first {
        public static void main(String args[]) {
            try {
                // step1 load the driver class
                Class.forName("oracle.jdbc.driver.OracleDriver");

                // step2 create the connection object
                try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "SYSTEM", "akshey");
                     Statement stmt = con.createStatement();
                     ) {

                        String sql = "CREATE TABLE StudentDetails " +
                        " (StudName VARCHAR(255), " + 
                        " StudId VARCHAR(255), " + 
                        " Branch VARCHAR(255), "+
                        "Section VARCHAR(255),"+
                        "Address VARCHAR(255))" ; 
     
              stmt.executeUpdate(sql);
              System.out.println("Created table in given database...");

                }

            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }