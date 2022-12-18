import java.sql.*;

class Database {
    private static Database single_instance = null;
    private static Connection conn = null;
    static final String jdbcDriver = "org.h2.Driver";
    static final String dbUrl = "jdbc:h2:~/test";
    private String user = "sa";
    private String pass = "sa";
    private Database() throws SQLException {
        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(dbUrl, user, pass);
        } catch (SQLException | ClassNotFoundException e ) {
        e.printStackTrace();
        }
    }

    public static Database getInstance() throws SQLException {
        if (single_instance == null) {
            single_instance = new Database();
        }
        return single_instance;
    }

    public static Connection getConnection() {
        return conn;
    }
}