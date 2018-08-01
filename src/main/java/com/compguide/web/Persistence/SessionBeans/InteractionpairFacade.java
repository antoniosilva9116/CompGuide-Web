/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compguide.web.Persistence.SessionBeans;

import com.compguide.web.Persistence.Entities.ActiveIngredient;
import com.compguide.web.Persistence.Entities.InteractionPair;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import static javafx.scene.input.KeyCode.T;
import static org.json.XMLTokener.entity;

/**
 *
 * @author anton
 */
@Stateless
public class InteractionpairFacade extends AbstractFacade<InteractionPair> {

    @PersistenceContext(unitName = "com.compguide_CompGuide-Web_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InteractionpairFacade() {
        super(InteractionPair.class);
    }

    public List<InteractionPair> findByActiveIngredientST(ActiveIngredient activeIngredientST) {
        List<InteractionPair> interactionpairList = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("InteractionPair.findByActiveIngredientSTID", InteractionPair.class);
            query.setParameter("activeIngredientSTID", activeIngredientST);

            interactionpairList = query.getResultList();
        } catch (javax.ejb.EJBException | javax.persistence.NoResultException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

        return interactionpairList;
    }

    public List<InteractionPair> findByActiveIngredientND(ActiveIngredient activeIngredientND) {
        List<InteractionPair> interactionpairList = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("InteractionPair.findByActiveIngredientNDID", InteractionPair.class);
            query.setParameter("activeIngredientNDID", activeIngredientND);

            interactionpairList = query.getResultList();
        } catch (javax.ejb.EJBException | javax.persistence.NoResultException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

        return interactionpairList;
    }

    public InteractionPair findByActiveIngredientSTANDActiveIngredientND(ActiveIngredient activeIngredientST, ActiveIngredient activeIngredientND) {
        InteractionPair interactionPair = null;
        System.out.println("activeIngredientSTID = " + activeIngredientST.getActiveIngredientID() + "| activeIngredientNDID = " + activeIngredientND.getActiveIngredientID());

        try {
            Query query = em.createNamedQuery("InteractionPair.findByActiveIngredientSTIDANDActiveIngredientNDID", InteractionPair.class);
            query.setParameter("activeIngredientSTID", activeIngredientST);
            query.setParameter("activeIngredientNDID", activeIngredientND);

            interactionPair = (InteractionPair) query.getSingleResult();
        } catch (javax.ejb.EJBException | javax.persistence.NoResultException | javax.validation.ConstraintViolationException ex) {
            System.out.println("========================================================================================================================");

            System.out.println(((javax.validation.ConstraintViolationException) ex).getConstraintViolations());

            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ((javax.validation.ConstraintViolationException) ex).getConstraintViolations());
        }

        return interactionPair;
    }

}
