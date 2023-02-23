/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.registryschool.controllers;

import com.registryschool.bussines.Student;
import com.registryschool.client.HandleClient;
import com.registryschool.views.ManagementView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author el_fr
 */
public class ManagementController implements Controller, Observer {

    private ManagementView managementView;
    private HandleClient handleClient;
    private JFrame afterFrame;
    private JTable tableStudents;

    public ManagementController(JFrame after, HandleClient handleClient) {
        this.afterFrame = after;
        after.dispose();
        this.handleClient = handleClient;
        this.managementView = new ManagementView(this);
        this.managementView.setVisible(true);
        this.createTable();

    }

    public void createTable() {
        HashSet<Student> students = this.handleClient.getStudents().getStudents();

        JScrollPane pnl = this.managementView.getPnlStudenTable();

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Agrega las columnas al modelo
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Last name");
        model.addColumn("Age");
        model.addColumn("Residence");
        model.addColumn("Qualificacion");

        // Agrega cada estudiante como una fila en el modelo
        for (Student student : students) {
            Object[] row = {student.getIdStudent(), student.getName(), student.getLastName(), student.getAge(), student.getResidence(), student.getQualification()};
            model.addRow(row);
        }

        tableStudents = new JTable(model);
        addListenersTable();
        pnl.setViewportView(tableStudents);

    }

    // cuando otro cliente modifique a un estudiante sera visible en la tabla
    @Override
    public void update() {
        this.createTable();
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

    public void addListenersTable() {
        this.tableStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableStudentsMouseClicked(evt);
            }
        });
    }

    public void tableStudentsMouseClicked(java.awt.event.MouseEvent evt) {

        System.out.println(this.tableStudents.getModel().getValueAt(this.tableStudents.getSelectedRow(), 0));

    }

}
