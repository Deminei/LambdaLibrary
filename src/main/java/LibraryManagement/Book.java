package LibraryManagement;

import java.time.LocalDate;

public class Book {
    //Attributes
    String title;
    String author;
    int publicationYear;
    int pages;
    String category;
    private boolean onLoan;
    public LocalDate loanDate;

    //Constructor
    public Book(String title, String author, int publicationYear, int pages) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pages = pages;

    }

    //Setters and Getters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isOnLoan() {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }
    @Override
    public String toString() {
        return " Title: " + title +
                "\n Author: " + author +
                "\n Publication Year: " + publicationYear +
                "\n Pages: " + pages +
                "\n Category: " + category +
                "\n";
    }

}