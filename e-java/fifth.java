import java.sql.*;
import java.util.Scanner;

class fifth {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "akshey")) {
                searchById(con);
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private static void searchById(Connection con){
        try{
            System.out.println("Enter Student ID to search: ");
            String studentId=scanner.nextLine();

            String  sql="SELECT * FROM StudentDetails WHERE StudId=?";
            try(PreparedStatement pstmt=con.prepareStatement(sql)){
                pstmt.setString(1,studentId);
                try(ResultSet rs=pstmt.executeQuery()){
                    if(rs.next()){
                        System.out.println("Student Details:");
                        System.out.println("Name: " + rs.getString("StudName"));
                        System.out.println("ID: " + rs.getString("StudId"));
                        System.out.println("Branch: " + rs.getString("Branch"));
                        System.out.println("Section: " + rs.getString("Section"));
                        System.out.println("Address: " + rs.getString("Address"));
                    }else{
                        System.out.println("Student ID not found");
                    }
                }
            }      
         }catch(SQLException e){
            System.err.println("Error: "+e.getMessage());
            e.printStackTrace();
         }
    }
}