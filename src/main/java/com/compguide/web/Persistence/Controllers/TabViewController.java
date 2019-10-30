/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compguide.web.Persistence.Controllers;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import net.bootsfaces.component.tabView.TabView;


/**
 *
 * @author pedro
 */

@Named("tab")
@ViewScoped
public class TabViewController implements Serializable  {
    
    private int activeIndex = 0;
    
    
    public int getActiveIndex(){
        return activeIndex;
    }
    
    public void setActiveIndex(int idx){
        System.out.println( "<TabViewController.setActiveIndex> old Index = "+activeIndex );
        this.activeIndex = idx;
        System.out.println( "<TabViewController.setActiveIndex> new Index = "+activeIndex );
    }
   
    
    public void incrementaIndex(){
        this.activeIndex++;
        if(this.activeIndex > 4){
            this.activeIndex = 0;
        }
    }
    
   
    
}
