package jdbc;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class JDBCexample {
    public static void main(String[] args){
        Connection connection = null;
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/StudentDB", "root", "Root123$"
            );
            // Create statement
            Statement statement = connection.createStatement();
            // Execute query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Student");
            // Process results
            while (resultSet.next()) {
                int id = resultSet.getInt("ROLL_NO");
                String name = resultSet.getString("NAMEE").trim();
                String address = resultSet.getString("ADDRESS").trim();
                String phone  = resultSet.getString("PHONE");
                int age = resultSet.getInt("AGE");
                System.out.println("Id: " + id + " | Name: " + name+ "| Address "+ address + "|Phone : " + phone 
                		+ "|Age : " + age );
            }
            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}