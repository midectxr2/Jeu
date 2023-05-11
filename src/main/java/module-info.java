module be.ac.umons.emile.jeu {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;




    opens be.ac.umons.emile.jeu.javafx to javafx.fxml;
    exports be.ac.umons.emile.jeu.javafx;
    opens be.ac.umons.emile.jeu.logique to javafx.fxml;
    exports be.ac.umons.emile.jeu.logique;
}