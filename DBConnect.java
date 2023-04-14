import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnect {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://192.168.72.21:3306/thehub";

    //User log in for DB
    static final String USER = "TheHub";
    static final String PASS = "$TheHub2023$";

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
