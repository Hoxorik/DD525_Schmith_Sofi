package reportGenerator;

public class ReportGenerator {
    // DIP violado: dependencia directa de una clase concreta
    //private ConcreteDatabase db = new ConcreteDatabase();

    private IDatabaseSaver db;//arreglado, no depende directamete

    // ISP violado: la interfaz reportGenerator.IPrinter obliga a métodos que no siempre se usan
    //arreglado!!!
    private IPrinter printer;
    private IScannable scan;
    private IFaxable fax;

    public ReportGenerator(IPrinter printer,IScannable scan, IFaxable fax, IDatabaseSaver db) {
        this.printer = printer;
        this.scan = scan;
        this.fax = fax;
        this.db = db;
    }

    public void generateReport(Data data) {
        System.out.println("=== Generando informe ===");
        // lógica ficticia de agregación y formateo
        System.out.println("Procesando datos: " + data);
        // al final, guarda un registro del informe
        db.save("Informe sobre: " + data);
    }

    public void sendByEmail(String to, Data reportData) {
        System.out.println("=== Enviando informe por e-mail ===");
        System.out.println("Para: " + to);
        System.out.println("Contenido: " + reportData);
        // aquí podría ir la lógica real de SMTP
    }

    public void export(String format, Data reportData) {
        System.out.println("=== Exportando informe ===");
        System.out.println("Formato solicitado: " + format);
        switch (format) {
            case "PDF":
                exportPdf(reportData);
                break;
            case "XLS":
                exportXls(reportData);
                break;
            default:
                System.out.println("Formato no soportado: " + format);
        }
    }

    private void exportPdf(Data reportData) {
        System.out.println("Creando PDF con contenido: " + reportData);
        // simulación de uso de librería PDF
    }

    private void exportXls(Data reportData) {
        System.out.println("Creando XLS con contenido: " + reportData);
        // simulación de uso de librería Excel
    }

    public void printReport(Data reportData) {
        System.out.println("=== Imprimiendo informe ===");
        printer.print(reportData);
    }

    public void faxReport(Data reportData) {
        System.out.println("=== Enviando fax del informe ===");
        fax.fax(reportData);
    }

    public void scanReport(Data reportData) {
        System.out.println("=== Escaneando informe ===");
        scan.scan(reportData);
    }
}
