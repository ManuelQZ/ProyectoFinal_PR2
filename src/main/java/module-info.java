module co.edu.uniquindio.parcial1fx.proyecto {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.parcial1fx.proyecto.ViewController to javafx.fxml;
    exports co.edu.uniquindio.parcial1fx.proyecto;
    exports co.edu.uniquindio.parcial1fx.proyecto.ViewController;
}