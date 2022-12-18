import java.io.*;
import java.nio.file.FileSystems;
import java.sql.*;

public class DatabaseInitService {
    public static void main(String[] args) throws SQLException {

        //Execute this method first!

        Connection conn = Database.getInstance().getConnection();

        try {
            String baseLine;
            StringBuilder resultSQL = new StringBuilder();
            String separator = FileSystems.getDefault().getSeparator();
            File file = new File("sql" + separator + "init_db.sql");
            BufferedReader input =
                    new BufferedReader(new FileReader(file));
            while ((baseLine = input.readLine()) != null) {
                resultSQL.append(baseLine);
            }
            input.close();
            String query = String.valueOf(resultSQL);
            Statement statement = conn.createStatement();
            statement.execute(query);
            conn.commit();
            statement.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
