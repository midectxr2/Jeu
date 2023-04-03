module be.ac.umons.emile.jeu {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires com.dlsc.formsfx;


    opens be.ac.umons.emile.jeu to javafx.fxml;
    exports be.ac.umons.emile.jeu;
}