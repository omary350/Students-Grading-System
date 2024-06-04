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

        private static DataSource getDataSource(){
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("studentgradesystem");
            dataSource.setUser("root");
            dataSource.setPassword("omarSql20180394");
            return dataSource;
        }
    public static Connection getConnection() throws SQLException {
       DataSource dataSource = getDataSource();
       return dataSource.getConnection();
    }


}



