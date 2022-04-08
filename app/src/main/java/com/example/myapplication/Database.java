package com.example.myapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.concurrent.Callable;

public class Database {

    private Connection connection;
    private Statement statement;
    private final String host = "217.25.230.151";

    private final String database = "niggerfaggot";
    private final int port = 5432;
    private final String user = "postgres";
    private final String pass = "postgre";
    private String url = "jdbc:postgresql://%s:%d/%s";
    private boolean status;

    public Database() throws SQLException {
        this.url = String.format(this.url, this.host, this.port, this.database);
        connect();
        statement = connection.createStatement();
        //this.disconnect();
        System.out.println("connection status:" + status);
    }

    private void connect()
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try
                {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
                    System.out.println("connected:" + status);
                }
                catch (Exception e)
                {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try
        {
            thread.join();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            this.status = false;
        }
    }

    public Connection getExtraConnection()
    {
        Connection c = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, user, pass);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return c;
    }

    public ResultSet GetTaskLDS() throws SQLException {
        ResultSet rs = null;
        String selectSql = "SELECT * FROM lds_word";
        rs = statement.executeQuery(selectSql);
        while (rs.next()){
            System.out.print(rs);
        }
        return rs;
    }

}
