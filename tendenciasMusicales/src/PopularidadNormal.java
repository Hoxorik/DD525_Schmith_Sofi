public class PopularidadNormal implements Popularidad {
    @Override
    public Icono obtenerIcono() {
        return Icono.MUSICAL_NOTE;
    }

    @Override
    public String obtenerLeyenda(Cancion c) {
        return c.getArtista() + " – " + c.getAlbum() + " - " + c.getTitulo();
    }

    @Override
    public Popularidad actualizarEstado(Cancion c) {
        if (c.getReproducciones() > 1000) {
            return new PopularidadEnAuge();
        }
        return this;
    }

    @Override
    public String obtenerPopularidad() {
        return "\u001B[93m" + "Popularidad: Normal" + "\u001B[0m";
    }
}
