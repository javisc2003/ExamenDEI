package com.example.exameninterfaces.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.sf.jasperreports.engine.JRException;

import java.sql.SQLException;

public class MainViewController
{
    @javafx.fxml.FXML
    private TextField txtNombre;
    @javafx.fxml.FXML
    private TextField txtSexo;
    @javafx.fxml.FXML
    private TextField txtPeso;
    @javafx.fxml.FXML
    private TextField txtEdad;
    @javafx.fxml.FXML
    private TextField txtTalla;
    @javafx.fxml.FXML
    private TextField txtTipoActividad;
    @javafx.fxml.FXML
    private TextField txtObservaciones;
    @javafx.fxml.FXML
    private Button btnGuardar;
    @javafx.fxml.FXML
    private Button btnSalir;
    @javafx.fxml.FXML
    private Button btnDescargar;
    @javafx.fxml.FXML
    private Label metabolismo;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void guardar(ActionEvent actionEvent) {
        String nombre = txtNombre.getText();
        String sexo = txtSexo.getText();
        Double peso = Double.parseDouble(txtPeso.getText());
        Integer edad = Integer.parseInt(txtEdad.getText());
        Double talla = Double.parseDouble(txtTalla.getText());
        String tipoActividad = txtTipoActividad.getText();
        String observaciones = txtObservaciones.getText();
        Double GER = calcularGER(sexo, peso, edad, talla, tipoActividad);
        Double GET = calcularGET(GER, tipoActividad);
        metabolismo.setText("El cliente " + nombre + " tiene un GER de " + GER + " y un GET de " + GET);
    }
    private Double calcularGER(String sexo, Double peso, Integer edad, Double talla, String tipoActividad) {
        Double resultado;
        if ("Masculino".equalsIgnoreCase(sexo)) {
            resultado = 66.473 + 13.751 * peso + 5.0033 * talla - 6.755 * edad;
        } else {
            resultado = 655.0955 + 9.463 * peso + 1.8496 * talla - 4.6756 * edad;
        }
        resultado *= obtenerFactorActividad(tipoActividad);
        return resultado;
    }

    private Double calcularGET(Double GER, String tipoActividad) {
        return GER * obtenerFactorActividad(tipoActividad);
    }

    private Double obtenerFactorActividad(String tipoActividad) {
        switch (tipoActividad.toLowerCase()) {
            case "sedentario":
                return 1.3;
            case "moderado":
                return 1.6;
            case "activo":
                return 1.7;
            case "muy activo":
                return 2.1;
            default:
                throw new IllegalArgumentException("Tipo de actividad no válido: " + tipoActividad);
        }
    }
    @FXML
    private void salir() {
        System.exit(0);
    }

    @FXML
    private void descargar() {
        try {
            JasperController.generateReport();
        } catch (JRException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}