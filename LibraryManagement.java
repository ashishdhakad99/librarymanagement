import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LibraryManagement {
    private Map<String, List<Book>> library;

    public LibraryManagement() {
        library = new HashMap<>();
    }

    public void addBook(String category, String title, String author) {
        Book book = new Book(title, author);
        if (library.containsKey(category)) {
            library.get(category).add(book);
        } else {
            List<Book> books = new ArrayList<>();
            books.add(book);
            library.put(category, books);
        }
    }

    public void displayBooks() {
        for (String category : library.keySet()) {
            System.out.println("Category: " + category);
            List<Book> books = library.get(category);
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LibraryManagement libraryManagement = new LibraryManagement();
        Scanner ad = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice =ad.nextInt();
            ad.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter category: ");
                    String category = ad.nextLine();
                    System.out.print("Enter title: ");
                    String title = ad.nextLine();
                    System.out.print("Enter author: ");
                    String author = ad.nextLine();
                    libraryManagement.addBook(category, title, author);
                    break;
                case 2:
                    libraryManagement.displayBooks();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}