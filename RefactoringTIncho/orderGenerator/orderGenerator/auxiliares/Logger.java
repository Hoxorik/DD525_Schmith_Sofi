package orderGenerator.auxiliares;

public class Logger implements ILogger {
    @Override
    public void log(String msg) {
        System.out.println("[LOG] " + msg);
    }
}
