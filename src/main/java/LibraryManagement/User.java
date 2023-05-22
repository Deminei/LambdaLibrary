package LibraryManagement;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String libraryCardNumber;
    private List<Book> booksOnLoan;
    private Library library;

    public User(String name, String libraryCardNumber, Library library) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.booksOnLoan = new ArrayList<>();
        this.library = library;
    }

    public String getName() {
        return name;
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public List<Book> getBooksOnLoan() {
        return booksOnLoan;
    }

    public void addBook(Book book) {
        booksOnLoan.add(book);
    }

    public void removeBook(Book book) {
        booksOnLoan.remove(book);
    }

    public boolean hasBook(Book book) {
        return booksOnLoan.contains(book);
    }
    public Library getLibrary() {
        return library;
    }
}
