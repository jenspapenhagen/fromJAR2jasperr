/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.mydata;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jens.papenhagen
 */
public class ArtikelDataSample {
    
    public static  List<Artikel> get(){
        List<Artikel> list = new ArrayList<>();
        Artikel a = new Artikel(1, "Computer Maus", 100, 15.80);
        Artikel a1 = new Artikel(3, "Computer Tastatur", 450, 75.99);
        Artikel a2 = new Artikel(2, "Mauspad", 50, 2.50);
        
        
        
        list.add(a);
        list.add(a1);
        list.add(a2);
        
        return list;
    }
    
    
}
