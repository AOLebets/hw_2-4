import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException {

        //Before executing this method execute DatabaseInitService (1) and DatabasePopulateService (2) first!

        DatabaseQueryService service = new DatabaseQueryService();

        System.out.println("Printing the longest projects:");
        System.out.println(service.findTheLongestProject().toString());
        System.out.println("Printing the max salary worker:");
        System.out.println(service.findMaxSalaryWorker().toString());
        System.out.println("Printing clients with max projects:");
        System.out.println(service.findMaxProjectsClient().toString());
        System.out.println("Printing the oldest and youngest workers:");
        System.out.println(service.findYoungestEldestWorkers().toString());
        System.out.println("Printing the projects and prices:");
        System.out.println(service.printProjectsAndPrices().toString());

    }
}
