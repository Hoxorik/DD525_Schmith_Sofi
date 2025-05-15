public class PopularidadEnAuge implements Popularidad {
    @Override
    public Icono obtenerIcono() {
        return Icono.ROCKET;
    }

    @Override
    public String obtenerLeyenda(Cancion c) {
        return c.getArtista() + " – " + c.getTitulo() + " (" + c.getAlbum() + " - " + c.getAnioAlbum() + ")";
    }

    @Override
    public Popularidad actualizarEstado(Cancion c) {
        if (c.getDislikes() >= 5000) {
            return new PopularidadNormal();
        } else if (c.getReproducciones() > 50000 && c.getLikes() > 20000) {
            return new PopularidadTendencia();
        }
        return this;
    }

    @Override
    public String obtenerPopularidad() {
        return "\u001B[36m" + "Popularidad: En auge" + "\u001B[0m";
    }
}
