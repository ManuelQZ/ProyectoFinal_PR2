package co.edu.uniquindio.proyecto.arcade.controller;

import co.edu.uniquindio.proyecto.arcade.factory.Mediator;
import co.edu.uniquindio.proyecto.arcade.factory.ModelFactory;
import co.edu.uniquindio.proyecto.arcade.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

public class ProductoController {

    private ObservableList<Producto> listaProductoObservable;
    private Mediator factory;
    private static ProductoController instance;

    private ProductoController() {
        this.factory = Mediator.getInstancia();
        this.listaProductoObservable = FXCollections.observableArrayList();
        this.sincronizarData();
    }

    public static ProductoController getInstance(){
        if(instance == null){
            return instance = new ProductoController();
        }
        return instance;

    }

    public Mediator getFactory() {
        return factory;
    }


    public void eliminarProducto(String nombre){
        ArrayList<Producto> productos = factory.getArcade().getListaProducto();
        for (int i = 0; i < productos.size(); i++){
            if (Objects.equals(productos.get(i).getNombre(), nombre)){
                productos.remove(productos.get(i));
                this.listaProductoObservable.remove(productos.get(i));
            }
        }
    }

    public void actualizarProducto(String nombre, String precio, String cantidadDisponible){
        ArrayList<Producto> productos = factory.getArcade().getListaProducto();
        for (int i = 0; i < productos.size(); i++){
            if (Objects.equals(productos.get(i).getNombre(), nombre)){
                Producto nuevoProducto = new Producto(nombre, precio, cantidadDisponible);
                productos.remove(productos.get(i));
                productos.add(nuevoProducto);
                this.listaProductoObservable.remove(productos.get(i));
                this.listaProductoObservable.add(nuevoProducto);
            }
        }
    }

    public  Producto consultarProducto(String nombre){
        ArrayList<Producto> productos = factory.getArcade().getListaProducto();
        for (Producto value : productos) {
            if (value.getNombre().equals(nombre)){
                return value;
            }
        }
        return null;
    }

    public ObservableList<Producto> getListaProductoObservable() {
        return listaProductoObservable;
    }

    public void sincronizarData() {
        this.listaProductoObservable.addAll(this.factory.getArcade().getListaProducto());
    }
}
