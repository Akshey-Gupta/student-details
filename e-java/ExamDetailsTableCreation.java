import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExamDetailsTableCreation {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "akshey")) {
                createExamDetailsTable(con);
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createExamDetailsTable(Connection con) {
        try {
            String createTableSQL = "CREATE TABLE exam_details ("
                    + "studID VARCHAR2(10), "
                    + "subject VARCHAR2(50), "
                    + "mark INT, "
                    + "status VARCHAR2(20)"
                    + ")";

            try (Statement stmt = con.createStatement()) {
                stmt.executeUpdate(createTableSQL);
                System.out.println("Table 'exam_details' created successfully.");
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
