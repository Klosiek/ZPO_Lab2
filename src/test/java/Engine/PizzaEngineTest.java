package Engine;

import org.junit.Test;

import java.util.*;

import Enum.Pizza;

import static org.junit.Assert.assertEquals;

public class PizzaEngineTest {

    /***
     * Inicjalizacja obiektu PizzaEngine
     */

    PizzaEngine pizzaEngine = new PizzaEngine();

    /***
     * Test jednostowy zapewniający, że dwa porównywane obiekty są identyczne.
     */

    @Test
    public void findCheapestSpicy(){
        assertEquals(Optional.of(Pizza.CARUSO), pizzaEngine.findCheapestSpicy());
    }

    /***
     * Test jednostowy zapewniający, że dwa porównywane obiekty są identyczne.
     */

    @Test
    public void findMostEpensiveVegetarian() {
        assertEquals(Optional.of(Pizza.VEGETARIANA), pizzaEngine.findMostExpensiveVegetarian());
    }

    /***
     * Test jednostowy zapewniający, że dwa porównywane obiekty są identyczne.
     */

    @Test
    public void iLikeMeat() {
        List<Pizza> pizzsa = Arrays.asList(Pizza.CAPRI, Pizza.HAVAI, Pizza.CARUSO, Pizza.MAMA_MIA, Pizza.SOPRANO, Pizza.CALABRESE, Pizza.TABASCO, Pizza.AMORE, Pizza.FARMER);
        assertEquals(pizzsa, pizzaEngine.iLikeMeat());
    }

    /***
     * Test jednostowy zapewniający, że dwa porównywane obiekty są identyczne.
     */

    @Test
    public void groupByPrice(){
        Map<Integer, List<Pizza>> pizzas = new HashMap<>();

        pizzas.put(16, Arrays.asList(Pizza.PASCETORE, Pizza.AMORE));
        pizzas.put(17, Arrays.asList(Pizza.CAPRI, Pizza.HAVAI));
        pizzas.put(18, Arrays.asList(Pizza.MAMA_MIA));
        pizzas.put(19, Arrays.asList(Pizza.CAPRESE, Pizza.FOUR_CHEESE));
        pizzas.put(20, Arrays.asList(Pizza.VEGETARIANA));
        pizzas.put(22, Arrays.asList(Pizza.TABASCO, Pizza.FARMER));
        pizzas.put(23, Arrays.asList(Pizza.SOPRANO));
        pizzas.put(24, Arrays.asList(Pizza.CALABRESE));
        pizzas.put(13, Arrays.asList(Pizza.MARGHERITA));
        pizzas.put(15, Arrays.asList(Pizza.CARUSO));

        assertEquals(pizzas, pizzaEngine.groupByPrice());
    }

    /***
     * Test jednostowy zapewniający, że dwa porównywane obiekty są identyczne.
     */

    @Test
    public void formatedMenu(){
        String pizzasMenu = "Marrgherita: cienkie ciasto, sos pomidorowy, ser\n" +
                "Capri: cienkie ciasto, sos pomidorowy, ser, szynka, pieczarki\n" +
                "Havai: cienkie ciasto, sos pomidorowy, ser, szynka, ananas\n" +
                "Caruso: cienkie ciasto, sos pomidorowy, kiełbasa, papryka peperoni\n" +
                "Mama Mia: cienkie ciasto, sos pomidorowy, ser, cebula, pieczarki, bekon\n" +
                "Soprano: grube ciasto, sos pomidorowy, ser, szynka, pieczarki, cebula, bekon, pieprz\n" +
                "Calabrese: grube ciasto, sos pomidorowy, ser, szynka, pieczarki, kiełbasa, cebula, oliwki\n" +
                "Vegetariana: cienkie ciasto, sos pomidorowy, ser, cebula, fasola, kukurydza, brokuły, rukola\n" +
                "Caprese: grube ciasto, sos pomidorowy, mozarella, ser feta, pomidor, bazylia\n" +
                "Pascetore: cienkie ciasto, sos pomidorowy, ser, tuńczyk, cebula\n" +
                "Cztery sery: cienkie ciasto, sos pomidorowy, ser, mozarella, ser feta, ser pleśniowy\n" +
                "Tabasco: grube ciasto, sos pomidorowy, ser, szynka, salami, papryka peperoni, kukurydza, tabasco\n" +
                "Amore: cienkie ciasto, sos pomidorowy, ser, kurczak, pomidor\n" +
                "Farmerska: grube ciasto, sos pomidorowy, ser, kurczak, bekon, cebula, kukurydza";

        assertEquals(pizzasMenu, pizzaEngine.formatedMenu());
    }
}
