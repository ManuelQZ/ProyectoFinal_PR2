module co.edu.uniquindio.parcial1fx.proyecto {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.parcial1fx.proyecto to javafx.fxml;
    exports co.edu.uniquindio.parcial1fx.proyecto;
}