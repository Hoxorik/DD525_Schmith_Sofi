import java.time.LocalDateTime;
import java.time.LocalTime;

public class Cancion {
    private String titulo;
    private String artista;
    private String album;
    private int anioAlbum;
    private int reproducciones;
    private int likes;
    private int dislikes;
    private LocalDateTime ultimaReproduccion;
    private Popularidad popularidad;

    public Cancion(String titulo, String artista, String album, int anioAlbum) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.anioAlbum = anioAlbum;
        this.popularidad = new PopularidadNormal();
    }

    public void reproducir() {
        this.reproducciones++;
        this.ultimaReproduccion = LocalDateTime.now();
        popularidad = popularidad.actualizarEstado(this);
        System.out.println(popularidad.obtenerPopularidad() + " / " + popularidad.obtenerLeyenda(this));
    }

    // Getters y Setters
    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public String getAlbum() { return album; }
    public int getAnioAlbum() { return anioAlbum; }
    public int getReproducciones() { return reproducciones; }
    public int getLikes() { return likes; }
    public int getDislikes() { return dislikes; }
    public LocalDateTime getUltimaReproduccion() { return ultimaReproduccion; }

    public Popularidad getPopularidad() {
        return popularidad;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setAnioAlbum(int anioAlbum) {
        this.anioAlbum = anioAlbum;
    }

    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public void setUltimaReproduccion(LocalDateTime ultimaReproduccion) {
        this.ultimaReproduccion = ultimaReproduccion;
    }

    public void setPopularidad(Popularidad popularidad) {
        this.popularidad = popularidad;
    }

    public void agregarLike() {
        likes++;
        popularidad = popularidad.actualizarEstado(this);
    }
    public void agregarDislike() {
        dislikes++;
        popularidad = popularidad.actualizarEstado(this);
    }

    public void verificarPopularidad() {
        popularidad = popularidad.actualizarEstado(this);
    }
}
