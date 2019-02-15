package design_patterns.strategy;

public class FactoryContext {

    private Strategy strategy ;

    public FactoryContext(String type) {
        switch (type){
            case "A":
                strategy = new StrateA();
                break;
            case "B":
                strategy = new StrateB();
                break;
            case "C":
                strategy = new StrateC();
                break;
            default:
                break;
        }
    }

    public void execute(){
        if (this.strategy != null){
            this.strategy.execute();
        }else {
            System.out.println("error");
        }
    }
}
