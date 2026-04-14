/**
 * Team Name: Naomi
 * Team Members: Naomi Finau
 * Course: CSIS 2430
 * Project: Programming Project 3 - The Knapsack Problem
 * Primary Author: Naomi Finau 
 *
 * Represents one experiment payload with a name, weight, and rating.
 */
public class Payload {
    private final int id;
    private final String name;
    private final int weight;
    private final int rating;

    public Payload(int id, String name, int weight, int rating) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getRating() {
        return rating;
    }

    public double getRatio() {
        return (double) rating / weight;
    }

    @Override
    public String toString() {
        return "#" + id + " " + name + " (weight=" + weight + ", rating=" + rating + ")";
    }
}
