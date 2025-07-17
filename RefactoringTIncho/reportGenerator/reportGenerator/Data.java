package reportGenerator;

public class Data {
    private String payload;

    public Data(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return payload;
    }
}
