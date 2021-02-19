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


            // Not sure on using setter or constructor, constructor limits access to data more but very hard to read.
            Pokemon pokemon = new Pokemon();

            // Seems fragile - what if new fields are added?
            pokemon.setPokedexNumber(Integer.parseInt(pokemonArray[1]));
            pokemon.setName(pokemonArray[2]);
            pokemon.setGeneration(Integer.parseInt(pokemonArray[5]));
            pokemon.setSpecies(pokemonArray[7]);
            pokemon.setType1(Type.valueOf(pokemonArray[9].toUpperCase()));

            // Could also be done by checking type_number column, currently don't use that data at all.
            if (pokemonArray[10].equals("")) {
                pokemon.setType2(Type.NONE);
            } else {
                pokemon.setType2(Type.valueOf(pokemonArray[10].toUpperCase()));
            }

            // Workaround due to space in Sub Legendary string
            if (pokemonArray[6].equals("Sub Legendary")) {
                pokemon.setStatus(Status.SUBLEGENDARY);
            } else {
                pokemon.setStatus(Status.valueOf(pokemonArray[6].toUpperCase()));
            }

            // IDK about casting like this. Data should be integers, but some decimals are in there randomly.
            pokemon.setHp((int) Double.parseDouble(pokemonArray[18]));

            pokemonCSVReader.pokemon.add(pokemon);

        }



    }


}
