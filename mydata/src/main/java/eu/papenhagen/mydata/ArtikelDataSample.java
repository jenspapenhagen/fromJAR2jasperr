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
        Artikel a = new Artikel(11385, "Computer Maus", 100, 15.80);
        Artikel a1 = new Artikel(12588, "Computer Tastatur", 450, 75.99);
        Artikel a2 = new Artikel(22864, "Mauspad", 50, 2.50);
        Artikel a3 = new Artikel(22344, "ACER Laptop", 3850, 850.99);
        Artikel a4 = new Artikel(12344, "Laptoptasche 15 Zoll", 50, 35.00);

        list.add(a);
        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        
        return list;
    }
    
    
}
