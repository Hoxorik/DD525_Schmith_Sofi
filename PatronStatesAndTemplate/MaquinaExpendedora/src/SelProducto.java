public class SelProducto extends Estado{
    @Override
    public void vender(int dinero){
        maquinaExpendedora.setDinero(maquinaExpendedora.getDinero() - dinero);

    }
}
