import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PopularidadTendencia implements Popularidad {
    private static final int horasSinReproducirMax = 24;

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
        Duration duracion = Duration.between(c.getUltimaReproduccion(), LocalDateTime.now());
        if (duracion >= horasSinReproducirMax) {
            return new PopularidadNormal();
        }
        return this;
    }

    @Override
    public String obtenerPopularidad() {
        return "\u001B[95m" + "Popularidad: Tendencia" + "\u001B[0m";
    }
}
