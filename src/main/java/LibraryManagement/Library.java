package LibraryManagement;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Library {
    private List<Book> books;
    private List<Book> loanedBooks;

    public Library() {
        books = new ArrayList<>();
        loanedBooks = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBookByTitle(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public List<Book> findBooksPublishedInYear(int year) {
        return books.stream()
                .filter(book -> book.getPublicationYear() == year)
                .toList();
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .toList();
    }

    public Book findBookWithMostPages() {
        return books.stream()
                .max(Comparator.comparingInt(Book::getPages))
                .orElse(null);
    }

    public List<Book> findBooksGreaterThanPages(int pages) {
        return books.stream()
                .filter(book -> book.getPages() > pages)
                .toList();
    }

    public List<String> getAllBookTitlesSortedAlphabetically() {
        return books.stream()
                .map(Book::getTitle)
                .sorted()
                .toList();
    }

    public List<Book> findBooksInCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    public boolean loanBook(Book book, User user) {
        Predicate<Book> isOnLoan = Book::isOnLoan;
        if (isOnLoan.negate().test(book)) {
            book.setLoanDate(LocalDate.now());
            book.setOnLoan(true);
            loanedBooks.add(book);
            user.addBook(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book, User user) {
        boolean result = false;
        Predicate<Book> isOnLoan = Book::isOnLoan;
        if (isOnLoan.and(user::hasBook).test(book)) {
            book.setOnLoan(false);
            loanedBooks.remove(book);
            user.removeBook(book);
            result = true;
        }
        return result;
    }

    public double calculateLateFees(User user) {
        LocalDate today = LocalDate.now();
        return user.getBooksOnLoan().stream()
                .mapToLong(book -> {
                    LocalDate dueDate = book.getLoanDate().plusWeeks(2);
                    if (today.isAfter(dueDate)) {
                        long daysLate = ChronoUnit.DAYS.between(dueDate, today);
                        return daysLate;
                    }
                    return 0L;
                })
                .sum() * 0.50;
    }
}
