package quru.qa;

import java.util.HashMap;
import java.util.Map;

public class Library {
    String name;
    HashMap<Integer, LibraryBook> booksIndexes = new HashMap<>();
    private int booksNumber = 0;

    public Library(String name) {
        this.name = name;
    }

    public void addBookToLibrary(LibraryBook book) {
        booksIndexes.put(booksNumber, book);
        booksNumber++;
    }

    public void addBookToLibrary(Book book) {
        LibraryBook lBook = new LibraryBook(book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getChapterTitles());
        addBookToLibrary(lBook);
    }

    public void getBookWithTitleFromLibraryForReader(String title, String readerName) {
        for (Map.Entry<Integer, LibraryBook> bookEntry : booksIndexes.entrySet()) {
            LibraryBook book = bookEntry.getValue();
            if (book.getTitle().equals(title)) {
                if (book.isTaken()) {
                    break;
                }
                LibraryBook newBook =
                        new LibraryBook(book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getChapterTitles(), book.getReadersList());
                newBook.setTaken(true);
                newBook.addReader(readerName);

                booksIndexes.put(bookEntry.getKey(), newBook);
                break;
            }
        }
    }

    public void returnBookWithTitleToLibrary(String title) {
        for (Map.Entry<Integer, LibraryBook> bookEntry : booksIndexes.entrySet()) {
            LibraryBook book = bookEntry.getValue();
            if (book.getTitle().equals(title)) {
                LibraryBook newBook =
                        new LibraryBook(book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getChapterTitles(), book.getReadersList());
                newBook.setTaken(false);

                booksIndexes.put(bookEntry.getKey(), newBook);
                break;
            }
        }
    }

    public void printAllBooksInfo() {
        System.out.println("List of books in " + this.name);
        for (Map.Entry<Integer, LibraryBook> bookEntry : booksIndexes.entrySet()) {
            System.out.println("Book index: " + bookEntry.getKey());
            bookEntry.getValue().printBookInfo();
            System.out.println();
        }
    }

    public void printReadersListForBookByIndex(int index) {
        booksIndexes.get(index).printReadersList();
    }

    public void printReadersListForBookByTitle(String title) {
        for (Map.Entry<Integer, LibraryBook> bookEntry : booksIndexes.entrySet()) {
            LibraryBook book = bookEntry.getValue();
            if (book.getTitle().equals(title)) {
                book.printReadersList();
                break;
            }
        }
    }

}
