/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compguide.web.Adapters;

import com.compguide.web.Execution.Entities.Action;
import com.compguide.web.Execution.Entities.ClinicalAction;
import com.compguide.web.Execution.Entities.ClinicalTask;
import com.compguide.web.Execution.Entities.MedicationRecommendation;
import com.compguide.web.Persistence.Entities.ActiveIngredient;
import com.compguide.web.Persistence.Entities.MedicationTask;
import com.compguide.web.Persistence.Entities.ScheduleTask;
import com.compguide.web.Persistence.SessionBeans.ActiveIngredientFacade;
import com.compguide.web.Persistence.SessionBeans.MedicationTaskFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ejb.EJB;

/**
 *
 * @author anton
 */
@Named
@SessionScoped
public class MedicationTaskAdapter implements GuidelineInterface, Serializable {

    private ScheduleTask scheduleTask;

    private List<MedicationTask> medicationTasks;

    @EJB
    private com.compguide.web.Persistence.SessionBeans.MedicationTaskFacade ejbMedicationTaskFacade;
    @EJB
    private com.compguide.web.Persistence.SessionBeans.ActiveIngredientFacade ejbActiveIngredientFacade;

    @Override
    public GuidelineInterface fetchTemporalPatternFromClinicaltask(ClinicalTask task) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getObject() {
        return medicationTasks;
    }

    @Override
    public void passObject(Object object) {
        if (object instanceof ScheduleTask) {
            scheduleTask = (ScheduleTask) object;
        }
    }

    public MedicationTaskFacade getMedicationTaskFacade() {
        return ejbMedicationTaskFacade;
    }

    public ActiveIngredientFacade getActiveIngredientFacade() {
        return ejbActiveIngredientFacade;
    }

    @Override
    public GuidelineInterface fetchMedicationTasksFromClinicalTask(ClinicalTask task) {
        medicationTasks = new ArrayList<>();

        if (task instanceof Action
                && !((Action) task).getClinicalActions().isEmpty()) {

            for (ClinicalAction clinicalAction : ((Action) task).getClinicalActions()) {
                if (clinicalAction instanceof MedicationRecommendation) {
                    String activeIngredient = ((MedicationRecommendation) clinicalAction).getActiveIngredient();
                    String dosage = ((MedicationRecommendation) clinicalAction).getDosage();
                    String pharmaceuticalForm = ((MedicationRecommendation) clinicalAction).getPharmaceuticalForm();
                    String posology = ((MedicationRecommendation) clinicalAction).getPosology();

                    MedicationTask medicationTask = getMedicationTaskFacade().findByActiveIngredient(activeIngredient.trim());

                    if (Objects.isNull(medicationTask)) {
                        medicationTask = new MedicationTask();

                        medicationTask.setActiveIngredient(activeIngredient.trim());
                        medicationTask.setDosage(dosage);
                        medicationTask.setPharmaceuticalForm(pharmaceuticalForm);
                        medicationTask.setPosology(posology);
                        medicationTask.setScheduleTaskID(scheduleTask);

                        getMedicationTaskFacade().create(medicationTask);

                        String[] activeIngredientStrings = activeIngredient.split("-");

                        for (String activeIngredient1 : activeIngredientStrings) {
                            if (Objects.equals(activeIngredient1.trim(), "fluorouracil")) {
                                activeIngredient1 = "5-fluorouracil";
                            }

                            if (!Objects.equals(activeIngredient1.trim(), "5") && !activeIngredient1.isEmpty()) {

                                ActiveIngredient ingredient = getActiveIngredientFacade().findByName(activeIngredient1.trim());

                                if (Objects.isNull(ingredient)) {
                                    ingredient = new ActiveIngredient();

                                    ingredient.setName(activeIngredient1.trim());
                                    ingredient.setMedicationTaskList(Arrays.asList(medicationTask));
                                    ingredient.addMedicationTask(medicationTask);

                                    getActiveIngredientFacade().create(ingredient);
                                } else {
                                    ingredient.addMedicationTask(medicationTask);
                                    
                                    getActiveIngredientFacade().edit(ingredient);
                                }
                                
                                medicationTask.addActiveIngredient(ingredient);
                            }
                        }

                        getMedicationTaskFacade().edit(medicationTask);

                    }

                    medicationTasks.add(medicationTask);
                }
            }
            scheduleTask.setMedicationTaskList(medicationTasks);
        }
        return this;
    }
}
