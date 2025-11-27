
package TendenciasMusicales;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CancionTest {

    Cancion c1;

    @BeforeEach
    void setUp() {

        c1 = new Cancion("As It Was", "Harry Styles", "Harry's House", 2022);
    }

    @Test
    void testEstadoInicial() {
        assertEquals(PopularidadNormal.class.getName(), c1.getPopularidad().getClass().getName());
        assertEquals(0, c1.getReproducciones());
        assertEquals(0, c1.getLikes());
        assertEquals(0, c1.getDislikes());
    }

    @Test
    void testReproduccionesCambianPopularidad() {

        assertEquals(PopularidadNormal.class.getName(), c1.getPopularidad().getClass().getName());


        for (int i = 0; i < PopularidadNormal.getReproduccionesMaximas(); i++) {
            c1.reproducir();
        }


        assertEquals(PopularidadNormal.class.getName(), c1.getPopularidad().getClass().getName());


        c1.reproducir();
        assertEquals(EnAuge.class.getName(), c1.getPopularidad().getClass().getName());
    }

    @Test
    void testLikesCambianPopularidad() {

        for (int i = 0; i <= PopularidadNormal.getReproduccionesMaximas(); i++) {
            c1.reproducir();
        }


        for (int i = 0; i <= EnAuge.getLikesMaximos(); i++) {
            c1.like();
        }

        assertEquals(Tendencia.class.getName(), c1.getPopularidad().getClass().getName());
    }

    @Test
    void testCaidaDeTendenciaPorInactividad() {

        for (int i = 0; i <= PopularidadNormal.getReproduccionesMaximas(); i++) c1.reproducir();
        for (int i = 0; i <= EnAuge.getLikesMaximos(); i++) c1.like();

        assertEquals(Tendencia.class.getName(), c1.getPopularidad().getClass().getName());


        c1.setUltimaReproduccion(LocalDate.of(2000, 1, 1).atStartOfDay());

        c1.setPopularidad(c1.getPopularidad().actualizarEstado(c1));


        assertEquals(PopularidadNormal.class.getName(), c1.getPopularidad().getClass().getName());
    }
}
