package com.library;
import java.util.List;
import java.util.ArrayList;

/**
 * Library Class :-  Manages collections of Book objects and Member objects
 */
public class Library
{
    public String libraryName;
    private List<Book> catalog;
    private List<Member> members;

    public Library(String libraryName)
    {
        this.libraryName = libraryName;
        this.catalog = new ArrayList<Book>();
        this.members = new ArrayList<Member>();
    }

    public void addBook(Book book)
    {
        catalog.add(book);
        System.out.println("Book added : " + book.getTitle());
    }

    public void registerMember(Member member)
    {
        members.add(member);
        System.out.println("Member added : " + member.getName());
    }

    public void issueBook(String isbn , Member member)
    {

        if(member == null)
        {
            System.out.println("Member not found.");
            return;
        }

        Book book = findBookByIsbn(isbn);

        if(book == null)
        {
            System.out.println(
                    "Book not found with ISBN: " + isbn
            );
            return;
        }


        if(book == null)
        {
            System.out.println("Book not found with ISBN : " + isbn);
            return;
        }
        if(book.isIssued())
        {
            System.out.println("Cannot issue "+book.getTitle() +" Book already issued");
            return;
        }
        if(!member.canBorrowMore())
        {
            System.out.println(member.getName() +" has reached the maximum number of borrowed Books");
            return;
        }
        book.markAsIssued(member.getName());
        member.addBorrowBook(book);
        System.out.println(member.getName() +" has been borrowed successfully "+book.getTitle() );
    }

    public void returnBook(String isbn , Member member)
    {
        if(member == null)
        {
            System.out.println("Member not found.");
            return;
        }

        Book book = findBookByIsbn(isbn);
        if(book == null)
        {
            System.out.println(
                    "Book not found with ISBN: " + isbn
            );
            return;
        }


        if(book == null || !member.getBorrowedBooks().contains(book))
        {
            System.out.println(member.getName() +" doesn't have borrowed this Book");
            return;
        }
        book.markReturned();
        member.removeBorrowedBook(book);
        System.out.println(member.getName() +" has been returned successfully "+book.getTitle() );
    }

    public Book findBookByIsbn(String isbn)
    {
        for(Book b : catalog)
        {
            if(b.getIsbn().equals(isbn))
            {
                return b ;
            }
        }
        return null;
    }

    public Member findMemberById(String id)
    {
        for(Member m : members)
        {
            if(m.getId().equals(id))
            {
                return m;
            }
        }

        return null;
    }

    public void printCatalog()
    {
        for(Book b : catalog)
        {
            System.out.println(" "+b);
        }
    }

    public void printMembers()
    {
        for(Member m : members)
        {
            System.out.println(" "+m);
        }
    }
}
