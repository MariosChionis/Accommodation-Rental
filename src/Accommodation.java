import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Accommodation implements Serializable {
    private String name;
    private String location;
    private int capacity; // Number of guests it can accommodate
    private ArrayList<Date> availableDates;
    private double pricePerNight;
    private float rating; // Average rating from reviews, range 1-5
    private String imagePath; // Path to the accommodation image

    // Constructor
    public Accommodation(String name, String location, int capacity, ArrayList<Date> availableDates, double pricePerNight, float rating, String imagePath) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.availableDates = availableDates;
        this.pricePerNight = pricePerNight;
        this.rating = rating;
        this.imagePath = imagePath;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Date> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(ArrayList<Date> availableDates) {
        this.availableDates = availableDates;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}