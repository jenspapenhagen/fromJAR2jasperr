/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.myreport;

import eu.papenhagen.mydata.PersonDataSample;
import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author jens.papenhagen
 */
public class Reporter {
    
    public static JasperPrint writeReport() throws JRException{
        //yes hardcoded path
        //TODO better path ;)
        String location = "C:\\Users\\jens.papenhagen\\JaspersoftWorkspace\\MyReports\\Blank_A4.jrxml";
        Objects.requireNonNull(location);
        
        JasperReport compileReport = JasperCompileManager.compileReport(location);
        Map<String, Object> data = new HashMap<>();
        data.put("test", "Hallo Jasper");
          
        JRDataSource datasource = new JRBeanCollectionDataSource(PersonDataSample.get());
        return JasperFillManager.fillReport(compileReport, data, datasource);
        
        
    }
    
    public static void main(String[] args) throws JRException {
        JFrame f = new JFrame("Viewer");
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(new JRViewer( writeReport() ));
        f.pack();
        f.setVisible(true);
        
        
    }
    
}
