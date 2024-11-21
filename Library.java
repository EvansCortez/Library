package Library;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

// Library class to manage books, members, and reservations
public class Library {
    private ArrayList<Book> catalog;
    private ArrayList<Member> members;

    public Library() {
        catalog = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Add a book to the catalog
    public void addBook(String title, String author) {
        catalog.add(new Book(title, author));
        System.out.println("Book added: " + title + " by " + author);
    }

    // Remove a book from the catalog
    public void removeBook(String title) {
        catalog.removeIf(book -> book.title.equalsIgnoreCase(title));
        System.out.println("Book removed: " + title);
    }

    // Search for books by title
    public ArrayList<Book> searchBooksByTitle(String title) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : catalog) {
            if (book.title.equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    // Search for books by author
    public ArrayList<Book> searchBooksByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : catalog) {
            if (book.author.equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // Sort books by title
    public void sortBooksByTitle() {
        Collections.sort(catalog, Comparator.comparing(book -> book.title));
        System.out.println("Books sorted by title.");
    }

    // Sort books by author
    public void sortBooksByAuthor() {
        Collections.sort(catalog, Comparator.comparing(book -> book.author));
        System.out.println("Books sorted by author.");
    }

    // Display all books in the catalog
    public void displayCatalog() {
        for (Book book : catalog) {
            System.out.println(book);
        }
    }

    // Register a new member
    public void addMember(String name) {
        members.add(new Member(name));
        System.out.println("New member added: " + name);
    }

    // Find a member by name
    public Member findMember(String name) {
        for (Member member : members) {
            if (member.name.equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    // Borrow a book for a member
    public void borrowBook(String title, String memberName) {
        Book book = findBookByTitle(title);
        Member member = findMember(memberName);

        if (book == null || member == null) {
            System.out.println("Book or member not found.");
            return;
        }

        if (book.isAvailable) {
            book.isAvailable = false;
            member.borrowedBooks.add(book);
            System.out.println(memberName + " has borrowed the book: " + title);
        } else {
            System.out.println("Book is currently not available. Adding to reservation queue.");
            book.reservationQueue.add(member);
        }
    }

    // Return a book for a member
    public void returnBook(String title, String memberName) {
        Book book = findBookByTitle(title);
        Member member = findMember(memberName);

        if (book == null || member == null) {
            System.out.println("Book or member not found.");
            return;
        }

        if (member.borrowedBooks.remove(book)) {
            book.isAvailable = true;
            System.out.println(memberName + " has returned the book: " + title);

            // Check if there is anyone in the reservation queue
            if (!book.reservationQueue.isEmpty()) {
                Member nextMember = book.reservationQueue.poll();
                System.out.println("Notifying " + nextMember.name + " that the book " + title + " is now available.");
            }
        } else {
            System.out.println("This member did not borrow this book.");
        }
    }

    // Helper method to find a book by title
    private Book findBookByTitle(String title) {
        for (Book book : catalog) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}