package iuh.fit.backEnd.Application;

public class ConnectDb {

    private final String DB_URL = "jdbc:mariaDB://localhost:1433;databaseName=QuanLyBanGiayDep;encrypt=true;trustServerCertificate=true";
    private final String USER_NAME = "root";
    private final String PASSWORD = "sapassword";

    public ConnectDb getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        return java.sql.DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }
}
