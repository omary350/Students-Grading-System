package com.Model;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;*/
import java.sql.*;
import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;



public class databaseConnection {
   

   

    private databaseConnection() {
        // private constructor to prevent instantiation
    }
//Enter MySql Database info
        private static DataSource getDataSource(){
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName("");
            dataSource.setPort();
            dataSource.setDatabaseName("studentgradesystem");
            dataSource.setUser("");
            dataSource.setPassword("");
            return dataSource;
        }
    public static Connection getConnection() throws SQLException {
       DataSource dataSource = getDataSource();
       return dataSource.getConnection();
    }


}



