import java.sql.*;

public class third {
    public static void main(String [] args) throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "akshey")) {
            PreparedStatement ps=con.prepareStatement("SELECT * FROM StudentDetails");
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
            }
        }
    }
    
}
