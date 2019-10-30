/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compguide.web.Execution.Entities;

/**
 *
 * @author pedro
 */
public class Criteria {
    
    private String criteria;
    private String name;
    private Integer value_alt1;
    private Integer value_alt2;
    private Integer value_alt3;
    private Integer score_alt1;
    private Integer score_alt2;
    private Integer score_alt3;
    private double result_alt1;
    private double result_alt2;
    private double result_alt3;
    private double weight;

    public Criteria(String criteria,String name, Integer value_alt1, Integer value_alt2, Integer value_alt3, Integer score_alt1, Integer score_alt2, Integer score_alt3) {
        this.criteria = criteria;
        this.name = name;
        this.value_alt1 = value_alt1;
        this.value_alt2 = value_alt2;
        this.value_alt3 = value_alt3;
        this.score_alt1 = score_alt1;
        this.score_alt2 = score_alt2;
        this.score_alt3 = score_alt3;
    }
    
    
    public double getWeight(){
        return weight;
    }
    
    public void setWeight(double p){
        this.weight = p;
    }
    
    public String getCriteria(){
        return criteria;
    }
    
    public void setCriteria(String crt){
        this.criteria = crt;
    }
    
    public double getResultAlt1(){
        return result_alt1;
    }
    
    public void setResultAlt1(double alt1){
        this.result_alt1 = alt1;
    }
    
    public double getResultAlt2(){
        return result_alt2;
    }
    
    public void setResultAlt2(double alt2){
        this.result_alt2 = alt2;
    }
    
    public double getResultAlt3(){
        return result_alt3;
    }
    
    public void setResultAlt3(double alt3){
        this.result_alt3 = alt3;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue_alt1() {
        return value_alt1;
    }

    public void setValue_alt1(Integer value_alt1) {
        this.value_alt1 = value_alt1;
    }

    public Integer getValue_alt2() {
        return value_alt2;
    }

    public void setValue_alt2(Integer value_alt2) {
        this.value_alt2 = value_alt2;
    }

    public Integer getValue_alt3() {
        return value_alt3;
    }

    public void setValue_alt3(Integer value_alt3) {
        this.value_alt3 = value_alt3;
    }

    public Integer getScore_alt1() {
        return score_alt1;
    }

    public void setScore_alt1(Integer score_alt1) {
        this.score_alt1 = score_alt1;
    }

    public Integer getScore_alt2() {
        return score_alt2;
    }

    public void setScore_alt2(Integer score_alt2) {
        this.score_alt2 = score_alt2;
    }

    public Integer getScore_alt3() {
        return score_alt3;
    }

    public void setScore_alt3(Integer score_alt3) {
        this.score_alt3 = score_alt3;
    }
    
    
}
