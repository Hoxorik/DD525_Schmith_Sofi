import java.util.ArrayList;
import java.util.HashMap;

public class MaquinaExpendedora {
    private int dinero;
    private Estado estado;
    private HashMap<Producto, Integer> productos;

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public Estado getEstado() {
        return estado;
    }

    public void cambiarEstado(Estado estado){
        this.estado = estado;
    }

    public void vender(){
        this.estado.vender(this.dinero);
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public HashMap<Producto, Integer> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<Producto, Integer> productos) {
        this.productos = productos;
    }
}
