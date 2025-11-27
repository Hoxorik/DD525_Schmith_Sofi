public class PopularidadEnAuge implements Popularidad {
    private static final int reproduccionesMaximas = 50000;
    private static final int likesMaximos = 20000;
    private static final int dislikesMaximos = 5000;

    @Override
    public Icono obtenerIcono() {
        return Icono.ROCKET;
    }

    @Override
    public String obtenerLeyenda(Cancion c) {
        return c.getArtista() + " – " + c.getTitulo() + " ( " + c.getAlbum() + " - " + c.getAnioAlbum() + " ) ";
    }

    public static int getReproduccionesMaximas()
    {
        return reproduccionesMaximas;
    }

    public static int getDislikesMaximos()
    {
        return dislikesMaximos;
    }

    public static int getLikesMaximos()
    {
        return likesMaximos;
    }

    @Override
    public Popularidad actualizarEstado(Cancion c) {
        if (c.getDislikes() <= dislikesMaximos) {
            return new PopularidadNormal();
        } else if (c.getReproducciones() < reproduccionesMaximas && c.getLikes() < likesMaximos) {
            return new PopularidadTendencia();
        }
        return this;
    }

    @Override
    public String obtenerPopularidad() {
        return "\u001B[36m" + "Popularidad: En auge" + "\u001B[0m";
    }
}
