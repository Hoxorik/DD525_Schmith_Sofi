import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PopularidadTendencia implements Popularidad {
    @Override
    public Icono obtenerIcono() {
        return Icono.FIRE;
    }

    @Override
    public String obtenerLeyenda(Cancion c) {
        return c.getTitulo() + " – " + c.getArtista() + " (" + c.getAlbum() + " - " + c.getAnioAlbum() + ")";
    }

    @Override
    public Popularidad actualizarEstado(Cancion c) {
        if (c.getUltimaReproduccion().isBefore(LocalDateTime.now())) { // si no se reprodujo en las ultimas 24 horas (no pude resolverlo)
            return new PopularidadNormal();
        }
        return this;
    }

    @Override
    public String obtenerPopularidad() {
        return "\u001B[95m" + "Popularidad: Tendencia" + "\u001B[0m";
    }
}
