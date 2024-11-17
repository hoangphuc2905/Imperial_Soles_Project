package iuh.imperial_soles_project.backend.connect;

import java.sql.Connection;

public class DBConnect {
    private final String DB_URL = "jdbc:mariadb://localhost:3306/quanlybangiaydep?createDatabaseIfNotExist=true";
    private final String USER_NAME = "root";
    private final String PASSWORD = "root";

    public Connection getConnection() throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        return java.sql.DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }
}