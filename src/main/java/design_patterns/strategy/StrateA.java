package design_patterns.strategy;

public class StrateA implements Strategy {
    @Override
    public void execute() {
        System.out.println("执行策略A");
    }
}
