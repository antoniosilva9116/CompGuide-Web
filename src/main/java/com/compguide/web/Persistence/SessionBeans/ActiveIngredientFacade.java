/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compguide.web.Persistence.SessionBeans;

import com.compguide.web.Persistence.Entities.ActiveIngredient;
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
public class ActiveIngredientFacade extends AbstractFacade<ActiveIngredient> {

    @PersistenceContext(unitName = "com.compguide_CompGuide-Web_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActiveIngredientFacade() {
        super(ActiveIngredient.class);
    }

    public ActiveIngredient findByName(String name) {
        ActiveIngredient activeIngredient = null;
        try {
            Query query = em.createNamedQuery("ActiveIngredient.findByName", ActiveIngredient.class);
            query.setParameter("name", name);
            activeIngredient = (ActiveIngredient) query.getSingleResult();
        } catch (javax.ejb.EJBException | javax.persistence.NoResultException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

        return activeIngredient;
    }

}
