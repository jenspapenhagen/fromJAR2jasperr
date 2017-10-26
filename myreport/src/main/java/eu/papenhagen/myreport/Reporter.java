/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.papenhagen.myreport;

import eu.papenhagen.mydata.ArtikelDataSample;
import eu.papenhagen.mydata.PersonDataSample;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXhtmlExporter;

/**
 *
 * @author jens.papenhagen
 */
public class Reporter extends Application {

    private Map<String, Object> params;

    public static JasperPrint writeReport(String location, Map params) throws JRException {

        Objects.requireNonNull(location);

        JasperReport compileReport = JasperCompileManager.compileReport(location);

        JRDataSource datasource = new JRBeanCollectionDataSource(ArtikelDataSample.get());
        JasperPrint jprint = JasperFillManager.fillReport(compileReport, params, datasource);

        return jprint;
    }

    private static String exportReport(JasperPrint jasperPrint) {
        JRExporter exporter = null;
        StringWriter out = new StringWriter();
        PrintWriter printWriter = new PrintWriter(out);
        try {
            exporter = new JRXhtmlExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, printWriter);
            exporter.exportReport();
        } catch (RuntimeException | JRException ex) {

        }

        return out.toString();
    }

    public String generateReport() throws JRException {

        String location = "Rechnung.jrxml";

        params = new HashMap<>();

        //person
        params.put("anrede", "Herr");
        params.put("vorname", PersonDataSample.get().get(0).getFirstName());
        params.put("nachname", PersonDataSample.get().get(0).getLastName());
        params.put("strasse", PersonDataSample.get().get(0).getStreet());
        params.put("hausnummer", PersonDataSample.get().get(0).getHousenumber());
        params.put("plz", PersonDataSample.get().get(0).getZip());
        params.put("stadt", PersonDataSample.get().get(0).getCity());

        //rechnungs "api"
        params.put("rechnungsnr", 155);
        params.put("kundennr", 16351315);

        JasperPrint writeReport = writeReport(location, params);
        String exportReport = exportReport(writeReport);

        return exportReport;

    }

    @Override
    public void start(Stage stage) throws Exception {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.setJavaScriptEnabled(true);
        webEngine.loadContent(generateReport());
        
        
        //the zoom Slider
        Slider slider = new Slider(0.5, 2, 1);
        
        ZoomingPane zoomingPane = new ZoomingPane(webView);
        zoomingPane.zoomFactorProperty().bind(slider.valueProperty());
        
        BorderPane pane = new BorderPane(zoomingPane, slider, null, null, null);
        
        Scene scene = new Scene(pane);
        stage.setScene(scene);

        
        stage.setTitle("Web View");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
