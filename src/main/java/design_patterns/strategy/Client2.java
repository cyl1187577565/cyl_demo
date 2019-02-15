package design_patterns.strategy;

public class Client2 {
    public static void main(String[] args) {
        String type = "A";
        FactoryContext factoryContext = new FactoryContext(type);
        factoryContext.execute();
    }
}
