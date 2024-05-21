module co.edu.uniquindio.parcial1fx.proyecto {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.proyecto.arcade.view to javafx.fxml;
    exports co.edu.uniquindio.proyecto.arcade;
    exports co.edu.uniquindio.proyecto.arcade.view;

}