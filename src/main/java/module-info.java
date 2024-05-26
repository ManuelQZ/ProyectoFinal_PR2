module co.edu.uniquindio.proyecto.arcade {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens co.edu.uniquindio.proyecto.arcade.view to javafx.fxml;
    exports co.edu.uniquindio.proyecto.arcade;
    exports co.edu.uniquindio.proyecto.arcade.view;

}