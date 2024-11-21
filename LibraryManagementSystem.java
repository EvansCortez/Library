package Library;
import java.util.ArrayList;
import java.util.Scanner;

// LibraryManagementSystem class with a simple text-based interface for interaction
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Search Book by Author");
            System.out.println("5. Sort Books by Title");
            System.out.println("6. Sort Books by Author");
            System.out.println("7. Display Catalog");
            System.out.println("8. Register Member");
            System.out.println("9. Borrow Book");
            System.out.println("10. Return Book");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    System.out.print("Enter book title to remove: ");
                    title = scanner.nextLine();
                    library.removeBook(title);
                    break;
                case 3:
                    System.out.print("Enter book title to search: ");
                    title = scanner.nextLine();
                    ArrayList<Book> booksByTitle = library.searchBooksByTitle(title);
                    System.out.println("Search results:");
                    booksByTitle.forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter author name to search: ");
                    author = scanner.nextLine();
                    ArrayList<Book> booksByAuthor = library.searchBooksByAuthor(author);
                    System.out.println("Search results:");
                    booksByAuthor.forEach(System.out::println);
                    break;
                case 5:
                    library.sortBooksByTitle();
                    break;
                case 6:
                    library.sortBooksByAuthor();
                    break;
                case 7:
                    library.displayCatalog();
                    break;
                case 8:
                    System.out.print("Enter member name: ");
                    String memberName = scanner.nextLine();
                    library.addMember(memberName);
                    break;
                case 9:
                    System.out.print("Enter book title to borrow: ");
                    title = scanner.nextLine();
                    System.out.print("Enter member name: ");
                    memberName = scanner.nextLine();
                    library.borrowBook(title, memberName);
                    break;
                case 10:
                    System.out.print("Enter book title to return: ");
                    title = scanner.nextLine();
                    System.out.print("Enter member name: ");
                    memberName = scanner.nextLine();
                    library.returnBook(title, memberName);
                    break;
                case 11:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
