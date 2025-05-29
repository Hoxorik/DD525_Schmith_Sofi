public class ConPlata extends Estado{
    @Override
    public void vender(int dinero){
        if (dinero == 0){
            maquinaExpendedora.cambiarEstado(new SinPlata());
            maquinaExpendedora.setDinero(0);
        }else{
            maquinaExpendedora.cambiarEstado(new SelProducto());
        }
    }
}
