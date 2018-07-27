package com.compguide.web.Utils;

import com.compguide.web.Execution.Entities.ClinicalTask;
import com.compguide.web.Execution.Entities.ProcessedTask;
import com.compguide.web.Execution.Entities.TaskController;
import com.compguide.web.DataBase.Beans.GuideexecBean;
import com.compguide.web.DataBase.Beans.GuideexecManager;
import com.compguide.web.Execution.Entities.Action;
import com.compguide.web.Execution.Entities.ClinicalAction;
import com.compguide.web.Execution.Entities.MedicationRecommendation;
import com.compguide.web.Factories.GuidelineAdapterFactory;
import com.compguide.web.Persistence.Entities.ActiveIngredient;
import com.compguide.web.Persistence.Entities.GuideExec;
import com.compguide.web.Persistence.Entities.MedicationTask;
import com.compguide.web.Persistence.Entities.ScheduleTask;
import com.compguide.web.Persistence.Entities.Task;
import com.compguide.web.Persistence.Entities.TemporalElement;
import com.google.api.client.repackaged.com.google.common.base.Objects;
import com.google.gson.Gson;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA. User: andre Date: 12/1/12 Time: 6:27 PM
 */
public class Utils {

    public static String generateRandomKey(int length) {
        SecureRandom random = new SecureRandom();
        String key = new BigInteger(130, random).toString(32);

        return key.substring(0, (key.length() > length) ? length : key.length() - 1);
    }

    public static String parseId(String id) {
        Pattern pattern = Pattern.compile("#(.*?)#");
        Matcher matcher = pattern.matcher(id);
        if (matcher.find()) {
            return (matcher.group(1));
        }
        return null;
    }

    public static String getOperator(String conditionOperator) {
        if (conditionOperator.equals("Equal_to")) {
            return "=";
        }
        if (conditionOperator.equals("Different_from")) {
            return "!=";
        }
        if (conditionOperator.equals("Greater_or_equal_than")) {
            return ">=";
        }
        if (conditionOperator.equals("Greater_than")) {
            return ">";
        }
        if (conditionOperator.equals("Less_or_equal_than")) {
            return "<=";
        }
        if (conditionOperator.equals("Less_than")) {
            return "<";
        }
        return null;
    }

    public static List<Task> processedTaskToTaskList(GuideExec guideExec, ProcessedTask processedTask) {
        Gson gson = new Gson();
        GuideexecBean guideexecBean = GuideexecManager.getInstance().getGuideexecBeanByID(guideExec.getIdguideexec().toString());
        TaskController taskController = gson.fromJson(guideexecBean.getNextTasks(), TaskController.class);

        List<Task> tasks = new ArrayList<>();

        for (ClinicalTask clinicalTask : processedTask.getTasks()) {
            Task task = new Task(new Date(), clinicalTask.getTaskType(),
                    clinicalTask.getTaskFormat(), clinicalTask.getGeneralDescription(),
                    clinicalTask.getId(), null, taskController.toJson(), false, 0,
                    guideExec);
            tasks.add(task);

        }

        return tasks;
    }

    public static List<ScheduleTask> processedTaskToScheduleTaskList(GuideExec guideExec, ProcessedTask processedTask) {
        Gson gson = new Gson();
        GuideexecBean guideexecBean = GuideexecManager.getInstance().getGuideexecBeanByID(guideExec.getIdguideexec().toString());
        TaskController taskController = gson.fromJson(guideexecBean.getNextTasks(), TaskController.class);

        List<ScheduleTask> tasks = new ArrayList<>();

        for (ClinicalTask clinicalTask : processedTask.getTasks()) {
            ScheduleTask task = new ScheduleTask(clinicalTask.getTaskType(),
                    clinicalTask.getTaskFormat(), clinicalTask.getGeneralDescription(),
                    clinicalTask.getId(), null, taskController.toJson(), false, 0,
                    null, new Date(), guideExec);
            System.out.println(clinicalTask.getTaskType());
            tasks.add(task);

        }

        return tasks;
    }

    public static ActiveIngredient getActiveIngredientByRxcui(MedicationTask medicationtasks, String rxcui) {

        for (ActiveIngredient activeIngredient : medicationtasks.getActiveIngredientList()) {
            if (Objects.equal(activeIngredient.getRxCui(), rxcui)) {
                return activeIngredient;
            }
        }

        return null;
    }

    public static ActiveIngredient getActiveIngredientByRxcui(List<ActiveIngredient> activeIngredients, String rxcui) {

        for (ActiveIngredient activeIngredient : activeIngredients) {
            if (Objects.equal(activeIngredient.getRxCui(), rxcui)) {
                return activeIngredient;
            }
        }

        return null;
    }
}
