/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compguide.web.Persistence.SessionBeans;

import com.compguide.web.Persistence.Entities.MedicationTask;
import com.compguide.web.Persistence.Entities.ScheduleTask;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author António
 */
@Stateless
public class MedicationTaskFacade extends AbstractFacade<MedicationTask> {

    @PersistenceContext(unitName = "com.compguide_CompGuide-Web_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicationTaskFacade() {
        super(MedicationTask.class);
    }

    public List<MedicationTask> findByScheduleTask(ScheduleTask scheduleTask) {
        List<MedicationTask> medicationtasks = new ArrayList<>();
        try {
            Query query = em.createNamedQuery("MedicationTask.findByScheduleTaskID", MedicationTask.class);
            query.setParameter("scheduleTaskID", scheduleTask);

            medicationtasks = query.getResultList();
        } catch (javax.ejb.EJBException | javax.persistence.NoResultException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

        return medicationtasks;
    }

    public MedicationTask findByActiveIngredient(String activeIngredient) {
        MedicationTask medicationtask = null;
        try {
            Query query = em.createNamedQuery("MedicationTask.findByActiveIngredient", MedicationTask.class);
            query.setParameter("activeIngredient", activeIngredient);

            medicationtask = (MedicationTask) query.getSingleResult();
        } catch (javax.ejb.EJBException | javax.persistence.NoResultException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }

        return medicationtask;
    }
}
