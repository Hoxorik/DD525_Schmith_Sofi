## Consignas trabajo refactoring

#### Ejercicio 1:
Refactorizar lo que consideren necesario en reportGenerator, shopping y orderGenerator teniendo en cuenta que queremos seguir los principios SOLID y evitar code smells.

#### Ejercicio 2:
Detectar los code smells que hay, nombrarlos y corregirlos:

```java
public class InvoiceService {
    public void createInvoice(Order o) {
        double total = 0;
        for (LineItem i : o.getItems()) total += i.getPrice();
        o.setTotal(total);
        save(o);
    }

    public void createCreditNote(Order o) {
        double total = 0;
        for (LineItem i : o.getItems()) total += i.getPrice();
        o.setTotal(-total);
        save(o);
    }

    // ...
}
```

```java
public class UserController {
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
    }
}
```

```java
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
```

```java
public class A {
    private B b;
    public A(B b) { this.b = b; }
    public void doSomething() {
        b.help(this);
    }
}

public class B {
    private A a;
    public B(A a) { this.a = a; }
    public void help(A caller) {
        caller.doSomethingElse();
    }
}
```