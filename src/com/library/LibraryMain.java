package com.library;
import java.util.Scanner;

public class LibraryMain
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("===================================================");
        System.out.println("     WELCOME TO THE LIBRARY MANAGEMENT SYSTEM");
        System.out.println("===================================================");

        System.out.print("Please Register Your Library Name : ");
        String libraryName = sc.nextLine();
        Library library = new Library("AK LIBRARY");

        System.out.println(libraryName+" Registered in our Software Successfully.");
        System.out.println("===================================================");
        int use;

        System.out.println("Do you want to Use your Library Management System (Yes-1/No-anyKey): ");
        use = sc.nextInt();

        if(use==1) {
            int choice;

            do {
                System.out.println("\n===================================================");
                System.out.println("=================[ " +library.libraryName + " SYSTEM ]=============");
                System.out.println("===================================================");

                System.out.println("1. Add Book");
                System.out.println("2. Register Member");
                System.out.println("3. Issue Book");
                System.out.println("4. Return Book");
                System.out.println("5. Show All Books");
                System.out.println("6. Show All Members");
                System.out.println("7. Quit");
                System.out.println("===================================================");
                System.out.println();

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addBook(library);
                        break;
                    case 2:
                        registerMember(library);
                        break;
                    case 3:
                        issueBook(library);
                        break;
                    case 4:
                        returnBook(library);
                        break;
                    case 5:
                        System.out.println("\n==============================================");
                        System.out.println("============= [ BOOKS CATALOG ] ================");
                        System.out.println("\n==============================================");
                        library.printCatalog();
                        break;
                    case 6:
                        System.out.println("\n==============================================");
                        System.out.println("============= [ ALL MEMBERS ] ================");
                        System.out.println("\n==============================================");
                        library.printMembers();
                        break;
                    case 7:
                        System.out.println("Thank you for using our Software.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
            while (choice != 7);
            sc.close();
        }
        else
        {
            System.out.println("Your Library still registered in our software -- Use it when you want.\nThanks for your Support.");
        }
    }

    public static void addBook(Library library)
    {
        System.out.println("\n=====================[ADD BOOK]========================");
        System.out.print("Enter ISBN : ");
        String isbn = sc.nextLine();
        System.out.print("Enter Book Name : ");
        String bookName = sc.nextLine();
        System.out.print("Enter Book Author : ");
        String author = sc.nextLine();


        Book book = new Book(isbn,bookName,author);
        library.addBook(book);
    }

    public static void registerMember(Library library)
    {
        System.out.println("\n======================[REGISTER MEMBER]=======================");
        System.out.print("Enter Member ID : ");
        String memberId = sc.nextLine();
        System.out.print("Enter Member Name : ");
        String memberName = sc.nextLine();


        Member member = new Member(memberId,memberName);
        library.registerMember(member);
    }

    public static void issueBook(Library library)
    {
        System.out.println("\n=====================[ISSUE BOOK]=======================]");
        System.out.print("Enter Book ISBN : ");
        String isbn = sc.nextLine();

        System.out.print("Enter Member ID : ");
        String memberId = sc.nextLine();

        Member member = library.findMemberById(memberId);

        if(member == null)
        {
            System.out.println("Member not found with ID: "+memberId);
            return;
        }

        library.issueBook(isbn,member);
    }

    public static  void returnBook(Library library)
    {
        System.out.println("\n======================[RETURN BOOK]=======================");
        System.out.print("Enter Book ISBN : ");
        String isbn = sc.nextLine();

        System.out.print("Enter Member ID : ");
        String memberId = sc.nextLine();

        Member member = library.findMemberById(memberId);

        if(member == null)
        {
            System.out.println("Member not found with ID: "+memberId);
        }
        library.returnBook(isbn,member);
    }
}
