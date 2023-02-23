/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.registryschool.controllers;

import com.registryschool.client.HandleClient;
import com.registryschool.views.CreateStudentView;
import com.registryschool.views.ManagementView;
import com.registryschool.views.PrincipalView;
import javax.swing.JFrame;

/**
 *
 * @author el_fr
 */
public class PrincipalController {
    private HandleClient handleClient;
    private PrincipalView principalView;
    public PrincipalController(HandleClient handleClient) {
        this.handleClient = handleClient;
        this.principalView= new PrincipalView(this);
        this.principalView.setVisible(true);        
    }
    public void openCreateView(JFrame after){
       new CreateController(after,this.handleClient);
    }
     public void openManagementView(JFrame after){
       new ManagementController(after,this.handleClient);
    }
    
    
    
}
