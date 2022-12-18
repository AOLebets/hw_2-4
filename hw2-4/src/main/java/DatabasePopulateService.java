import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.FileSystems;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) throws SQLException {

        //Before executing this method execute DatabaseInitService (1) first!

        Connection conn = Database.getInstance().getConnection();

        try {
            String baseLine;
            StringBuilder resultSQL = new StringBuilder();
            String separator = FileSystems.getDefault().getSeparator();
            File file = new File("sql" + separator + "populate_db.sql");
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
