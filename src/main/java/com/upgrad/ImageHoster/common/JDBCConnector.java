package com.upgrad.ImageHoster.common;

import java.sql.*;

public class JDBCConnector {
    public static final String DB_DRIVER="org.postgresql.Driver";
    public static final String DB_URL="jdbc:postgresql://localhost:5432/technicalblog";
    public static final String USER="postgres";
    public static final String PASSWORD="admin";
    private Connection connection= null;
    private Statement statement=null;
    private JDBCConnector()
    {
        try {
            Class.forName(DB_DRIVER);
            try {
                connection= DriverManager.getConnection(DB_URL,USER,PASSWORD);
                statement=connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static JDBCConnector jdbcConnector=new JDBCConnector();
    public static JDBCConnector getInstance()
    {
        return jdbcConnector;
    }

    public ResultSet executeQuery(final String query)
    {
        try {
          return  statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void execute(String query)
    {
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        JDBCConnector jdbcConnector=JDBCConnector.getInstance();
        //jdbcConnector.execute("create table posts(id SERIAL PRIMARY KEY,title varchar,body varchar,date timestamp)");
    }
}
