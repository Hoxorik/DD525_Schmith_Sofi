public interface Popularidad {
    Icono obtenerIcono();
    String obtenerLeyenda(Cancion c);
    String obtenerPopularidad();
    public abstract Popularidad actualizarEstado(Cancion c);
    public abstract void dislike(Cancion cancion);
    public abstract void like(Cancion cancion);
}

