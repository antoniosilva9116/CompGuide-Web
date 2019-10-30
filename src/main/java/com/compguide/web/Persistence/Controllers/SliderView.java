package com.compguide.web.Persistence.Controllers;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import org.primefaces.event.SlideEndEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pedro
 */
@Named("sliderView")
@SessionScoped
public class SliderView implements Serializable {

    private int number1 = 30;
    private int number2 = 80;
    //private int maxSlider = 100;
    //private int minSlider = 0;

    public SliderView() {
    }

    /*public int getMaxSlider(){
        return maxSlider;
    }
    
    
    
    public int getMinSlider(){
        return minSlider;
    }
     */
    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    /*
    public void setMaxSlider(int maxSlider){
        this.maxSlider = maxSlider;
    }
    
    public void setMinSlider(int minSlider){
        this.minSlider = minSlider;
    }
     */
    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public void onInputChanged(ValueChangeEvent event) {
        FacesMessage message = new FacesMessage("Input Changed", "Value: " + event.getNewValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onSlideEnd(SlideEndEvent event) {
        FacesMessage message = new FacesMessage("Slide Ended", "Value: " + event.getValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
