import java.sql.*;
import java.util.Scanner;

class sixth {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "akshey")) {
                System.out.println("1. To delete all students");
                System.out.println("2. To delete students by ID");
                System.out.print("Enter your choice:");
                int choice=scanner.nextInt();
                if(choice==1){
                deleteAllStudents(con);}
                else if(choice==2){
                deleteStudentById(con);}
                else{
                    System.out.println("Invalid Choice!");
                }

            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private static void deleteAllStudents(Connection con) {
        try {
            String sql = "DELETE FROM StudentDetails";
            try (Statement stmt = con.createStatement()) {
                int rowsAffected = stmt.executeUpdate(sql);
                System.out.println("Rows affected: " + rowsAffected);
                System.out.println("All students deleted successfully.");
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void deleteStudentById(Connection con) {
        try {
            System.out.print("Enter Student ID to delete: ");
            int studentId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
    
            String sql = "DELETE FROM StudentDetails WHERE StudId = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, studentId);
    
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Rows affected: " + rowsAffected);
                    System.out.println("Student with ID " + studentId + " deleted successfully.");
                } else {
                    System.out.println("No student found with ID: " + studentId);
                }
            }
    
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    }
