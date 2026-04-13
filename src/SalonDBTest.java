import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class SalonDBTest
{
    public static void main(String[] args)
    {
        String url = "jdbc:sqlite:C:/Users/danie/OneDrive/salon.db";

        try
        {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Payment");

            System.out.println("Payment List:");
            while (rs.next())
            {
                System.out.println(
                    rs.getInt("payment_id") + " | " +
                    rs.getInt("appointment_id") + " | " +
                    rs.getDouble("amount") + " | " +
                    rs.getString("payment_method")
                );
            }

            rs.close();
            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println("Select payments failed.");
            e.printStackTrace();
        }
    }
}