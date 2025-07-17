package reportGenerator;

public interface IPrinter {
    void print(Data data);
    void fax(Data data);
    void scan(Data data);
}
