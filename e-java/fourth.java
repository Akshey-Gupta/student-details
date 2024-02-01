import java.sql.*;
import java.util.Scanner;

class fourth {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "akshey")) {
                insertStudentDetails(con);
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertStudentDetails(Connection con) {
        try {
            String sql = "INSERT INTO StudentDetails (StudName, StudId, Branch, Section, Address) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                System.out.print("Enter Student Name: ");
                pstmt.setString(1, scanner.nextLine());

                System.out.print("Enter Student ID: ");
                pstmt.setString(2, scanner.nextLine());

                System.out.print("Enter Branch: ");
                pstmt.setString(3, scanner.nextLine());

                System.out.print("Enter Section: ");
                pstmt.setString(4, scanner.nextLine());

                System.out.print("Enter Address: ");
                pstmt.setString(5, scanner.nextLine());

                int rowsAffected = pstmt.executeUpdate();
                System.out.println("Rows affected: " + rowsAffected);
                System.out.println("Data inserted successfully.");
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
