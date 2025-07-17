package orderGenerator.auxiliares;

public class Database {
    public void save(String table, String key, Object obj) {
        System.out.println("[DB] Guardando en " + table + ": " + key);
    }
}