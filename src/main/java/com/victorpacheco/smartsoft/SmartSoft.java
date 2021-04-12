/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.victorpacheco.smartsoft;

/**
 *
 * @author victor
 */
public class SmartSoft {
    
    public static void main(String[] args){
        Riddle riddle = new Riddle();
        String riddle1 = "ab?ac";
        String riddle2 = "rd?e?wg??";
        String riddle3 = "?????";
        
        System.out.println("Solution for " + riddle1 + " is " + riddle.solution(riddle1));
        System.out.println("Solution for " + riddle2 + " is " + riddle.solution(riddle2));
        System.out.println("Solution for " + riddle3 + " is " + riddle.solution(riddle3));
    }
    
}
