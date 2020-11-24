package com.example.helloworld.connect;

public class DatabaseConfiguration {
    private final String url;

    private final String dbname;

    private final String driver;

    private final String username;

    private final String password;

    public DatabaseConfiguration(String url, String dbname, String driver , String username,String  password)
    {
        this.url = url;
        this.dbname = dbname;
        this.driver = driver;
        this.username = username;
        this.password = password;
    }

    public String getUrl()
    {
        return this.url;
    }

    public String getDbname()
    {
        return this.dbname;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getDriver(){
        return this.driver;
    }

}
