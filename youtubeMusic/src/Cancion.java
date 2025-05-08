public class Cancion {
    private String titulo;
    private Persona autor;
    private String leyenda;
    private Icono icono;
    private int reproducciones;
    private int cantLikes;
    private int cantDisLikes;
    private int añoPublicacion;
    private String album;

    public Cancion(String titulo, Persona autor, String leyenda, int reproducciones, int cantLikes, int cantDisLikes, int añoPublicacion, String album) {
        this.titulo = titulo;
        this.autor = autor;
        this.leyenda = leyenda;
        this.reproducciones = reproducciones;
        this.cantLikes = cantLikes;
        this.cantDisLikes = cantDisLikes;
        this.añoPublicacion = añoPublicacion;
        this.album = album;
    }

    public Icono getIcono() {
        return icono;
    }

    public void setIcono() {
        if((reproducciones > 1000 && reproducciones < 50000) || (icono == Icono.ROCKET && cantLikes == 5000)){
            this.icono = Icono.MUSICAL_NOTE;
        } else if (cantLikes >= 20000){
            this.icono = Icono.ROCKET;
            
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda() {


    }

    public int getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }

    public int getCantLikes() {
        return cantLikes;
    }

    public void setCantLikes(int cantLikes) {
        this.cantLikes = cantLikes;
    }

    public int getCantDisLikes() {
        return cantDisLikes;
    }

    public void setCantDisLikes(int cantDisLikes) {
        this.cantDisLikes = cantDisLikes;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }



}
