import java.sql.*;

class second {
    public static void main(String args[]) {
        try {
            // Step 1: Load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Create the connection object
            try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "akshey")) {
                
                // Step 3: Create a PreparedStatement
                String sql = "INSERT INTO StudentDetails (StudName, StudId, Branch, Section, Address) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = con.prepareStatement(sql)) {

                    // Step 4: Set values for parameters
                    pstmt.setString(1, "Akshey");
                    pstmt.setString(2, "2101020004");
                    pstmt.setString(3, "CSE");
                    pstmt.setString(4, "1A");
                    pstmt.setString(5, "Bhubaneswar");
                    

                    // Step 5: Execute the insert statement
                    int rowsAffected = pstmt.executeUpdate();

                    System.out.println("Rows affected: " + rowsAffected);
                    System.out.println("Data inserted successfully.");

                } // Resources are closed automatically due to try-with-resources

            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
