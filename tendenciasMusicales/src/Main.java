import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        Cancion c1 = new Cancion("Blinding Lights", "The Weeknd", "After Hours", 2020);
        Cancion c2 = new Cancion("Shape of You", "Ed Sheeran", "Divide", 2017);
        Cancion c3 = new Cancion("Bad Guy", "Billie Eilish", "When We All Fall Asleep, Where Do We Go?", 2019);

        System.out.println("Reproducciones de " + c3.getTitulo() + ": " + c3.getReproducciones());
        c3.reproducir();

        System.out.println("\n");

        // popularidad en auge
        c1.setReproducciones(1000);
        System.out.println("Reproducciones de " + c1.getTitulo() + ": " + c1.getReproducciones());
        c1.reproducir();
        // bajar popularidad por dislikes
        c1.setDislikes(5000);
        c1.agregarDislike();
        System.out.println("Dislikes de " + c1.getTitulo() + ": " + c1.getDislikes() +
                "\n" + c1.getPopularidad().obtenerPopularidad());

        System.out.println("\n");

        // popularidad tendencia
        c2.setReproducciones(60000);
        c2.reproducir();
        c2.setLikes(20000);
        c2.agregarLike();
        System.out.println("Reproducciones de " + c2.getTitulo() + ": " + c2.getReproducciones());
        System.out.println("Likes de " + c2.getTitulo() + ": " + c2.getLikes());
        // bajar popularidad por reproducciones NO FUNCIONA
        c2.setUltimaReproduccion(LocalDateTime.now().minusDays(1));
        c2.reproducir();
        System.out.println("La ultima reproduccion de la cancion " + c2.getTitulo() + " - " + c2.getArtista() + " fue hace mas de 24 horas" +
                "\n" + c2.getPopularidad().obtenerPopularidad());

    }
}
