/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compguide.web.Persistence.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author António Silva
 */
@Entity
@Table(name = "medicationtask")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedicationTask.findAll", query = "SELECT m FROM MedicationTask m")
    , @NamedQuery(name = "MedicationTask.findByActiveIngredient", query = "SELECT m FROM MedicationTask m WHERE m.activeIngredient = :activeIngredient")
    , @NamedQuery(name = "MedicationTask.findByMedicationTaskID", query = "SELECT m FROM MedicationTask m WHERE m.medicationTaskID = :medicationTaskID")
    , @NamedQuery(name = "MedicationTask.findByDosage", query = "SELECT m FROM MedicationTask m WHERE m.dosage = :dosage")
    , @NamedQuery(name = "MedicationTask.findByPharmaceuticalForm", query = "SELECT m FROM MedicationTask m WHERE m.pharmaceuticalForm = :pharmaceuticalForm")
    , @NamedQuery(name = "MedicationTask.findByPosology", query = "SELECT m FROM MedicationTask m WHERE m.posology = :posology")
    , @NamedQuery(name = "MedicationTask.findByTime", query = "SELECT m FROM MedicationTask m WHERE m.time = :time")
    , @NamedQuery(name = "MedicationTask.findByIdentifier", query = "SELECT m FROM MedicationTask m WHERE m.identifier = :identifier")
    , @NamedQuery(name = "MedicationTask.findByTimeEnd", query = "SELECT m FROM MedicationTask m WHERE m.timeEnd = :timeEnd")
    , @NamedQuery(name = "MedicationTask.findByScheduleTaskID", query = "SELECT m FROM MedicationTask m WHERE m.scheduleTaskID = :scheduleTaskID")})
public class MedicationTask implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MedicationTaskID")
    private Integer medicationTaskID;
    @Lob
    @Size(max = 65535)
    @Column(name = "ActiveIngredient")
    private String activeIngredient;
    @Size(max = 255)
    @Column(name = "Dosage")
    private String dosage;
    @Size(max = 255)
    @Column(name = "PharmaceuticalForm")
    private String pharmaceuticalForm;
    @Lob
    @Size(max = 65535)
    @Column(name = "Posology")
    private String posology;
    @Lob
    @Size(max = 65535)
    @Column(name = "Description")
    private String description;
    @Column(name = "Time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Size(max = 255)
    @Column(name = "Identifier")
    private String identifier;
    @Column(name = "TimeEnd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeEnd;
    @ManyToMany(mappedBy = "medicationTaskList")
    private List<ActiveIngredient> activeIngredientList;
    @JoinColumn(name = "ScheduleTaskID", referencedColumnName = "ScheduleTaskID")
    @ManyToOne(optional = false)
    private ScheduleTask scheduleTaskID;

    public MedicationTask() {
    }

    public MedicationTask(Integer medicationTaskID) {
        this.medicationTaskID = medicationTaskID;
    }

    public Integer getMedicationTaskID() {
        return medicationTaskID;
    }

    public void setMedicationTaskID(Integer medicationTaskID) {
        this.medicationTaskID = medicationTaskID;
    }

    public String getActiveIngredient() {
        return activeIngredient;
    }

    public void setActiveIngredient(String activeIngredient) {
        this.activeIngredient = activeIngredient;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getPharmaceuticalForm() {
        return pharmaceuticalForm;
    }

    public void setPharmaceuticalForm(String pharmaceuticalForm) {
        this.pharmaceuticalForm = pharmaceuticalForm;
    }

    public String getPosology() {
        return posology;
    }

    public void setPosology(String posology) {
        this.posology = posology;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    @XmlTransient
    @JsonIgnore
    public List<ActiveIngredient> getActiveIngredientList() {
        return activeIngredientList;
    }

    public void addActiveIngredient(ActiveIngredient activeIngredient) {
        if (Objects.isNull(activeIngredientList)) {
            activeIngredientList = new ArrayList<>();
        }

        if (!activeIngredientList.contains(activeIngredient)) {
            activeIngredientList.add(activeIngredient);
        }
    }

    public void setActiveIngredientList(List<ActiveIngredient> activeIngredientList) {
        this.activeIngredientList = activeIngredientList;
    }

    public ScheduleTask getScheduleTaskID() {
        return scheduleTaskID;
    }

    public void setScheduleTaskID(ScheduleTask scheduleTaskID) {
        this.scheduleTaskID = scheduleTaskID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicationTaskID != null ? medicationTaskID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicationTask)) {
            return false;
        }
        MedicationTask other = (MedicationTask) object;
        if ((this.medicationTaskID == null && other.medicationTaskID != null) || (this.medicationTaskID != null && !this.medicationTaskID.equals(other.medicationTaskID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.compguide.web.Persistence.Entities.MedicationTask[ medicationTaskID=" + medicationTaskID + " ]";
    }

}
