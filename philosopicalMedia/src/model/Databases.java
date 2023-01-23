package model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databases {
	
	//Metodo para crear una nueva base de datos en la carpeta /src/databases
	public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:src/databases/" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                conn.close(); //Cerramos la conexion
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	//Metodo para conectarse a la base de datos indicada por parametro
	//Si no existe, la crea
	public static Connection connect(String db) {
        Connection conn = null;
        // db parameters
        String url = "jdbc:sqlite:src/databases/"+ db;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
		return conn;
    }

}
