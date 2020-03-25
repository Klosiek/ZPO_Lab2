package Engine;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import Enum.Pizza;

public class PizzaEngine {

    /**
     * Metoda znajduje i zwraca najtańszą ostrą pizzę z podanej listy.
     * Ostra pizza to taka, która ma przynajmniej jeden ostry składnik.
     * @return znaleziona pizza
     */

    public Optional<Pizza> findCheapestSpicy(){
        Optional<Pizza> pizzaStream = Pizza.stream()
                .filter(pizza -> pizza.getIngredients().stream().anyMatch(ingredient -> ingredient.isSpicy()))
                .min((p1, p2) -> p1.getIngredients().stream().mapToInt(ingredient -> ingredient.getPrice()).sum()
                        - p2.getIngredients().stream().mapToInt(ingredient -> ingredient.getPrice()).sum());

        return pizzaStream;
    }

        /**
         * Metoda znajduje i zwraca najdroższą wegetariańską pizzę.
         * Wegetariańska pizza to taka, która nie ma żadnego składnika mięsnego.
         * @return znaleziona pizza
         */

    public Optional<Pizza> findMostExpensiveVegetarian(){
        Optional<Pizza> pizza = Pizza.stream()
                .filter(pizza1 -> pizza1.getIngredients().stream()
                        .noneMatch(ingredient -> ingredient.isMeat()))
                .max((pizza1, pizza2) -> pizza1.getIngredients().stream().mapToInt(ingredient -> ingredient.getPrice()).sum()
                        - pizza2.getIngredients().stream().mapToInt(ingredient -> ingredient.getPrice()).sum());
        return pizza;
    }

    /**
     * Metoda znajduje i zwraca listę pizz, które zawierają mięso.
     * Pizza mięsna to taka, która ma conajmniej jeden składnik pochodzenia zwierzęcego.
     * @return znaleziona lista pizz
     */

    public List<Pizza> iLikeMeat(){
        Stream<Pizza> pizzas = Pizza.stream()
                .filter(pizza -> pizza.getIngredients().stream()
                        .anyMatch(ingredient -> ingredient.isMeat()));

        List<Pizza> resault = pizzas.collect(Collectors.toList());
        return resault;
    }

    /**
     * Metoda zwraca mapę, w której kluczem jest cena pizzy, a wartością zbiór pizz.
     * Dzieli wszystkie pizze na katagorie, gdzie kategorią jest cena.
     * @return mapa pizz pogrupowana po cenie
     */


    public Map<Integer, List<Pizza>> groupByPrice(){
        Map<Integer, List<Pizza>> pizzas = Pizza.stream()
                .collect(Collectors.groupingBy(p -> p.getIngredients().stream().mapToInt(p2 -> p2.getPrice()).sum()));
        return pizzas;


    }

    /**
     * Metoda tworzy i zwraca sformatowane menu stworzone z danej listy.
     * Formatowania wygląda następująco
     * <ul>
     * <li> Pojedyncza pizza zapisana w postaci: "nazwa_pizzy: nazwa_składnika1, nazwa_składnika2, etc."</li>
     * <li> Każda pizza zapisana w jednej linii tekstu, kolejne linie oddzielone znakiem '\n'</li>
     * <li> Po ostatnie pizzy nie ma być znaku '\n'</li>
     * </ul>
     * @return sformatowane menu
     */

    public String formatedMenu(){
        String pizzasMenu = Pizza.stream()
                .map(p -> p.getName() + ": " + p.getIngredients().stream()
                        .map(i -> i.getName()).collect(Collectors.joining(", ")))
                .collect(Collectors.joining("\n"));

        return pizzasMenu;
    }
}