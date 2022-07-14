package com.aoop_p.easymedilife.dbmanager;
import android.support.v4.os.IResultReceiver;

import org.mariadb.jdbc.*;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private Driver d = new Driver();
    private String url = "jdbc:mariadb://";
    private java.sql.Connection con;
    private java.sql.Statement state;

    public DBManager(String dburl)
    {
        url = url+dburl;
    }
    public DBManager()
    {
        url = url+"localhost/easymedilife";
    }

    public boolean connect()
    {
        try {
            con = DriverManager.getConnection(url);
            state = con.createStatement();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
