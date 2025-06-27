package de.likeherotozero.beans;

import de.likeherotozero.model.EmissionData;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class EmissionBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "co2PU")
    private EntityManager entityManager;

    private EmissionData newData = new EmissionData();
    private EmissionData selected;
    private String selectedCountry;
    private EmissionData latestData;

    // ========================
    // Initialisierung
    // ========================

    @PostConstruct
    public void init() {
        checkLogin();
    }

    // ========================
    // Getter & Setter
    // ========================

    public EmissionData getNewData() {
        return newData;
    }

    public EmissionData getSelected() {
        return selected;
    }

    public void setSelected(EmissionData selected) {
        this.selected = selected;
    }

    public String getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(String selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

    public EmissionData getLatestData() {
        return latestData;
    }

    // ========================
    // Datenbankzugriff
    // ========================

    public List<EmissionData> getEmissionList() {
        return entityManager.createQuery("SELECT e FROM EmissionData e", EmissionData.class)
                            .getResultList();
    }

    public List<String> getDistinctCountries() {
        return entityManager.createQuery("SELECT DISTINCT e.country FROM EmissionData e ORDER BY e.country", String.class)
                            .getResultList();
    }

    public void fetchLatestData() {
        if (selectedCountry == null || selectedCountry.isBlank()) {
            addMessage("⚠️ Bitte ein Land auswählen.");
            latestData = null;
            return;
        }

        try {
            latestData = entityManager.createQuery(
                    "SELECT e FROM EmissionData e WHERE e.country = :country AND e.year = (" +
                            "SELECT MAX(e2.year) FROM EmissionData e2 WHERE e2.country = :country)",
                    EmissionData.class)
                    .setParameter("country", selectedCountry)
                    .getSingleResult();
        } catch (Exception e) {
            // Optional: Logger verwenden statt e.printStackTrace()
            latestData = null;
            addMessage("⚠️ Es konnte kein aktueller Datensatz gefunden werden.");
        }
    }

    // ========================
    // CRUD-Methoden
    // ========================

    @Transactional
    public String save() {
        try {
            entityManager.persist(newData);
            addMessage("✅ Datensatz erfolgreich gespeichert: " + newData.getCountry());
        } catch (Exception e) {
            addMessage("❌ Fehler beim Speichern!");
        }
        return "index.xhtml?faces-redirect=true";
    }

    @Transactional
    public String update() {
        try {
            entityManager.merge(selected);
            addMessage("✅ Änderungen gespeichert für: " + selected.getCountry());
        } catch (Exception e) {
            addMessage("❌ Fehler beim Aktualisieren!");
        }
        return "index.xhtml?faces-redirect=true";
    }

    @Transactional
    public String delete(EmissionData data) {
        try {
            EmissionData toRemove = entityManager.merge(data);
            entityManager.remove(toRemove);
            addMessage("🗑️ Datensatz gelöscht: " + toRemove.getCountry());
        } catch (Exception e) {
            addMessage("❌ Fehler beim Löschen!");
        }
        return "index.xhtml?faces-redirect=true";
    }

    // ========================
    // Login-Schutz
    // ========================

    public void checkLogin() {
        FacesContext context = FacesContext.getCurrentInstance();
        LoginBean loginBean = context.getApplication()
                                     .evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
        if (!loginBean.isLoggedIn()) {
            try {
                context.getExternalContext().redirect("login.xhtml");
            } catch (IOException e) {
                addMessage("❌ Fehler bei der Weiterleitung zum Login.");
            }
        }
    }

    // ========================
    // Message-Helfer
    // ========================

    private void addMessage(String summary) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        context.addMessage(null, new FacesMessage(summary));
    }
}
