import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSample {

    public static void main(String[] argv) {

        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE", "rice", "rice");
            
            if (connection != null) {
            	System.out.println("TestSample.main()"+connection.getMetaData());
                System.out.println("You made it, take control your database now!");
                Statement st = connection.createStatement();

                ResultSet rs =  st.executeQuery("select * from XX_CUSTOMER_HEADERS");
                while(rs.next()){
                	System.out.println("TestSample.main()"+rs.getString("customer_no"));
                }
            } else {
                System.out.println("Failed to make connection!");
            }
           
        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

       
    }

}

