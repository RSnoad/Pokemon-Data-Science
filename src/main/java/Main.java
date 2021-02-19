import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        pokemonCSVReader.createPokemon();
        List<Pokemon> pokemons = pokemonCSVReader.getPokemon();

// TODO Testing? Just check values to allow for refactor? TDD didn't feel appropriate as exploratory exercise.

        //How many Pokémon species are there in total?
        int speciesCount = (int) pokemons
                .stream()
                .map(Pokemon::getSpecies)
                .distinct()
                .count();

        System.out.println("The number of unique Pokémon species is: " + speciesCount);


        // TODO CJ II pg. 17 - Optionals effective if provide alternative if value not present or value only consumed if it is present -
        //  is this being done properly here?

        //Can throw no such element exception?
        // Which Pokémon has the highest health?
        OptionalInt maxHP = pokemons
                .stream()
                .mapToInt(Pokemon::getHp)
                .max();

        System.out.println("\nThe Pokémon with the highest HP is/are:");
        pokemons
                .stream()
                .filter(e -> maxHP.equals(OptionalInt.of(e.getHp())))
                .map(Pokemon::getName)
                .forEach(System.out::println);

        // TODO Tried two slightly different approaches - look more into which is better.
        // Which Pokémon has the least health?
        int minHP = pokemons
                .stream()
                .mapToInt(Pokemon::getHp)
                .min()
                .orElseThrow(NoSuchElementException::new);

        System.out.println("\nThe Pokémon with the lowest HP is/are:");
        pokemons
                .stream()
                .filter(e -> minHP == e.getHp())
                .map(Pokemon::getName)
                .forEach(System.out::println);

        // Which Pokémon are of the Dancing Pokémon species?
        System.out.println("\nThe Pokémon that are of the Dancing species are: ");
        pokemons
                .stream()
                .filter(e -> e.getSpecies().equals("Dancing Pokémon"))
                .map(Pokemon::getName)
                .forEach(System.out::println);


        // How many Pokémon were in each generation?
        // Counts new forms as from the original generation - making the numbers look off.
        // TODO Many different ways/functions to achieve this - explore the other options too.

        Map<Integer, Long> generationCount =
                pokemons
                        .stream()
                        .collect(Collectors.groupingBy(Pokemon::getGeneration, Collectors.counting()));

        System.out.println("\nThe number of Pokemon in each generation are: ");
        System.out.println(generationCount);

        // Highest HP by primary type
// TODO How to filter this down to just by name

//        System.out.println(pokemons
//                .stream()
//                .collect(Collectors
//                        .groupingBy(Pokemon::getType1,
//                                Collectors.maxBy(Comparator.comparing(Pokemon::getHp)))));


//        System.out.println(maxHPByType1);
// How many Pokémon are of each (mythical, legendary, sub-legendary, normal)? - in status field

        Map<Status, Long> statusCount =
                pokemons
                        .stream()
                        .collect(Collectors.groupingBy(Pokemon::getStatus, Collectors.counting()));

        System.out.println("\n The number of Pokemon by status is:");
        System.out.println(statusCount);


    }


}
