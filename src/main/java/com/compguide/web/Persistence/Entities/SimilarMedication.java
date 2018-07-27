/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compguide.web.Persistence.Entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author António Silva
 */
@Entity
@Table(name = "similarmedication")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SimilarMedication.findAll", query = "SELECT s FROM SimilarMedication s")
    , @NamedQuery(name = "SimilarMedication.findBySimilarMedicationID", query = "SELECT s FROM SimilarMedication s WHERE s.similarMedicationID = :similarMedicationID")
    , @NamedQuery(name = "SimilarMedication.findByEquivalenceScore", query = "SELECT s FROM SimilarMedication s WHERE s.equivalenceScore = :equivalenceScore")
    , @NamedQuery(name = "SimilarMedication.findByInclusionScore", query = "SELECT s FROM SimilarMedication s WHERE s.inclusionScore = :inclusionScore")
    , @NamedQuery(name = "SimilarMedication.findByClassID", query = "SELECT s FROM SimilarMedication s WHERE s.classID = :classID")
    , @NamedQuery(name = "SimilarMedication.findByClassName", query = "SELECT s FROM SimilarMedication s WHERE s.className = :className")
    , @NamedQuery(name = "SimilarMedication.findByRxcui", query = "SELECT s FROM SimilarMedication s WHERE s.rxcui = :rxcui")
    , @NamedQuery(name = "SimilarMedication.findByClassType", query = "SELECT s FROM SimilarMedication s WHERE s.classType = :classType")
    , @NamedQuery(name = "SimilarMedication.findByDrugSource", query = "SELECT s FROM SimilarMedication s WHERE s.drugSource = :drugSource")
    , @NamedQuery(name = "SimilarMedication.findByRela", query = "SELECT s FROM SimilarMedication s WHERE s.rela = :rela")
    , @NamedQuery(name = "SimilarMedication.findByActiveIngredientID", query = "SELECT s FROM SimilarMedication s WHERE s.activeIngredientList = :activeIngredientList")})
public class SimilarMedication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SimilarMedicationID")
    private Integer similarMedicationID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "EquivalenceScore")
    private Double equivalenceScore;
    @Column(name = "InclusionScore")
    private Double inclusionScore;
    @Size(max = 255)
    @Column(name = "ClassID")
    private String classID;
    @Size(max = 255)
    @Column(name = "ClassName")
    private String className;
    @Column(name = "Rxcui")
    private BigInteger rxcui;
    @Size(max = 255)
    @Column(name = "ClassType")
    private String classType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "DrugSource")
    private String drugSource;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Rela")
    private String rela;
    @ManyToMany(mappedBy = "similarMedicationList")
    private List<ActiveIngredient> activeIngredientList;

    public SimilarMedication() {
    }

    public SimilarMedication(Integer similarMedicationID) {
        this.similarMedicationID = similarMedicationID;
    }

    public SimilarMedication(Integer similarMedicationID, String drugSource, String rela) {
        this.similarMedicationID = similarMedicationID;
        this.drugSource = drugSource;
        this.rela = rela;
    }

    public Integer getSimilarMedicationID() {
        return similarMedicationID;
    }

    public void setSimilarMedicationID(Integer similarMedicationID) {
        this.similarMedicationID = similarMedicationID;
    }

    public Double getEquivalenceScore() {
        return equivalenceScore;
    }

    public void setEquivalenceScore(Double equivalenceScore) {
        this.equivalenceScore = equivalenceScore;
    }

    public Double getInclusionScore() {
        return inclusionScore;
    }

    public void setInclusionScore(Double inclusionScore) {
        this.inclusionScore = inclusionScore;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public BigInteger getRxcui() {
        return rxcui;
    }

    public void setRxcui(BigInteger rxcui) {
        this.rxcui = rxcui;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getDrugSource() {
        return drugSource;
    }

    public void setDrugSource(String drugSource) {
        this.drugSource = drugSource;
    }

    public String getRela() {
        return rela;
    }

    public void setRela(String rela) {
        this.rela = rela;
    }

    @XmlTransient
    @JsonIgnore
    public List<ActiveIngredient> getActiveIngredientList() {
        return activeIngredientList;
    }

    public void setActiveIngredientList(List<ActiveIngredient> activeIngredientList) {
        this.activeIngredientList = activeIngredientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (similarMedicationID != null ? similarMedicationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SimilarMedication)) {
            return false;
        }
        SimilarMedication other = (SimilarMedication) object;
        if ((this.similarMedicationID == null && other.similarMedicationID != null) || (this.similarMedicationID != null && !this.similarMedicationID.equals(other.similarMedicationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.compguide.web.Persistence.Entities.SimilarMedication[ similarMedicationID=" + similarMedicationID + " ]";
    }

}
