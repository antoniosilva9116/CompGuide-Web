/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compguide.web.Persistence.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author António Silva
 */
@Entity
@Table(name = "interactionpair")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InteractionPair.findAll", query = "SELECT i FROM InteractionPair i")
    , @NamedQuery(name = "InteractionPair.findByInteractionPairID", query = "SELECT i FROM InteractionPair i WHERE i.interactionPairID = :interactionPairID")
    , @NamedQuery(name = "InteractionPair.findBySeverity", query = "SELECT i FROM InteractionPair i WHERE i.severity = :severity")
    , @NamedQuery(name = "InteractionPair.findByActiveIngredientSTID", query = "SELECT i FROM InteractionPair i WHERE i.activeIngredientSTID = :activeIngredientSTID")
    , @NamedQuery(name = "InteractionPair.findByActiveIngredientNDID", query = "SELECT i FROM InteractionPair i WHERE i.activeIngredientNDID = :activeIngredientNDID")
    , @NamedQuery(name = "InteractionPair.findByActiveIngredientSTIDANDActiveIngredientNDID", query = "SELECT i FROM InteractionPair i WHERE i.activeIngredientSTID = :activeIngredientSTID AND i.activeIngredientNDID = :activeIngredientNDID")})
public class InteractionPair implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "InteractionPairID")
    private Integer interactionPairID;
    @Lob
    @Size(max = 65535)
    @Column(name = "Description")
    private String description;
    @Size(max = 255)
    @Column(name = "Severity")
    private String severity;
    @JoinColumn(name = "ActiveIngredientNDID", referencedColumnName = "ActiveIngredientID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ActiveIngredient activeIngredientNDID;
    @JoinColumn(name = "ActiveIngredientSTID", referencedColumnName = "ActiveIngredientID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ActiveIngredient activeIngredientSTID;

    public InteractionPair() {
    }

    public InteractionPair(Integer interactionPairID) {
        this.interactionPairID = interactionPairID;
    }

    public Integer getInteractionPairID() {
        return interactionPairID;
    }

    public void setInteractionPairID(Integer interactionPairID) {
        this.interactionPairID = interactionPairID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public ActiveIngredient getActiveIngredientNDID() {
        return activeIngredientNDID;
    }

    public void setActiveIngredientNDID(ActiveIngredient activeIngredientNDID) {
        this.activeIngredientNDID = activeIngredientNDID;
    }

    public ActiveIngredient getActiveIngredientSTID() {
        return activeIngredientSTID;
    }

    public void setActiveIngredientSTID(ActiveIngredient activeIngredientSTID) {
        this.activeIngredientSTID = activeIngredientSTID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (interactionPairID != null ? interactionPairID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InteractionPair)) {
            return false;
        }
        InteractionPair other = (InteractionPair) object;
        if ((this.interactionPairID == null && other.interactionPairID != null) || (this.interactionPairID != null && !this.interactionPairID.equals(other.interactionPairID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.compguide.web.Persistence.Entities.InteractionPair[ interactionPairID=" + interactionPairID + " ]";
    }

}
