module com.example.dei_examen_alumno {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires org.hibernate.commons.annotations;
    requires java.naming;
    requires java.sql;
    requires java.base;

    requires jasperreports;

    opens com.example.exameninterfaces to javafx.fxml;
    exports com.example.exameninterfaces;
    exports com.example.exameninterfaces.controller;
    opens com.example.exameninterfaces.controller to javafx.fxml;
    exports com.example.exameninterfaces.model;
    opens com.example.exameninterfaces.model to javafx.fxml;
    exports com.example.exameninterfaces.util;
    opens com.example.exameninterfaces.util to javafx.fxml;
}