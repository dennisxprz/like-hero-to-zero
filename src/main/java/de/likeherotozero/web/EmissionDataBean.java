package de.likeherotozero.web;

import de.likeherotozero.model.EmissionData;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Named
@RequestScoped
public class EmissionDataBean {

    @PersistenceContext(unitName = "co2PU")
    private EntityManager em;

    public List<EmissionData> getAllData() {
        return em.createQuery("SELECT e FROM EmissionData e", EmissionData.class)
                 .getResultList();
    }
}
