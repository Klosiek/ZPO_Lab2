import Engine.PizzaEngine;

public class Main {
    public static void main(String[] args){
        PizzaEngine engine = new PizzaEngine();

//        engine.iLikeMeat().forEach(pizza -> System.out.println(pizza));
////        System.out.println(engine.findCheapestSpicy());
        System.out.println(engine.formatedMenu());
//        System.out.println(engine.groupByPrice());
    }
}
