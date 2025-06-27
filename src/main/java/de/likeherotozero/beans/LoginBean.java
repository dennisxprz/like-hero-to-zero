package de.likeherotozero.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.faces.context.FacesContext;

import java.io.Serializable;
import java.io.IOException;

@Named
@SessionScoped
public class LoginBean implements Serializable {

    private String username;
    private String password;
    private boolean loggedIn = false;

    public String login() {
        if ("forschung".equals(username) && "klima2024".equals(password)) {
            loggedIn = true;
            return "add.xhtml?faces-redirect=true";
        } else {
            return "login.xhtml?faces-redirect=true";
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void logout() {
        loggedIn = false;
        username = null;
        password = null;

        // Session invalidieren
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().invalidateSession();

        try {
            facesContext.getExternalContext().redirect("login.xhtml");
        } catch (IOException e) {
            e.printStackTrace(); // optional: Logging
        }
    }

    // Getter & Setter
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
