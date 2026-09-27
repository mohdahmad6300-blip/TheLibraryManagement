package com.library;

/**
 * Class Book : Represents a single book
 */
public class Book
{
    private String isbn;
    private String title;
    private String author;
    private boolean isIssued;
    private String issueTo;

    public  Book(String isbn, String title, String author)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isIssued = false;
        this.issueTo = null;

    }

    public void markAsIssued(String memberName)
    {
        this.isIssued = true;
        this.issueTo = memberName;
    }

    public void markReturned()
    {
        this.isIssued = false;
        this.issueTo = null;
    }

    // Getters

    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean isIssued() {
        return isIssued;
    }
    public String getIssuedTo() {
        return issueTo;
    }

    public String toString()
    {
        System.out.println();
        System.out.println("==============[ "+title+" ]===============");
        String status = isIssued ? "ISSUED --> to : "+issueTo : "AVAILABLE";

        return String.format("ISBN : %s\n" +
                "TITLE : %s\n" +
                "AUTHOR : %s\n" +
                "STATUS : %s", isbn, title, author, status);
    }

}
