import java.awt.*;
import java.util.*;
import java.io.*;

// Part 2
// I'm starting off with Zak's nice driver.

/*
Zak Staab
 */

public class MovieDriver {

    public static void main(String[] args){
        String fileName = "notimdb.csv";
        BufferedReader reader;
        Movie[] movies = new Movie[101];
        Set<Movie> library = new HashSet<Movie>();
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(fileName));
            int j = 0;
            while ((line = reader.readLine()) != null){
                movies[j] = new Movie(line.substring(0,line.indexOf(",")), Integer.parseInt(line.substring(line.indexOf(",")+ 1)));
                library.add(movies[j]); // also part 2
                j++;
            }

            // print numbered list of films in library

            for (int i = 0; i < library.size(); i++){
                System.out.println("" + i + ": " + movies[i]);
            }

        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        // also also Part 2
        // Sets for movie categories
        Set<Movie> favorites = new HashSet<Movie>();
        Set<Movie> watched = new HashSet<Movie>();
        Set<Movie> recentlyWatched = new HashSet<Movie>();
        Set<Movie> action = new HashSet<Movie>();
        Set<Movie> comedies = new HashSet<Movie>();
        Set<Movie> dramas = new HashSet<Movie>();

        // Some example action films from IMDB
        Movie[] actionExamples = new Movie[5];
        actionExamples[0] = movies[3];
        actionExamples[1] = new Movie("Heat", 1995);
        actionExamples[2] = movies[13];
        actionExamples[3] = new Movie("Kill Bill: Vol. 1", 2003);
        actionExamples[4] = movies[47];
        for (int i = 0; i < actionExamples.length; i++) {
            action.add(actionExamples[i]);
        }

        // Some example action-comedies from IMDB
        Movie [] actionComedyExamples = new Movie[5];
        actionComedyExamples[0] = new Movie("Big Hero 6", 2014);
        actionComedyExamples[1] = new Movie("The Interview", 2014);
        actionComedyExamples[2] = new Movie("Teenage Mutant Ninja Turtles", 2014);
        actionComedyExamples[3] = new Movie("22 Jump Street", 2014);
        actionComedyExamples[4] = new Movie("How to Train Your Dragon 2", 2014);

        for (int i = 0; i < actionComedyExamples.length; i++){
            action.add(actionComedyExamples[i]);
            comedies.add(actionComedyExamples[i]);
        }
        watched.add(actionComedyExamples[0]);
        watched.add(actionComedyExamples[4]);

        System.out.println("Welcome to Moviefone");
        favorites.add(movies[9]); // Fight Club
        favorites.add(movies[13]); // Inception
        favorites.add(movies[30]); // Raiders of the Lost Ark
        favorites.add(movies[51]); // The Prestige
        favorites.add(movies[92]); // Rashomon
        favorites.add(movies[90]); // Monty Python and the Holy Grail

        comedies.add(movies[4]);
        comedies.add(movies[48]);
        comedies.add(movies[85]);
        comedies.add(movies[90]);
        comedies.add(movies[99]);

        dramas.add(movies[0]);
        dramas.add(movies[1]);
        dramas.add(movies[2]);
        dramas.add(movies[3]);
        dramas.add(movies[7]);

        watched.add(movies[3]);
        watched.add(movies[4]);
        watched.add(movies[8]);
        watched.add(movies[9]);
        watched.add(movies[10]);
        watched.add(movies[13]);
        watched.add(movies[48]);
        watched.add(movies[90]);
        watched.add(movies[92]);

        recentlyWatched.add(movies[10]);
        recentlyWatched.add(movies[9]);
        recentlyWatched.add(movies[56]);
        recentlyWatched.add(movies[84]);
        recentlyWatched.add(movies[90]);

        watched.add(movies[56]);
        watched.add(movies[84]);

        // Part 3.2
        SetHelper<Movie> setOperations = new SetHelper<Movie>();

        // Action Comedies: all action films that are also comedies
        Set<Movie> actionComedies = setOperations.intersect(action, comedies);
        System.out.println("All action-comedies: " + actionComedies);

        // All movies I have not watched
        Set<Movie> unwatched = setOperations.difference(library, watched);
        System.out.println("All unwatched movies: " + unwatched);

        // My favorites that are comedies
        Set<Movie> favoriteComedies = setOperations.intersect(favorites, comedies);
        System.out.println("Favorite Comedies: " + favoriteComedies);

        // All comedies I have not watched
        Set<Movie> unwatchedComedies = setOperations.difference(comedies, watched);
        System.out.println("All unwatched Comedies: " + unwatchedComedies);

        // All action-comedies I have not watched
        Set<Movie> unwatchedActionComedies = setOperations.difference(actionComedies, watched);
        System.out.println("All unwatched action-comedies: " + unwatchedActionComedies);

        // All favorites I haven't watched recently
        Set<Movie> dustyFavs = setOperations.difference(favorites, recentlyWatched);
        System.out.println("Favorites you haven't watched in a while: " + dustyFavs);


        // Part 4
        // Movie-view number map
        Map<Movie,Integer> movieViews = new HashMap<Movie, Integer>();
        movieViews.put(movies[90], 50);
        movieViews.put(movies[9], 4);
        movieViews.put(movies[30], 5);
        movieViews.put(movies[51], 4);
        movieViews.put(movies[92], 1);
        movieViews.put(movies[13], 1);

        // Part 5
        // Queue for movie playlist
        System.out.println("Your PlayList");
        Queue<Movie> playList = new LinkedList<Movie>();
        playList.add(movies[4]); // adds Pulp Fiction to end of list
        Movie firstToPlay = playList.element(); // peek at first movie in list
        System.out.println("First movie in the list: " + firstToPlay);
        // remove first movie from list
        System.out.println("Removing " + playList.remove() + " from the list. . .");

        playList.add(movies[2]);
        playList.add(movies[1]);
        playList.add(movies[0]);
        playList.add(movies[3]);
        playList.add(movies[7]);

        System.out.println("Removing " + playList.remove() + " from the list. . .");
        System.out.println("Removing " + playList.remove() + " from the list. . .");
    }
}