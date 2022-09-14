package quru.qa;

import java.util.LinkedList;
import java.util.List;

public class BookShelf {
    private List<Book> books = new LinkedList<>();

    public void printAllBooksInfo() {
        for (Book book : books) {
            System.out.println("Book info");
            book.printBookInfo();
            System.out.println();
        }
    }

    public void putBookAtTheEndOfShelf(Book book) {
        books.add(book);
    }

    public void putBookAfterBookWithTitle(Book book, String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                books.add(i, book);
                break;
            }
        }
    }

    public void removeBookByTitle(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                books.remove(i);
                break;
            }
        }
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void removeAllAuthorsBooks(String author) {
        int index = findNextBookIndexWrittenByAuthor(author);
        int numberOfRemovedBooks = 0;

        while (index != -1) {
            books.remove(index);
            numberOfRemovedBooks++;
            index = findNextBookIndexWrittenByAuthor(author);
        }
        System.out.println("Number of removed books: " + numberOfRemovedBooks);
    }

    private int findNextBookIndexWrittenByAuthor(String author) {
        int index = -1;
        int i = 0;
        boolean isFound = false;

        while (i < books.size() && !isFound) {
            if (books.get(i).getAuthor().equals(author)) {
                index = i;
                isFound = true;
            }
            i++;
        }
        return index;
    }

    public boolean checkIfSameBookAlreadyOnTheShelf(Book book) {
        return books.contains(book);
    }
}
