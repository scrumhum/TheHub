import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnect {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/thehub";
    private static final String USER = "root";
    private static final String PASS = "TheHub";

    Connection conn = null;
    Statement st = null;

    private static DBConnect instance;

    DBConnect(){}

    public static synchronized void getInstance() {
        if (instance == null) {
            instance = new DBConnect();
        }

    }


    public void dbConnect() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            st = conn.createStatement();
            Class.forName(DRIVER);
            System.out.println("Connecting to database...");
            String sql = "USE thehub;";
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
