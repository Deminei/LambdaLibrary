package LibraryManagement;

import java.time.LocalDate;

public class Main{
    public static void main(String[] args) {
        //Create a library
        Library library = new Library();

        //Create books
        Book book1 = new Book("The Fateful Voyage", "Roger Burnage", 2021, 347);
        Book book2 = new Book("The Pirate World", "Angus Konstam", 2019, 336);
        Book book3 = new Book("Pirate Latitudes: A Novel", "Michael Crichton", 2021, 320);
        Book book4 = new Book("Blackbeard: America's Most Notorious Pirate", "Angus Konstam", 2020, 198);
        Book book5 = new Book("How to Be a Pirate", "Sue Fliess", 2014, 24);

        //Add books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        System.out.println("Added five new books, titles: "+book1.getTitle()+"\n"+book2.getTitle()+"\n"+book3.getTitle()+"\n"+book4.getTitle()+"\n"+book5.getTitle());
        System.out.println();

        //Remove book5
        System.out.println("Removing book: "+book5.getTitle());
        library.removeBookByTitle("How to Be a Pirate");
        System.out.println();

        //Set category to books in library
        book1.setCategory("Fiction");
        book2.setCategory("Non-Fiction");
        book3.setCategory("Fiction");
        book4.setCategory("Non-Fiction");

        //Test findBooksPublishedInYear
        System.out.println("Books published in 2021: ");
        library.findBooksPublishedInYear(2021).forEach(System.out::println);

        //Test findBooksByAuthor
        System.out.println("Books by Angus konstam: ");
        library.findBooksByAuthor("Angus konstam").forEach(System.out::println);

        //Test findBookWithMostPages
        Book bookWithMostPages = library.findBookWithMostPages();
        System.out.println("Book with the most pages: \n" + bookWithMostPages);
        System.out.println();

        //Test findBooksGreaterThanPages
        System.out.println("Books with more than 200 pages: ");
        library.findBooksGreaterThanPages(200).forEach(System.out::println);
        System.out.println();

        //Test getAllBookTitlesSortedAlphabetically
        System.out.println("All book titles sorted alphabetically: ");
        library.getAllBookTitlesSortedAlphabetically().forEach(System.out::println);
        System.out.println();

        //Test findBooksInCategory
        System.out.println("Fiction books: ");
        library.findBooksInCategory("Fiction").forEach(System.out::println);
        System.out.println();
        System.out.println("Non-Fiction books: ");
        library.findBooksInCategory("Non-Fiction").forEach(System.out::println);

        //Creates a user
        User user = new User("Toothless Pete", "123456", library);

        //Test loanBook
        boolean loaned = library.loanBook(book3, user);
        System.out.println( user.getName()+" has "+ book1.title +" on loan: "+ loaned);
        System.out.println();

        //Test returnBook
        boolean returned = library.returnBook(book2, user);
        System.out.println(book2.title +" loan status: " + returned);
        System.out.println();

        //Test calculateLateFees
        book3.setLoanDate(LocalDate.now().minusWeeks(3));
        double lateFees = library.calculateLateFees(user);
        System.out.println(user.getName() +"\nLibrary card number: "+user.getLibraryCardNumber()+"\nBooks currently on loan: \n"+user.getBooksOnLoan()+"\nLate fees accrued: $" + lateFees);
        System.out.println();
    }
}
