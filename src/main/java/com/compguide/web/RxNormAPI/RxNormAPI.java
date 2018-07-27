/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compguide.web.RxNormAPI;

import WebService.HttpManager;
import com.compguide.web.Persistence.Entities.ActiveIngredient;
import com.compguide.web.Persistence.Entities.InteractionPair;
import com.compguide.web.Persistence.Entities.MedicationTask;
import com.compguide.web.Persistence.Entities.SimilarMedication;
import java.util.ArrayList;
import java.util.List;
import org.json.*;
import com.compguide.web.Utils.Utils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author anton
 */
public class RxNormAPI {

    private static String rxNormBaseURI = "https://rxnav.nlm.nih.gov/REST/";
    private static String rxNormURI = "https://mor.nlm.nih.gov";

    private static String DRUG_SOURCES = "atc1-4|atc,epc|dailymed,meshpa|mesh,disease|medrt,chem|dailymed,moa|dailymed,pe|dailymed,pk|medrt,tc|fmtsme,va|va";

    private static RxNormAPI instance;

    public synchronized static RxNormAPI instance() {

        if (instance == null) {
            instance = new RxNormAPI();
        }

        return instance;
    }

    /**
     *
     * @param classname The name of the drug. E.g: sulfonylurea
     * @return
     */
    public String searchByClassName(String classname, boolean isIngridientOnly) {
        HttpManager http = new HttpManager();

        /* 
        	var queryData = {
		query : query.trim(),
		searchBy : searchBy.trim(), "class"
		sourceIds : sourceIds.trim(),
		drugSources : searchDrugSources.trim(),
		isIngredientOnly : getIngredientOnlyStatus()
        e.g: 
{query: "Sulfonylurea", searchBy: "class", sourceIds: "", drugSources: "atc1-4|atc,epc|dailymed,meshpa|mesh,disease|medrt,…moa|dailymed,pe|dailymed,pk|medrt,tc|fmtsme,va|va", isIngredientOnly: true}
	};

         */
        JSONObject json = new JSONObject();
        json.put("query", classname);
        json.put("searchBy", "class");
        json.put("sourceIds", "");
        json.put("drugSources", DRUG_SOURCES);
        json.put("isIngredientOnly", isIngridientOnly);

        http.setURL(rxNormURI + "/RxClass/getSearch");

        ArrayList<BasicNameValuePair> valuePair = new ArrayList<BasicNameValuePair>();
        valuePair.add(new BasicNameValuePair("data", json.toString()));

        http.setValuePairs(valuePair);
        String response = http.sendSearchGET();

        JSONObject obj = new JSONObject(response);
        JSONArray array = obj.getJSONObject("rxclassMinConceptList").getJSONArray("rxclassMinConcept");

        return ((JSONObject) array.get(0)).get("classId").toString();

    }

