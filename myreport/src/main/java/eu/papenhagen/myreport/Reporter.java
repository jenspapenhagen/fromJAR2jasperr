/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.myreport;

import eu.papenhagen.mydata.ArtikelDataSample;
import eu.papenhagen.mydata.PersonDataSample;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
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

    public static JasperPrint writeReport() throws JRException {
        //yes hardcoded path
        //TODO better path 
        String location = "Rechnung.jrxml";
        Objects.requireNonNull(location);

        JasperReport compileReport = JasperCompileManager.compileReport(location);
        Map<String, Object> data = new HashMap<>();
        
        //person
        data.put("anrede", "Herr");
        data.put("vorname", PersonDataSample.get().get(0).getFirstName());
        data.put("nachname", PersonDataSample.get().get(0).getLastName());
        data.put("strasse", PersonDataSample.get().get(0).getStreet());
        data.put("hausnummer", PersonDataSample.get().get(0).getHousenumber());
        data.put("plz", PersonDataSample.get().get(0).getZip());
        data.put("stadt", PersonDataSample.get().get(0).getCity());
        
        //rechnungs "api"
        data.put("rechnungsnr", 155);
        data.put("kundennr", 16351315);
        
        
        

        JRDataSource datasource = new JRBeanCollectionDataSource(ArtikelDataSample.get());
        return JasperFillManager.fillReport(compileReport, data, datasource);

    }

    public static void main(String[] args) throws JRException {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Viewer");
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.setPreferredSize(new Dimension(600, 800));
            f.getContentPane().setLayout(new BorderLayout());
            try {
                f.getContentPane().add(new JRViewer(writeReport()));
            } catch (JRException ex) {
                
            }
            f.pack();
            f.setVisible(true);

        }
        );

    }

}
