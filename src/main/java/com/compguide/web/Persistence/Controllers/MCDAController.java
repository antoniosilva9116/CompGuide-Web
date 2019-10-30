/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compguide.web.Persistence.Controllers;

import com.compguide.web.Execution.Entities.Criteria;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author pedro
 */
@Named("mcda")
@SessionScoped
public class MCDAController implements Serializable {

    //ranges
    private String crta_min;

    private String crta_max;

    private String crtb_min;

    private String crtb_max;

    private String crtc_min;

    private String crtc_max;
    
   
    // lists for value choose for criteria
    private List<String> valuecrt_a;

    {
        valuecrt_a = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            valuecrt_a.add("");
        }
    }

    private List<String> valuecrt_b = new ArrayList<>();

    {
        valuecrt_b = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            valuecrt_b.add("");
        }
    }
    private List<String> valuecrt_c = new ArrayList<>();

    {
        valuecrt_c = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            valuecrt_c.add("");
        }
    }

    private Criteria crt;

    //pef matrix
    private List<Criteria> perf_matrix = new ArrayList<>();

    //pesos
    private Integer peso_crt_a;
    private Integer peso_crt_b;
    private Integer peso_crt_c;

    //total alternatives
    private double total_alter1;
    private double total_alter2;
    private double total_alter3;

    //getter and setters
    
      public String getCrta_min() {
        return crta_min;
    }

    public void setCrta_min(String crta_min) {
        System.out.println("Set crta_min: " + crta_min);
        this.crta_min = crta_min;
    }

    public String getCrta_max() {
        return crta_max;
    }

    public void setCrta_max(String crta_max) {
        System.out.println("Set crta_max: " + crta_max);
        this.crta_max = crta_max;
    }

    public String getCrtb_min() {
        return crtb_min;
    }

    public void setCrtb_min(String crtb_min) {
        System.out.println("Set crtb_min: " + crtb_min);
        this.crtb_min = crtb_min;
    }

    public String getCrtb_max() {
        return crtb_max;
    }

    public void setCrtb_max(String crtb_max) {
        System.out.println("Set crtb_max: " + crtb_max);
        this.crtb_max = crtb_max;
    }

    public String getCrtc_min() {
        return crtc_min;
    }

    public void setCrtc_min(String crtc_min) {
        System.out.println("Set crtc_min: " + crtc_min);
        this.crtc_min = crtc_min;
    }

    public String getCrtc_max() {
        return crtc_max;
    }

    public void setCrtc_max(String crtc_max) {
        System.out.println("Set crtc_max: " + crtc_max);
        this.crtc_max = crtc_max;
    }

    public Criteria getCrt() {
        return crt;
    }

    public void setCrt(Criteria crt) {
        this.crt = crt;
    }

    public Integer getPeso_crt_a() {
        return peso_crt_a;
    }

    public void setPeso_crt_a(Integer peso_crt_a) {
        this.peso_crt_a = peso_crt_a;
    }

    public Integer getPeso_crt_b() {
        return peso_crt_b;
    }

    public void setPeso_crt_b(Integer peso_crt_b) {
        this.peso_crt_b = peso_crt_b;
    }

    public Integer getPeso_crt_c() {
        return peso_crt_c;
    }

    public void setPeso_crt_c(Integer peso_crt_c) {
        this.peso_crt_c = peso_crt_c;
    }

    public double getTotal_alter1() {
        return total_alter1;
    }

    public void setTotal_alter1(double total_alter1) {
        this.total_alter1 = total_alter1;
    }

    public double getTotal_alter2() {
        return total_alter2;
    }

    public void setTotal_alter2(double total_alter2) {
        this.total_alter2 = total_alter2;
    }

    public double getTotal_alter3() {
        return total_alter3;
    }

    public void setTotal_alter3(double total_alter3) {
        this.total_alter3 = total_alter3;
    }
    
    public Integer getPesoCrtA() {
        return peso_crt_a;
    }

    public void setPesoCrtA(Integer peso_a) {
        this.peso_crt_a = peso_a;
    }

    public Integer getPesoCrtB() {
        return peso_crt_b;
    }

    public void setPesoCrtB(Integer peso_b) {
        this.peso_crt_b = peso_b;
    }

    public Integer getPesoCrtC() {
        return peso_crt_c;
    }

    public void setPesoCrtC(Integer peso_c) {
        this.peso_crt_c = peso_c;
    }

    public double getTotalAlt1() {
        return total_alter1;
    }

    public void setTotalAlt1(double alt1) {
        this.total_alter1 = alt1;
    }

    public double getTotalAlt2() {
        return total_alter2;
    }

    public void setTotalAlt2(double alt2) {
        this.total_alter2 = alt2;
    }

    public double getTotalAlt3() {
        return total_alter3;
    }

    public void setTotalAlt3(double alt3) {
        this.total_alter3 = alt3;
    }

    public List<Criteria> getPerf_matrix() {
        return perf_matrix;
    }

    public void setPerf_matrix(List<Criteria> perf_matrix) {
        this.perf_matrix = perf_matrix;
    }

    public List<String> getValuecrt_a() {
        return valuecrt_a;
    }

    public void setValuecrt_a(List<String> valuecrt_a) {
        this.valuecrt_a = valuecrt_a;
    }

    public List<String> getValuecrt_b() {
        return valuecrt_b;
    }

    public void setValuecrt_b(List<String> valuecrt_b) {
        this.valuecrt_b = valuecrt_b;
    }

    public List<String> getValuecrt_c() {
        return valuecrt_c;
    }

    public void setValuecrt_c(List<String> valuecrt_c) {
        this.valuecrt_c = valuecrt_c;
    }

    
    
    //Dev Methods
    
    //Calculate value for linear partial functions
    
    public double declive_value(String criteria){
        double res = 0;
        int min, max;
        String min_range = "", max_range = "";
       
        switch(criteria){
            case "a":
                min_range = this.getCrta_min();
                max_range = this.getCrta_max();
                break;
            case "b":
                min_range = this.getCrtb_min();
                max_range = this.getCrtb_max();
                break;
            case "c":
                min_range = this.getCrtc_min();
                max_range = this.getCrtc_max();
                break;
        }
        
        min = Integer.parseInt(min_range);
        max = Integer.parseInt(max_range);
        
        double sub1, sub2;
        
        
        sub1 = 100-0;
        sub2 = max-min;
        
        System.out.println(min);
        System.out.println(max);
        
        
        res = sub1/sub2;
        
        DecimalFormat df = new DecimalFormat("0.0");
        
        df.format(res);
       
        
        res = Math.floor(res * 10)/10;
       
        System.out.println("RESRES");
        System.out.println(res);
     
        
        return res;
    }
    
    public int declive_b(String criteria, double declive){
        double b = 0;
        int max;
        int res = 0;
        double intermed;
        switch(criteria){
            case "a":
                max = Integer.parseInt(this.getCrta_max());
                intermed = declive * max;
                b = 100 - intermed;
                b = (-1) * b;
                break;
            case "b":
                max = Integer.parseInt(this.getCrtb_max());
                intermed = declive * max;
                b = 0 - intermed;
                b = (-1) * b;
                break;
            case "c":
                max = Integer.parseInt(this.getCrtc_max());
                intermed = declive * max;
                b = 100 - intermed;
                b = (-1) * b;
                break;
        }     
        
        res = (int)b;
        
        System.out.println("Cena do B");
        System.out.println(res);
        
        return res;
    }
    
    //Calculadte Scores for alternatives
    
    public void calculateScores(String crt, int val_a, int val_b, int val_c) {
        int score1, score2, score3;
        System.out.println("Antes switch calculate");
        switch (crt) {
            case "a":
                double declive_a = this.declive_value("a");
                int b = this.declive_b("a", declive_a);
                System.out.println("dentro case calculate");
                System.out.println(val_a);
                System.out.println(val_b);
                System.out.println(val_c);
                score1 = (int)declive_a * val_a - b;
                score2 = (int)declive_a * val_b - b;
                score3 = (int)declive_a * val_c - b;
                if (this.perf_matrix.size() < 3) {
                    System.out.println("Entrei Aqii");
                    this.perf_matrix.clear();
                    Criteria cr1 = new Criteria("a", "A - Severity of disease for which drugs advised", val_a, val_b, val_c, score1, score2, score3);
                    this.perf_matrix.add(cr1);
                    System.out.println("Toma");
                    System.out.println(this.perf_matrix.size());

                } else {
                    this.perf_matrix.clear();
                    Criteria cr1 = new Criteria("a", "A - Severity of disease for which drugs advised", val_a, val_b, val_c, score1, score2, score3);
                    this.perf_matrix.add(cr1);
                }
                break;

            case "b":
                System.out.println("Entrei B");
                double declive_b = this.declive_value("b");
                int bb = this.declive_b("b", declive_b);
                score1 = -((int)declive_b) * val_a + bb;
                score2 = -((int)declive_b) * val_b + bb;
                score3 = -((int)declive_b) * val_c + bb;
                if (this.perf_matrix.size() < 3) {

                    Criteria cr1 = new Criteria("b", "B - Adverse drug-drug interactions", val_a, val_b, val_c, score1, score2, score3);
                    this.perf_matrix.add(cr1);
                } else {
                    this.perf_matrix.clear();
                    Criteria cr1 = new Criteria("b", "B - Adverse drug-drug interactions", val_a, val_b, val_c, score1, score2, score3);
                    this.perf_matrix.add(cr1);
                }
                break;

            case "c":
                System.out.println("Entrei C");
                double declive_c = this.declive_value("c");
                int cc = this.declive_b("c", declive_c);
                score1 = (int)declive_c * val_a - cc;
                score2 = (int)declive_c * val_b - cc;
                score3 = (int)declive_c * val_c - cc;

                if (this.perf_matrix.size() < 3) {
                    Criteria cr1 = new Criteria("c", "C - Expected outcomes for the drug application", val_a, val_b, val_c, score1, score2, score3);
                    this.perf_matrix.add(cr1);
                } else {
                    this.perf_matrix.clear();
                    Criteria cr1 = new Criteria("c", "C - Expected outocomes for the drug application", val_a, val_b, val_c, score1, score2, score3);
                    this.perf_matrix.add(cr1);
                }
                break;

        }
    }

    //Function for Perfomance Matrix
    
    public void scoreMatrix(String crt, String ca1, String ca2, String ca3, String cb1, String cb2, String cb3, String cc1, String cc2, String cc3) {
        int val_a, val_b, val_c;
        System.out.println("Estou antes do switch");
        switch (crt) {
            case "a":
                System.out.println("dentro case");
                val_a = Integer.parseInt(ca1);
                val_b = Integer.parseInt(ca2);
                val_c = Integer.parseInt(ca3);
                System.out.println("antes calculate");
                calculateScores(crt, val_a, val_b, val_c);
                System.out.println("Sai");
                break;
            case "b":
                val_a = Integer.parseInt(cb1);
                val_b = Integer.parseInt(cb2);
                val_c = Integer.parseInt(cb3);
                calculateScores(crt, val_a, val_b, val_c);
                break;
            case "c":
                val_a = Integer.parseInt(cc1);
                val_b = Integer.parseInt(cc2);
                val_c = Integer.parseInt(cc3);
                calculateScores(crt, val_a, val_b, val_c);
                break;
        }
    }

    //Function for fill perfomance matrix
    public void perfomance_matrix(String ca1, String ca2, String ca3, String cb1, String cb2, String cb3, String cc1, String cc2, String cc3) {
        //Testing List of values
        System.out.println("Crtieria A");
        for (String i : this.valuecrt_a) {
            System.out.println(i);
        }

        System.out.println("Criteria B");
        for (String b : this.valuecrt_b) {
            System.out.println(b);
        }

        System.out.println("Criteria C");
        for (String c : this.valuecrt_c) {
            System.out.println(c);
        }

        this.perf_matrix.clear();

        System.out.println(ca1);
        System.out.println(ca2);
        System.out.println(ca3);

        //clearList();
        scoreMatrix("a", ca1, ca2, ca3, cb1, cb2, cb3, cc1, cc2, cc3);
        System.out.println("Ja esta");
        scoreMatrix("b", ca1, ca2, ca3, cb1, cb2, cb3, cc1, cc2, cc3);
        scoreMatrix("c", ca1, ca2, ca3, cb1, cb2, cb3, cc1, cc2, cc3);

        double dec1, dec2, dec3;
        
        
        dec1 = declive_value("a");
        dec2 = declive_value("b");
        dec3 = declive_value("c");
        
        this.declive_b("a", dec1);
        this.declive_b("b", dec2);
        this.declive_b("c", dec3);
    }

    
    //Total Scores for each Alternative
    public void updateTotal(double alt1, double alt2, double alt3) {
        double total1 = this.getTotalAlt1();
        double total2 = this.getTotalAlt2();
        double total3 = this.getTotalAlt3();

        total1 = total1 + alt1;
        total2 = total2 + alt2;
        total3 = total3 + alt3;

        this.setTotalAlt1(total1);
        this.setTotalAlt2(total2);
        this.setTotalAlt3(total3);
    }

    //function to calculate final value of criteria
    public void calculateCriteria(Criteria crt, double peso, int flag) {
        double alt1, alt2, alt3;
        Integer score1, score2, score3;
        score1 = crt.getScore_alt1();
        score2 = crt.getScore_alt2();
        score3 = crt.getScore_alt3();

        alt1 = score1 * peso;
        alt2 = score2 * peso;
        alt3 = score3 * peso;

        alt1 = Math.floor(alt1 * 100) / 100;
        alt2 = Math.floor(alt2 * 100) / 100;
        alt3 = Math.floor(alt3 * 100) / 100;

        System.out.println(alt1);
        System.out.println(alt2);
        System.out.println(alt3);

        crt.setResultAlt1(alt1);
        crt.setResultAlt2(alt2);
        crt.setResultAlt3(alt3);
        crt.setWeight(peso);

        if (flag == 0) {
            this.setTotalAlt1(alt1);
            this.setTotalAlt2(alt2);
            this.setTotalAlt3(alt3);
        } else {
            updateTotal(alt1, alt2, alt3);
        }

    }

    //Final function for final tables
    public void calculateFinal(double peso1, double peso2, double peso3) {
        //for criteria
        int flag = 0;
        for (Criteria crt : this.perf_matrix) {
            switch (crt.getCriteria()) {
                case "a":
                    calculateCriteria(crt, peso1, flag);
                    break;
                case "b":
                    calculateCriteria(crt, peso2, flag);
                    break;
                case "c":
                    calculateCriteria(crt, peso3, flag);
                    break;

            }
            flag++;
            System.out.println("Flag");
            System.out.println(flag);
        }
    }

    //Final tab
    public void finalScores(String peso_1, String peso_2, String peso_3) {
        double peso1;
        double peso2;
        double peso3;

        int choose1, choose2, choose3, total;

        choose1 = Integer.parseInt(peso_1);
        choose2 = Integer.parseInt(peso_2);
        choose3 = Integer.parseInt(peso_3);

        System.out.println(choose1);
        System.out.println(choose2);
        System.out.println(choose3);

        total = choose1 + choose2 + choose3;

        System.out.println(total);

        peso1 = (double) choose1 / total;
        peso2 = (double) choose2 / total;
        peso3 = (double) choose3 / total;

        peso1 = Math.floor(peso1 * 100) / 100;
        peso2 = Math.floor(peso2 * 100) / 100;
        peso3 = Math.floor(peso3 * 100) / 100;

        System.out.println(peso1);
        System.out.println(peso2);
        System.out.println(peso3);

        calculateFinal(peso1, peso2, peso3);

    }

    //Function for set range value 
    public void daRange(String min_a, String max_a, String min_b, String max_b, String min_c, String max_c) {
        System.out.println("Min");
        System.out.println(min_a);
        this.setCrta_min(min_a);
        System.out.println("Max");
        System.out.println(max_a);
        this.setCrta_max(max_a);
        
     
        
        System.out.println("B");
        System.out.println("Min");
        System.out.println(min_b);
        this.setCrtb_min(min_b);
        System.out.println("Max");
        System.out.println(max_b);
        this.setCrtb_max(max_b);
        
        
        System.out.println("C");
        System.out.println("Min");
        System.out.println(min_c);
        this.setCrtc_min(min_c);
        System.out.println("Max");
        System.out.println(max_c);
        this.setCrtc_max(max_c);
        
        
        
        
   
    }

}
