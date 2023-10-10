package aop;

import lombok.Data;
import lombok.NonNull;

@Data
public class App {
    private final String name = "Billy";
    @LogExecutionTime
    public String getGreeting() {
        try {
            Thread.sleep(1_500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "hello " + getName();
    }

    @LogExecutionTime
    public void sayGreeting(@NonNull final String name) {
        try {
            Thread.sleep(1_500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("hello1 " + name);
    }

    public static void main(String[] args) {
        final App app = new App();
        System.out.println(app.getGreeting());
        app.sayGreeting("Jean");
    }
}
