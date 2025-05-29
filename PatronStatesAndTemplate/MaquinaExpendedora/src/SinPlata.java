public class SinPlata extends Estado{
    @Override
        public void vender(int dinero){
            if (dinero != 0){
                maquinaExpendedora.cambiarEstado(new ConPlata());
            }
        }
}
