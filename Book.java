package Library;

import java.util.LinkedList;
import java.util.Queue;

// Book class to store book details
public class Book {
    String title;
    String author;
    boolean isAvailable;
    Queue<Member> reservationQueue;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.reservationQueue = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
    }
}