/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compguide.web.Persistence.SessionBeans;

import com.compguide.web.Persistence.Entities.ActiveIngredient;
import com.compguide.web.Persistence.Entities.SimilarMedication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author anton
 */
@Stateless
public class SimilarmedicationFacade extends AbstractFacade<SimilarMedication> {

    @PersistenceContext(unitName = "com.compguide_CompGuide-Web_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SimilarmedicationFacade() {
        super(SimilarMedication.class);
    }

    public List<SimilarMedication> findByActiveIngredientID(List<ActiveIngredient> activeIngredients) {
        List<SimilarMedication> similarmedicationList = new ArrayList<>();

        try {
            Query query = em.createNamedQuery("SimilarMedication.findByActiveIngredientID", SimilarMedication.class);
            query.setParameter("activeIngredientList", activeIngredients);

            similarmedicationList = query.getResultList();
        } catch (javax.ejb.EJBException | javax.persistence.NoResultException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

        return similarmedicationList;
    }

    public SimilarMedication findByClassName(String className) {
        SimilarMedication similarmedication = null;
        try {
            Query query = em.createNamedQuery("SimilarMedication.findByClassName", SimilarMedication.class);
            query.setParameter("className", className);

            similarmedication = (SimilarMedication) query.getSingleResult();;
        } catch (javax.ejb.EJBException | javax.persistence.NoResultException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

        return similarmedication;
    }
}
