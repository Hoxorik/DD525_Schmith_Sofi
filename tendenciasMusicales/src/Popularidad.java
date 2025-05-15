public interface Popularidad {
    Icono obtenerIcono();
    String obtenerLeyenda(Cancion c);
    Popularidad actualizarEstado(Cancion c);
    String obtenerPopularidad();
}

