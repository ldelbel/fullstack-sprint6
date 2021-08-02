package br.com.rchlo.data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {

    public static void init() {
        runScript("schema.sql");
        runScript("data.sql");
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/rchlo", "root", "Kasparov1@");
        } catch (SQLException ex) {
            throw new IllegalStateException("Error while connecting with database", ex);
        }
    }

    private static void runScript(String script) {
        try {
            Path path = Paths.get(ConnectionFactory.class.getClassLoader().getResource(script).toURI());
            String schema = Files.readString(path);
            try(Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(schema)) {
                preparedStatement.execute();
                System.out.println("Script ran successfully: " + script);
            }
        } catch (IOException | SQLException | URISyntaxException ex) {
            throw new IllegalStateException("Error while processing " + script, ex);
        }
    }

}
