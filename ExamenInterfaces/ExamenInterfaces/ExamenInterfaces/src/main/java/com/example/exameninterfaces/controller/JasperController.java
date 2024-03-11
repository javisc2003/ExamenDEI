package com.example.exameninterfaces.controller;

import com.example.exameninterfaces.util.JDBCUtils;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

import java.sql.SQLException;
import java.util.HashMap;

public class JasperController {

    public static void generateReport() throws JRException, ClassNotFoundException, SQLException {

        HashMap hm = new HashMap();


        JasperReport report = JasperCompileManager.compileReport("src/main/resources/reports/controlinterfaces.jrxml");

        JasperPrint jasperPrint = JasperFillManager.fillReport(
                report,
                hm,
                JDBCUtils.getConnection()
        );
        JRPdfExporter exp = new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("controlinterfaces.pdf"));
        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
        exp.setConfiguration(conf);
        exp.exportReport();
    }
}
