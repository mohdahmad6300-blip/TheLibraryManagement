package com.library;
import java.util.ArrayList;
import java.util.List;

/**
 * Member Class :- Represents a Library Member
 */
public class Member
{
    private String id;
    private String name;
    private List<Book> borrowedBooks;
    private static final int MAX_BOOKS_ALLOWED = 3;

    public Member (String id, String name)
    {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public boolean canBorrowMore()
    {
        return borrowedBooks.size() < MAX_BOOKS_ALLOWED;
    }

    public void addBorrowBook(Book book)
    {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book)
    {
        borrowedBooks.remove(book);
    }

    //Getters

    public  String getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public List<Book> getBorrowedBooks()
    {
        return borrowedBooks;
    }

    public String toString()
    {

        System.out.println();
        System.out.println("================= ["+name+"] =================");
        return String.format("MEMBER ID : %s\n " +
                "MEMBER NAME : %s\n " +
                "BOOKS BORROWED : %d book(s) borrowed ", id, name, borrowedBooks.size());

    }
}
