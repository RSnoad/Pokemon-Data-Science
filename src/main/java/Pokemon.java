import java.util.Objects;

public class Pokemon {

    private int pokedexNumber;
    private String name;
    private int generation;
    private String species;
    private Type type1;
    private Type type2;
    private int hp;
    private Status status;

    public Pokemon() {
    }

    public Pokemon(int pokedexNumber, String name, int generation, String species, Type type1, Type type2, int hp, Status status) {
        this.pokedexNumber = pokedexNumber;
        this.name = name;
        this.generation = generation;
        this.species = species;
        this.type1 = type1;
        this.type2 = type2;
        this.hp = hp;
        this.status = status;
    }

    public int getPokedexNumber() {
        return pokedexNumber;
    }

    public void setPokedexNumber(int pokedexNumber) {
        this.pokedexNumber = pokedexNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Type getType1() {
        return type1;
    }

    public void setType1(Type type1) {
        this.type1 = type1;
    }

    public Type getType2() {
        return type2;
    }

    public void setType2(Type type2) {
        this.type2 = type2;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return pokedexNumber == pokemon.pokedexNumber &&
                generation == pokemon.generation &&
                hp == pokemon.hp &&
                Objects.equals(name, pokemon.name) &&
                Objects.equals(species, pokemon.species) &&
                type1 == pokemon.type1 &&
                type2 == pokemon.type2 &&
                status == pokemon.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokedexNumber, name, generation, species, type1, type2, hp, status);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "pokedexNumber=" + pokedexNumber +
                ", name='" + name + '\'' +
                ", generation=" + generation +
                ", species='" + species + '\'' +
                ", type1=" + type1 +
                ", type2=" + type2 +
                ", hp=" + hp +
                ", status=" + status +
                '}';
    }
}