    public String getClassIDByClassName(String classname) {

        HttpManager http = new HttpManager();

        try {
            http.setURL(rxNormBaseURI + "rxclass/class/byName.json?className=" + URLEncoder.encode(classname, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(RxNormAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        String response = http.sendSearchGET();

        JSONObject obj = new JSONObject(response);
        JSONArray array = obj.getJSONObject("rxclassMinConceptList").getJSONArray("rxclassMinConcept");

        return ((JSONObject) array.get(0)).get("classId").toString();
    }

    public String getRxcuiByName(String name) {

        HttpManager http = new HttpManager();

        try {
            http.setURL(rxNormBaseURI + "rxcui.json?name=" + URLEncoder.encode(name, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(RxNormAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        String response = http.sendSearchGET();

        JSONObject obj = new JSONObject(response);
        JSONArray array = obj.getJSONObject("idGroup").getJSONArray("rxnormId");

        return array.get(0).toString();
    }

    public List<InteractionPair> getInteraction(List<String> rxcuiList, MedicationTask medicationtaskST, MedicationTask medicationtaskND) {

        HttpManager http = new HttpManager();

        StringBuilder name = new StringBuilder();

        int index = 0;

        for (String rxcui : rxcuiList) {
            if (index > 0) {
                name.append("+" + rxcui);
            } else {
                name.append(rxcui);
            }

            index++;
        }

        http.setURL(rxNormBaseURI + "interaction/list.json?rxcuis=" + name.toString());
        String response = http.sendSearchGET();

        JSONObject obj = new JSONObject(response);
        JSONArray array = new JSONArray();
        try {
            array = obj.getJSONArray("fullInteractionTypeGroup");
        } catch (org.json.JSONException ex) {
            Logger.getLogger(RxNormAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<InteractionPair> interactionpairs = new ArrayList<>();

        for (Object object : array) {
            JSONArray jSONArray = ((JSONObject) object).getJSONArray("fullInteractionType");

            for (Object object1 : jSONArray) {
                System.out.println(object1.toString());

                JSONArray nArray = ((JSONObject) object1).getJSONArray("minConcept");
                JSONArray oNArray = ((JSONObject) object1).getJSONArray("interactionPair");

                InteractionPair interactionpair = new InteractionPair();

                ActiveIngredient activeIngredientST = Utils.getActiveIngredientByRxcui(
                        medicationtaskST, ((JSONObject) nArray.get(0)).get("rxcui").toString()
                );

                ActiveIngredient activeIngredientND = Utils.getActiveIngredientByRxcui(
                        medicationtaskND, ((JSONObject) nArray.get(1)).get("rxcui").toString()
                );

                interactionpair.setActiveIngredientSTID(activeIngredientST);
                interactionpair.setActiveIngredientNDID(activeIngredientND);
                interactionpair.setDescription(((JSONObject) oNArray.get(0)).get("description").toString());
                interactionpair.setSeverity(((JSONObject) oNArray.get(0)).get("severity").toString());

                System.out.println(((JSONObject) nArray.get(0)).get("name"));
                System.out.println(((JSONObject) nArray.get(0)).get("rxcui"));
                System.out.println(((JSONObject) nArray.get(1)).get("name"));
                System.out.println(((JSONObject) nArray.get(1)).get("rxcui"));

                System.out.println("    ");

                System.out.println(oNArray.toString());
                System.out.println(((JSONObject) oNArray.get(0)).get("severity"));
                System.out.println(((JSONObject) oNArray.get(0)).get("description"));

                System.out.println("========================================");
                interactionpairs.add(interactionpair);
            }

        }

        if (array.length() == 0) {
            InteractionPair interactionpair = new InteractionPair();

            ActiveIngredient activeIngredientST = Utils.getActiveIngredientByRxcui(
                    medicationtaskST, rxcuiList.get(0).toString()
            );

            ActiveIngredient activeIngredientND = Utils.getActiveIngredientByRxcui(
                    medicationtaskND, rxcuiList.get(1).toString()
            );

            interactionpair.setActiveIngredientSTID(activeIngredientST);
            interactionpair.setActiveIngredientNDID(activeIngredientND);
            interactionpair.setDescription("N/A");
            interactionpair.setSeverity("N/A");

            interactionpairs.add(interactionpair);
        }

        return interactionpairs;
    }

    public List<SimilarMedication> getSimilarByRxcui(String rxcui, ActiveIngredient activeIngredient) {
        HttpManager http = new HttpManager();

        List<SimilarMedication> similarMedications = new ArrayList<>();

        http.setURL(rxNormBaseURI + "rxclass/class/similarByRxcuis?rxcuis=" + rxcui);
        String response = http.sendSearchGET();

        List<String> list = new ArrayList<>();
        list.add(response);

        try {

            JSONObject jSONObject = new JSONObject(response);

            JSONObject obj = jSONObject.getJSONObject("similarityMember");
            JSONArray array = obj.getJSONArray("rankClassConcept");

            List<SimilarMedication> similarmedications = new ArrayList<>();

            for (Object object : array) {
                SimilarMedication similarmedication = new SimilarMedication();

                similarmedication.setClassID(
                        ((JSONObject) ((JSONObject) ((JSONObject) object)
                                .get("drugClassConceptItem"))
                                .get("rxclassMinConceptItem"))
                                .get("classId").toString()
                );

                similarmedication.setClassName(
                        ((JSONObject) ((JSONObject) ((JSONObject) object)
                                .get("drugClassConceptItem"))
                                .get("rxclassMinConceptItem"))
                                .get("className").toString()
                );

                similarmedication.setClassType(
                        ((JSONObject) ((JSONObject) ((JSONObject) object)
                                .get("drugClassConceptItem"))
                                .get("rxclassMinConceptItem"))
                                .get("classType").toString()
                );

                similarmedication.setEquivalenceScore(
                        Double.parseDouble(
                                ((JSONObject) ((JSONObject) object)
                                        .get("similarityEntityItem"))
                                        .get("equivalenceScore").toString()
                        )
                );

                similarmedication.setInclusionScore(
                        Double.parseDouble(
                                ((JSONObject) ((JSONObject) object)
                                        .get("similarityEntityItem"))
                                        .get("inclusionScore").toString()
                        )
                );

                similarmedication.setActiveIngredientList(Arrays.asList(activeIngredient));

                similarMedications.add(similarmedication);
                System.out.println(((JSONObject) ((JSONObject) object).get("similarityEntityItem")).toString(2));
                System.out.println(((JSONObject) ((JSONObject) object).get("drugClassConceptItem")).toString(2));

                System.out.println(((JSONObject) ((JSONObject) object).get("similarityEntityItem")).get("equivalenceScore").toString());
                System.out.println(((JSONObject) ((JSONObject) ((JSONObject) object).get("drugClassConceptItem")).get("rxclassMinConceptItem")).get("classId").toString());
                System.out.println(((JSONObject) ((JSONObject) ((JSONObject) object).get("drugClassConceptItem")).get("rxclassMinConceptItem")).get("className").toString());

                System.out.println("====================================================");

            }
        } catch (org.json.JSONException ex) {
            Logger.getLogger(RxNormAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return similarMedications;
    }

    public List<SimilarMedication> getSimilarByRxcuis(List<String> rxcuiList, List<ActiveIngredient> activeIngredients) {
        HttpManager http = new HttpManager();

        List<SimilarMedication> similarMedications = new ArrayList<>();

        StringBuilder name = new StringBuilder();

        int index = 0;

        for (String rxcui : rxcuiList) {
            if (index > 0) {
                name.append("+" + rxcui);
            } else {
                name.append(rxcui);
            }

            index++;
        }

        http.setURL(rxNormBaseURI + "rxclass/class/similarByRxcuis?rxcuis=" + name.toString());
        String response = http.sendSearchGET();

        List<String> list = new ArrayList<>();
        list.add(response);

        JSONObject jSONObject = new JSONObject(response);

        JSONObject obj = jSONObject.getJSONObject("similarityMember");
        JSONArray array = obj.getJSONArray("rankClassConcept");

        List<SimilarMedication> similarmedications = new ArrayList<>();

        for (Object object : array) {
            SimilarMedication similarmedication = new SimilarMedication();

            similarmedication.setClassID(
                    ((JSONObject) ((JSONObject) ((JSONObject) object)
                            .get("drugClassConceptItem"))
                            .get("rxclassMinConceptItem"))
                            .get("classId").toString()
            );

            similarmedication.setClassName(
                    ((JSONObject) ((JSONObject) ((JSONObject) object)
                            .get("drugClassConceptItem"))
                            .get("rxclassMinConceptItem"))
                            .get("classId").toString()
            );

            similarmedication.setClassType(
                    ((JSONObject) ((JSONObject) ((JSONObject) object)
                            .get("drugClassConceptItem"))
                            .get("rxclassMinConceptItem"))
                            .get("classType").toString()
            );

            similarmedication.setEquivalenceScore(
                    Double.parseDouble(
                            ((JSONObject) ((JSONObject) object)
                                    .get("similarityEntityItem"))
                                    .get("equivalenceScore").toString()
                    )
            );

            similarmedication.setInclusionScore(
                    Double.parseDouble(
                            ((JSONObject) ((JSONObject) object)
                                    .get("similarityEntityItem"))
                                    .get("inclusionScore").toString()
                    )
            );

            similarmedication.setActiveIngredientList(activeIngredients);

            similarMedications.add(similarmedication);
            System.out.println(((JSONObject) ((JSONObject) object).get("similarityEntityItem")).toString(2));
            System.out.println(((JSONObject) ((JSONObject) object).get("drugClassConceptItem")).toString(2));

            System.out.println(((JSONObject) ((JSONObject) object).get("similarityEntityItem")).get("equivalenceScore").toString());
            System.out.println(((JSONObject) ((JSONObject) ((JSONObject) object).get("drugClassConceptItem")).get("rxclassMinConceptItem")).get("classId").toString());
            System.out.println(((JSONObject) ((JSONObject) ((JSONObject) object).get("drugClassConceptItem")).get("rxclassMinConceptItem")).get("className").toString());

            System.out.println("====================================================");
        }

        return similarMedications;
    }

    public List<SimilarMedication> getSimilarByClassID(String classID, ActiveIngredient activeIngredient) {

        HttpManager http = new HttpManager();

        http.setURL(rxNormBaseURI + "rxclass/class/similar.json?classId=" + classID + "&relaSource=ATC");
        String response = http.sendSearchGET();

        List<String> list = new ArrayList<>();
        list.add(response);

        JSONObject jSONObject = new JSONObject(response);

        System.out.println(jSONObject.toString(2));

        List<SimilarMedication> similarmedications = new ArrayList<>();

        try {
            JSONObject obj = jSONObject.getJSONObject("similarityMember");

            JSONArray array = obj.getJSONArray("rankClassConcept");

            for (Object object : array) {

                SimilarMedication similarmedication = new SimilarMedication();

                similarmedication.setClassID(
                        ((JSONObject) ((JSONObject) ((JSONObject) object)
                                .get("drugClassConceptItem"))
                                .get("rxclassMinConceptItem"))
                                .get("classId").toString()
                );

                similarmedication.setClassName(
                        ((JSONObject) ((JSONObject) ((JSONObject) object)
                                .get("drugClassConceptItem"))
                                .get("rxclassMinConceptItem"))
                                .get("classId").toString()
                );

                similarmedication.setClassType(
                        ((JSONObject) ((JSONObject) ((JSONObject) object)
                                .get("drugClassConceptItem"))
                                .get("rxclassMinConceptItem"))
                                .get("classType").toString()
                );

                List<ActiveIngredient> activeIngredients = new ArrayList<ActiveIngredient>();
                activeIngredients.add(activeIngredient);

                similarmedication.setActiveIngredientList(activeIngredients);

                similarmedication.setEquivalenceScore(
                        Double.parseDouble(
                                ((JSONObject) ((JSONObject) object)
                                        .get("similarityEntityItem"))
                                        .get("equivalenceScore").toString()
                        )
                );

                similarmedication.setInclusionScore(
                        Double.parseDouble(
                                ((JSONObject) ((JSONObject) object)
                                        .get("similarityEntityItem"))
                                        .get("inclusionScore").toString()
                        )
                );

                similarmedications.add(similarmedication);

                System.out.println(((JSONObject) ((JSONObject) object).get("similarityEntityItem")).toString(2));
                System.out.println(((JSONObject) ((JSONObject) object).get("drugClassConceptItem")).toString(2));

                System.out.println(((JSONObject) ((JSONObject) object).get("similarityEntityItem")).get("equivalenceScore").toString());
                System.out.println(((JSONObject) ((JSONObject) ((JSONObject) object).get("drugClassConceptItem")).get("rxclassMinConceptItem")).get("classId").toString());
                System.out.println(((JSONObject) ((JSONObject) ((JSONObject) object).get("drugClassConceptItem")).get("rxclassMinConceptItem")).get("className").toString());

                System.out.println("====================================================");
            }
        } catch (org.json.JSONException ex) {
            Logger.getLogger(RxNormAPI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return similarmedications;
    }

    public String searchSimilarByClassID(String classID, String relaName, String drugSource) {
        HttpManager http = new HttpManager();
        // ex: https://mor.nlm.nih.gov/RxClass/showSimilarClasses?sourceId=N0000175608&relaName=has_EPC&drugSource=DailyMed
        http.setURL(
                rxNormURI + "/RxClass/showSimilarClasses?"
                + "sourceId=" + classID
                + "&relaName=" + relaName
                + "drugSource=" + drugSource
        );
        String response = http.sendSearchGET();

        return response;

    }
}
