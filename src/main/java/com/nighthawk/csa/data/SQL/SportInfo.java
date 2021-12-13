package com.nighthawk.csa.data.SQL;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SportInfo {

    private static String servername = "userhost";
    private static String username = "userinfo";
    private static String dbname  = "users_db";
    private static Integer portnumber  = 3306;
    private static String password = "codecodecode";

    public static Connection getConnection()
    {
        Connection sport = null;

        MysqlDataSource datasource = new MysqlDataSource();

        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);

        try {
            sport = datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(" Get Connection -> " + SportInfo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sport;
    }

}