/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.registryschool.persists;

import com.registryschool.controllers.Observer;

/**
 *
 * @author el_fr
 */
public interface Observable {
    void addObserver(Observer o);
    void setUpdate();
    void removeObserver(Observer o);
}
