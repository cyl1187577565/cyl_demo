package design_patterns.strategy;

public class Client {
    public static void main(String[] args) {
        String type = "A";
        Context context = null;
        switch (type){
            case "A":
                context = new Context(new StrateA());
                break;
            case "B":
                context = new Context(new StrateB());
                break;
            case "C":
                context = new Context(new StrateC());
                break;
                default:
                    break;
        }

        if(context != null){
            context.execute();
        }
    }
}
