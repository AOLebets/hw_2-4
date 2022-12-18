import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.FileSystems;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    Connection conn = Database.getInstance().getConnection();

    public DatabaseQueryService() throws SQLException {
    }

    public static class LongestProject {
        private String projectName;
        private int projectDuration;
        public void setProjectName(String projectName) { this.projectName = projectName; }
        public void setProjectDuration(int projectDuration) { this.projectDuration = projectDuration; }
        public String getProjectName() { return projectName; }
        public int getProjectDuration() { return projectDuration; }

        @Override
        public String toString(){
            return "Project ID: " + this.getProjectName() + ", Project duration: " + this.getProjectDuration() + "\n";
        }
    }
    List<LongestProject> findTheLongestProject() {

        List<LongestProject> resultList = new ArrayList<>();
        try {
            String baseLine;
            StringBuilder resultSQL = new StringBuilder();
            String separator = FileSystems.getDefault().getSeparator();
            File file = new File("sql" + separator + "find_longest_project.sql");
            BufferedReader input =
                    new BufferedReader(new FileReader(file));
            while ((baseLine = input.readLine()) != null) {
                resultSQL.append(baseLine + " ");
            }
            input.close();
            String query = String.valueOf(resultSQL);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            conn.commit();
            while (rs.next()) {
                LongestProject lp = new LongestProject();
                lp.setProjectName(rs.getString("ID"));
                lp.setProjectDuration(rs.getInt("MONTH_COUNT"));
                resultList.add(lp);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;

    }

    public static class MaxProjectCountClient {
        private String name;
        private int projectCount;
        public void setName(String name) { this.name = name; }
        public void setProjectCount(int projectCount) { this.projectCount = projectCount; }
        public String getName() { return name; }
        public int getProjectCount() { return projectCount; }

        @Override
        public String toString() {
            return "Name: " + this.getName() + ", Project count: " + this.getProjectCount() + "\n";
        }
    }
    List<MaxProjectCountClient> findMaxProjectsClient() {

        List<MaxProjectCountClient> resultList = new ArrayList<>();
        try {
            String baseLine;
            StringBuilder resultSQL = new StringBuilder();
            String separator = FileSystems.getDefault().getSeparator();
            File file = new File("sql" + separator + "find_max_projects_client.sql");
            BufferedReader input =
                    new BufferedReader(new FileReader(file));
            while ((baseLine = input.readLine()) != null) {
                resultSQL.append(baseLine + " ");
            }
            input.close();
            String query = String.valueOf(resultSQL);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            conn.commit();
            while (rs.next()) {
                MaxProjectCountClient mpcc = new MaxProjectCountClient();
                mpcc.setName(rs.getString("NAME"));
                mpcc.setProjectCount(rs.getInt("PROJECT_COUNT"));
                resultList.add(mpcc);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;

    }

    public static class MaxSalaryWorker {
        private String name;
        private int salary;
        public void setName(String name) { this.name = name; }
        public void setSalary(int salary) { this.salary = salary; }
        public String getName() { return name; }
        public int getSalary() { return salary; }

        @Override
        public String toString(){
            return "Name: " + this.getName() + ", Salary: " + this.getSalary() + "\n";
        }
    }
    List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> resultList = new ArrayList<>();
        try {
            String baseLine;
            StringBuilder resultSQL = new StringBuilder();
            String separator = FileSystems.getDefault().getSeparator();
            File file = new File("sql" + separator + "find_max_salary_worker.sql");
            BufferedReader input =
                    new BufferedReader(new FileReader(file));
            while ((baseLine = input.readLine()) != null) {
                resultSQL.append(baseLine + " ");
            }
            input.close();

            String query = String.valueOf(resultSQL);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            conn.commit();

            while (rs.next()) {
                MaxSalaryWorker msw = new MaxSalaryWorker();
                msw.setName(rs.getString("NAME"));
                msw.setSalary(rs.getInt("SALARY"));
                resultList.add(msw);
            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;

    }

    public static class YoungestEldestWorkers {
        private String name;
        private String type;
        private Date birthday;
        public void setName(String name) { this.name = name; }
        public void setType(String type) { this.type = type; }
        public void setBirthday(Date birthday) { this.birthday = birthday; }
        public String getName() { return name; }
        public String getType() { return type; }
        public Date getBirthday() { return birthday; }

        @Override
        public String toString(){
            return "Name: " + this.getName() + ", Type: " + this.getType() + ", Birthday: " + this.getBirthday() + "\n";
        }
    }
    List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        List<YoungestEldestWorkers> resultList = new ArrayList<>();
        try {
            String baseLine;
            StringBuilder resultSQL = new StringBuilder();
            String separator = FileSystems.getDefault().getSeparator();
            File file = new File("sql" + separator + "find_youngest_eldest_workers.sql");
            BufferedReader input =
                    new BufferedReader(new FileReader(file));
            while ((baseLine = input.readLine()) != null) {
                resultSQL.append(baseLine + " ");
            }
            input.close();

            String query = String.valueOf(resultSQL);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            conn.commit();

            while (rs.next()) {
                YoungestEldestWorkers yew = new YoungestEldestWorkers();
                yew.setName(rs.getString("NAME"));
                yew.setType(rs.getString("TYPE"));
                yew.setBirthday(rs.getDate("BIRTHDAY"));
                resultList.add(yew);
            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;

    }

    public static class ProjectsAndPrices {
        private int id;
        private int price;
        public void setId(int id) { this.id = id; }
        public void setPrice(int price) { this.price = price; }
        public int getId() { return id; }
        public int getPrice() { return price; }

        @Override
        public String toString(){
            return "ProjectID: " + this.getId() + ", Price: " + this.getPrice() + "\n";
        }
    }
    List<ProjectsAndPrices> printProjectsAndPrices() {
        List<ProjectsAndPrices> resultList = new ArrayList<>();
        try {
            String baseLine;
            StringBuilder resultSQL = new StringBuilder();
            String separator = FileSystems.getDefault().getSeparator();
            File file = new File("sql" + separator + "print_project_prices.sql");
            BufferedReader input =
                    new BufferedReader(new FileReader(file));
            while ((baseLine = input.readLine()) != null) {
                resultSQL.append(baseLine + " ");
            }
            input.close();

            String query = String.valueOf(resultSQL);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);

            conn.commit();

            while (rs.next()) {
                ProjectsAndPrices pap = new ProjectsAndPrices();
                pap.setId(rs.getInt("ID"));
                pap.setPrice(rs.getInt("PROJECT_PRICE"));
                resultList.add(pap);
            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;

    }


}
