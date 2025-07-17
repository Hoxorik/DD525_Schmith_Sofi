## Consignas trabajo refactoring

#### Ejercicio 1:
Refactorizar lo que consideren necesario en reportGenerator, shopping y orderGenerator teniendo en cuenta que queremos seguir los principios SOLID y evitar code smells.

#### Ejercicio 2:
Detectar los code smells que hay, nombrarlos y corregirlos:

```java
public class InvoiceService {
    //nombre no declarativo public void createInvoice(Order o) { 
    
    private double calcularTotal(Order orden) {
        double total = 0;
        for (LineItem item : orden.getItems()) {
            total += item.getPrice();
        }
        return total;
    }

    public void createInvoice(Order orden){
        //codigo duplicadoo
/*
        double total = 0;
        for (LineItem i : orden.getItems()) total += i.getPrice();*/
        double total = calcularTotal(orden);
        orden.setTotal(total);
        save(o);
    }

    public void createCreditNote(Order o) {/*
        double total = 0;
        for (LineItem i : o.getItems()) total += i.getPrice();*/ 
        double total = calcularTotal(orden);
        o.setTotal(-total);
        save(o);
    }

    // ...
}
```

```java
public class UserController {
    //Long Method
    /*

    public void registerUser(Request req) {
        // validaciones
        if (req.getEmail() == null || !req.getEmail().contains("@")) throw new BadRequest();
        if (req.getPassword().length() < 8) throw new BadRequest();
        // creación entidad
        User u = new User(req.getName(), req.getEmail());
        // persistencia
        userRepo.save(u);
        // generación de token
        String token = tokenService.generate(u);
        // envío de email
        emailService.send(u.getEmail(), "Bienvenido", "Tu token: " + token);
        // registro en bitácora
        audit.log("Nuevo usuario: " + u.getId());
        // respuesta HTTP
        resp.send("{\"token\":\"" + token + "\"}");
    }*/
   public void registerUser(Request req) {
    validarDatos(req);
    User usuario = crearUsuario(req);
    guardarUsuario(usuario);
    String token = generarToken(usuario);
    enviarEmailDeBienvenida(usuario, token);
    registrarEnBitacora(usuario);
    enviarRespuesta(token);
    }
    private void validarDatos(Request req) {
    if (req.getEmail() == null || !req.getEmail().contains("@")) throw new BadRequest();
    if (req.getPassword().length() < 8) throw new BadRequest();
    }

    private User crearUsuario(Request req) {
        return new User(req.getName(), req.getEmail());
    }

    private void guardarUsuario(User u) {
        userRepo.save(u);
    }

    private String generarToken(User u) {
        return tokenService.generate(u);
    }

    private void enviarEmailDeBienvenida(User u, String token) {
        emailService.send(u.getEmail(), "Bienvenido", "Tu token: " + token);
    }

    private void registrarEnBitacora(User u) {
        audit.log("Nuevo usuario: " + u.getId());
    }

    private void enviarRespuesta(String token) {
        resp.send("{\"token\":\"" + token + "\"}");
    }

}
```

```java
//SRP y usa el booleano como un Flag
public class ReportPrinter {

    public void printToConsole(String reportData) {
        System.out.println(reportData);
    }

    public void printToFile(String reportData, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(reportData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
public class ReportPrinter {
    public void printReport(String reportData, boolean toConsole, String filePath) {
        if (toConsole) {
            System.out.println(reportData);
        } else {
            try (FileWriter w = new FileWriter(filePath)) {
                w.write(reportData);
            }
        }
    }
}
*/
```
```java
//DEPENDENCIA CIRCULAR
public class A {
    private B b;
    public A(B b) { 
    this.b = b; 
    }
    public void doSomething() {
        b.help(this);
    }
}

public class B {
    // OPCION UNO, BORRAR ESTO: private A a;
    public B(A a) { this.a = a; }
    public void help(A caller) {
        caller.doSomethingElse();
    }
}
//OPCION DOS: creamos una interfaz

public interface Hacer {
    void doSomethingElse();
}

public class A implements Hacer {
    private B b;
    public A(B b) { this.b = b; }

    public void doSomething() {
        b.help(this);
    }

    public void doSomethingElse() {
        System.out.println();
    }
}

public class B {
    public void help(Hacer caller) {
        caller.doSomethingElse();
    }
}

```