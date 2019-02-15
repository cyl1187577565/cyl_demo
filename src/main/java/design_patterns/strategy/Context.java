package design_patterns.strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        this.strategy.execute();
    }
}
