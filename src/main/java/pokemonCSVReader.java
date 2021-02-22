import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class pokemonCSVReader {


    private static ArrayList<Pokemon> pokemon = new ArrayList<>();

    public static ArrayList<Pokemon> getPokemon() {
        return pokemon;
    }

    public static void createPokemon() throws IOException {

        // TODO Do manually at first, try OpenCSV or another library later e.g openCSV.
        FileReader fr = new FileReader("./src/main/java/Pokemon.CSV");
        BufferedReader br = new BufferedReader(fr);

        String line = "";

        //Consume the header line (seems gross - library probably fixes)
        String headerLine = br.readLine();

        while ((line = br.readLine()) != null) {


            String[] pokemonArray = line.split(",");


            // Seems fragile - what if new fields are added?
            int pokedexNumber = Integer.parseInt(pokemonArray[1]);
            String name = pokemonArray[2];
            int generation = Integer.parseInt(pokemonArray[5]);
            String species = pokemonArray[7];
            Type type1 = Type.valueOf(pokemonArray[9].toUpperCase());

            Type type2;
            // Could also be done by checking type_number column, currently don't use that data at all.
            if (pokemonArray[10].equals("")) {
                type2 = (Type.NONE);
            } else {
                type2 = (Type.valueOf(pokemonArray[10].toUpperCase()));
            }

            // IDK about casting like this. Data should be integers, but some decimals are in there randomly.
            int hp = (int) Double.parseDouble(pokemonArray[18]);

            Status status;
            // Workaround due to space in Sub Legendary string
            if (pokemonArray[6].equals("Sub Legendary")) {
                status = Status.SUBLEGENDARY;
            } else {
                status = Status.valueOf(pokemonArray[6].toUpperCase());
            }


            Pokemon pokemon = new Pokemon(pokedexNumber,
                    name,
                    generation,
                    species,
                    type1,
                    type2,
                    hp,
                    status);

            pokemonCSVReader.pokemon.add(pokemon);

        }



    }


}
