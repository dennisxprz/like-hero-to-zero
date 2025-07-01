package de.likeherotozero.test;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@Named
@ApplicationScoped
public class DataSourceTestBean {

    private String message;

    public String getMessage() {
        return message;
    }

    public void testJndiLookup() {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:openejb/Resource/MySqlDS");
            if (ds != null) {
                message = "DataSource erfolgreich gefunden!";
            } else {
                message = "DataSource NICHT gefunden!";
            }
        } catch (NamingException e) {
            message = "Fehler beim JNDI-Lookup: " + e.getMessage();
            e.printStackTrace();
        }
    }
}
