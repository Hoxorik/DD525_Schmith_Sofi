package reportGenerator;

public class ReportGenerator {

    //⚠️ emji para idetnficar rapido
    //buenasss, constructor para poder hacer que las clases no se instancien con new() sino que por abstraccion
    // antes:   private ConcreteDatabase database = new Database();
    //despues:  private ConcreteDatabase database;
    private ConcreteDatabase db;
    private Map<String, ExportStrategy> exportStrategies;

    // ISP violado: la interfaz reportGenerator.IPrinter obliga a métodos que no siempre se usan
    private Printable printer;
    //⚠️ antes habia una interfaz que se llamaba Iprinter con muchos metodos que no se usan como dice arriba
    // ahora para cada metodo cremaos 2 interfaces mas, teniendo 3 en total
    //y ahora solo implementamos la que nos importa que es Printable, la de fax y scan no nos importan

//Hicimos un estrategy para  no tener q usar el switch
    public ReportGenerator(ConcreteDatabase db, Printable printer, List<ExportStrategy> strategies) {
    this.db = db;
    this.printer = printer;
    this.exportStrategies = new HashMap<>();
    for (ExportStrategy s : strategies) {
        this.exportStrategies.put(s.getFormat(), s);
    }
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
    ExportStrategy strategy = exportStrategies.get(format);
    if (strategy == null) {
        System.out.println("Formato no soportado: " + format);
        return;
    }
    strategy.export(reportData);
}
/*
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
    //esto estabba mak ⚠️
    public void faxReport(Data reportData) {
        System.out.println("=== Enviando fax del informe ===");
        printer.fax(reportData);
    }
    //esto estabba mak ⚠️

    public void scanReport(Data reportData) {
        System.out.println("=== Escaneando informe ===");
        printer.scan(reportData);
    }*/s
}
