/*
 * Conectar esta clase nos permite conectarnos ala bd
 */
package clases;

import java.sql.*;

/**
 *
 * @author Gustavo
 */
public class Conectar {
    
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/taller corralon 2";

    public Conectar() {
        conn = null;
        try {
            Class.forName(driver);
            conn  = DriverManager.getConnection(url, user, password);
            if(conn != null)
                System.out.println("Conexion establecida");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de Conexion " + e);
        }
    }
    
    //getConnection retorna la conexion de la bd
    public Connection getConnection(){
        return conn;    
    }
    
    //desconectar desconecta de la bd
    public void desconectar(){
        conn = null;
        if(conn == null)
        System.out.println("La conexion ha finalizado exitosamente");
    }
    
    
    
    
}
