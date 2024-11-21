package Library;

import java.util.ArrayList;

// Member class to store member details
public class Member {
    String name;
    ArrayList<Book> borrowedBooks;

    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Member: " + name + ", Borrowed Books: " + borrowedBooks.size();
    }
}