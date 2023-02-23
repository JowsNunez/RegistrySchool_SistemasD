/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.registryschool.controllers;

import com.registryschool.builders.StudentBuilder;
import com.registryschool.bussines.Student;
import com.registryschool.client.HandleClient;
import com.registryschool.views.CreateStudentView;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author el_fr
 */
public class CreateController implements Controller {
    
    private final CreateStudentView createStudentView;
    private HandleClient handleClient;
    
    public CreateController(JFrame after, HandleClient handleClient) {
        
        after.dispose();
        this.handleClient = handleClient;
        this.createStudentView = new CreateStudentView(this);
        this.createStudentView.setVisible(true);
    }
    
    public boolean saveStudent(String name, String lastName, int Age, String Residence) {
        
        if (name.isEmpty()) {
            return false;
        }
        if (lastName.isEmpty()) {
            return false;
        }
        if (Age == 0) {
            return false;
        }
        
        if (Residence.isEmpty()) {
            return false;
        }
        
        Student student = new StudentBuilder()
                .setName(name)
                .setResidence(Residence)
                .setLastName(lastName)
                .setAge(Age)
                .setIdStudent()
                .build();
        
        handleClient.sendData("SAVESTUDENT", student);
        this.handleClient.getStudents().addStudent(student);
        return true;
    }
    
    @Override
    public void update() {
        //TODO
    }
    
    @Override
    public void openAfterView() {
        this.unSubscribe();
        new PrincipalController(handleClient);
    }
    
    @Override
    public void subscribe() {
        
        this.handleClient.getStudents().addObserver(this);
        
    }
    
    @Override
    public void unSubscribe() {
        this.handleClient.getStudents().removeObserver(this);
    }
    
}
