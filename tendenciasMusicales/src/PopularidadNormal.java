public class PopularidadNormal implements Popularidad {
    private static final int reproduccionesMaximas = 1000;
    private int reproducciones;

    @Override
    public Icono obtenerIcono() {
        return Icono.MUSICAL_NOTE;
    }



    public static int getReproduccionesMaximas()
    {
        return reproduccionesMaximas;
    }


    @Override
    public String obtenerLeyenda(Cancion c) {
        return c.getArtista() + " – " + c.getAlbum() + " - " + c.getTitulo();
    }

    @Override
    public Popularidad actualizarEstado(Cancion c) {
        if (c.getReproducciones() < reproduccionesMaximas) {
            return new PopularidadEnAuge();
        }
        return this;
    }

    @Override
    public String obtenerPopularidad() {
        return "\u001B[93m" + "Popularidad: Normal" + "\u001B[0m";
    }
    @Override
    public void dislike(Cancion cancion) {

    }

    @Override
    public void like(Cancion cancion) {

    }

}
