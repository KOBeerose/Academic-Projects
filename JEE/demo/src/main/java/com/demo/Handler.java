package com.demo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class Handler {
    private Properties properties;
    private ArrayList <Valeur> listValeurs = new ArrayList<Valeur>();

    public Handler() {
        try {
            this.properties.load(Handler.class.getClassLoader().
                    getResourceAsStream("application.properties"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Handler(String a) {
        this();

    }
    public Connection connectSource(String db) throws ClassNotFoundException, SQLException {
        Connection connection = null;

        Class.forName(properties.getProperty("jdbcPath"));
        String url = "jdbc:"+properties.getProperty("protocol")+"://"+properties.getProperty("ip")+ properties.getProperty("port") + "/" + db;
        connection = DriverManager.getConnection(url, properties.getProperty("username"), properties.getProperty("password"));


        return connection;

    }

    public Connection connectTarget(String db) throws ClassNotFoundException, SQLException {
        Connection connection = null;

        Class.forName(properties.getProperty("jdbcPath"));
        String url = "jdbc:"+properties.getProperty("protocol")+"://"+properties.getProperty("ip")+ properties.getProperty("port") + "/" + db;
        connection = DriverManager.getConnection(url, properties.getProperty("username"), properties.getProperty("password"));


        return connection;

    }
    public static void main(String db) {
        try {
            Handler handler = new Handler();
            Connection source = handler.connectSource(db);
            Connection target = handler.connectTarget(db);
            Statement stmtSource = source.createStatement();
            Statement stmtTarget = target.createStatement();
            ResultSet resulatSource = stmtSource.executeQuery("select col1, col2 from table");
            Valeur val = new Valeur();
            while (resulatSource.next())
            {
                val = null;
                val.setMatricule(resulatSource.getInt(1));
                val.setNbrJours(resulatSource.getInt(2));
                handler.listValeurs.add(val);
            }


            for (int i = 0; i <handler.listValeurs.size(); i++)
            {
                int matricule = handler.listValeurs.get(i).getMatricule();
                int nbrJours = handler.listValeurs.get(i).getNbrJours();
                stmtTarget.executeUpdate("update table set nbrjour ="+nbrJours+"where matricule = "+matricule );
            }

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
