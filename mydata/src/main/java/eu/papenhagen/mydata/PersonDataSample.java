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
public class PersonDataSample {
    /**
     * give a List of Person
     * @return 
     */
    
   public static List<Person> get(){
       List<Person> list = new ArrayList<>();
       Person p1 = new Person("Jens", "Papenhagen", 34);
       Person p2 = new Person("Hans", "Meier", 60);
       Person p3 = new Person("Peter", "Lustig", 54);
       list.add(p1);
       list.add(p2);
       list.add(p3);
       
       
       return list;
       
   }
    
}
