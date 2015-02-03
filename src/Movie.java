// Part 1
public class Movie {
    // has things (fields, instance variables)
    private String name;
    private int year;

    // can do things (methods, behaviors)
    public Movie(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    public int getYear() {
        return this.year;
    }

    // this allows a Movie to be printed to the console
    public String toString() {
        String result = this.name + " (" + this.year + ")";
        return result;
    }

    public boolean equals(Movie otherMovie) {
        if (this.name.equals(otherMovie.name) &&
            this.year == otherMovie.year) {
            return true;
        }

        return false;
    }

}
