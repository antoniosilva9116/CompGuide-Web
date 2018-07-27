/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compguide.web.Persistence.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anton
 */
@Entity
@Table(name = "activeingredient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActiveIngredient.findAll", query = "SELECT a FROM ActiveIngredient a"),
    @NamedQuery(name = "ActiveIngredient.findByActiveIngredientID", query = "SELECT a FROM ActiveIngredient a WHERE a.activeIngredientID = :activeIngredientID"),
    @NamedQuery(name = "ActiveIngredient.findByName", query = "SELECT a FROM ActiveIngredient a WHERE a.name = :name"),
    @NamedQuery(name = "ActiveIngredient.findByRxCui", query = "SELECT a FROM ActiveIngredient a WHERE a.rxCui = :rxCui"),
    @NamedQuery(name = "ActiveIngredient.findByClassID", query = "SELECT a FROM ActiveIngredient a WHERE a.classID = :classID")})
public class ActiveIngredient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ActiveIngredientID")
    private Integer activeIngredientID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Name")
    private String name;
    @Size(max = 255)
    @Column(name = "RxCui")
    private String rxCui;
    @Size(max = 255)
    @Column(name = "ClassID")
    private String classID;
    @JoinTable(name = "medicationtaskactiveingredient", joinColumns = {
        @JoinColumn(name = "ActiveIngredientActiveIngredientID", referencedColumnName = "ActiveIngredientID")}, inverseJoinColumns = {
        @JoinColumn(name = "MedicationTaskMedicationTaskID", referencedColumnName = "MedicationTaskID")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<MedicationTask> medicationTaskList;
    @JoinTable(name = "activeingredientsimilarmedication", joinColumns = {
        @JoinColumn(name = "ActiveIngredientActiveIngredientID", referencedColumnName = "ActiveIngredientID")}, inverseJoinColumns = {
        @JoinColumn(name = "SimilarMedicationSimilarMedicationID", referencedColumnName = "SimilarMedicationID")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<SimilarMedication> similarMedicationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activeIngredientNDID", fetch = FetchType.EAGER)
    private List<InteractionPair> interactionPairList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activeIngredientSTID", fetch = FetchType.EAGER)
    private List<InteractionPair> interactionPairList1;
    @Size(max = 60)
    @Column(name = "DrugSource")
    private String drugSource;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "RelaSource")
    private String relaSource;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Rela")
    private String rela;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "RelaName")
    private String relaName;

    public ActiveIngredient() {
    }

    public ActiveIngredient(Integer activeIngredientID) {
        this.activeIngredientID = activeIngredientID;
    }

    public ActiveIngredient(Integer activeIngredientID, String name) {
        this.activeIngredientID = activeIngredientID;
        this.name = name;
    }

    public Integer getActiveIngredientID() {
        return activeIngredientID;
    }

    public void setActiveIngredientID(Integer activeIngredientID) {
        this.activeIngredientID = activeIngredientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRxCui() {
        return rxCui;
    }

    public void setRxCui(String rxCui) {
        this.rxCui = rxCui;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    @XmlTransient
    public List<MedicationTask> getMedicationTaskList() {
        return medicationTaskList;
    }

    public void setMedicationTaskList(List<MedicationTask> medicationTaskList) {
        this.medicationTaskList = medicationTaskList;
    }

    @XmlTransient
    public List<SimilarMedication> getSimilarMedicationList() {
        return similarMedicationList;
    }

    public void setSimilarMedicationList(List<SimilarMedication> similarMedicationList) {
        this.similarMedicationList = similarMedicationList;
    }

    @XmlTransient
    public List<InteractionPair> getInteractionPairList() {
        return interactionPairList;
    }

    public void setInteractionPairList(List<InteractionPair> interactionPairList) {
        this.interactionPairList = interactionPairList;
    }

    @XmlTransient
    public List<InteractionPair> getInteractionPairList1() {
        return interactionPairList1;
    }

    public void setInteractionPairList1(List<InteractionPair> interactionPairList1) {
        this.interactionPairList1 = interactionPairList1;
    }

    public void addMedicationTask(MedicationTask medicationTask) {
        if (!medicationTaskList.contains(medicationTask)) {
            medicationTaskList.add(medicationTask);
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activeIngredientID != null ? activeIngredientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActiveIngredient)) {
            return false;
        }
        ActiveIngredient other = (ActiveIngredient) object;
        if ((this.activeIngredientID == null && other.activeIngredientID != null) || (this.activeIngredientID != null && !this.activeIngredientID.equals(other.activeIngredientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.compguide.web.Persistence.Entities.ActiveIngredient[ activeIngredientID=" + activeIngredientID + " ]";
    }

    public String getDrugSource() {
        return drugSource;
    }

    public void setDrugSource(String drugSource) {
        this.drugSource = drugSource;
    }

    public String getRelaSource() {
        return relaSource;
    }

    public void setRelaSource(String relaSource) {
        this.relaSource = relaSource;
    }

    public String getRela() {
        return rela;
    }

    public void setRela(String rela) {
        this.rela = rela;
    }

    public String getRelaName() {
        return relaName;
    }

    public void setRelaName(String relaName) {
        this.relaName = relaName;
    }

}
