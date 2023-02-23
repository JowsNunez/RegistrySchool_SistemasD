/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.registryschool.interpret;

import com.registryschool.bussines.Student;
import java.util.Map;

/**
 *
 * @author el_fr
 */
public interface interpreter {
    String encode(String action, Student data, String to, String from);
    Map<String, Object> decode(String data);
    
    
}
