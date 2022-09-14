package quru.qa;

import java.util.HashMap;
import java.util.Map;

public class Library {
    HashMap<Integer, LibraryBook> booksIndexes = new HashMap<>();
    private int booksNumber = 0;

    public void addBookToLibrary(LibraryBook book) {
        booksIndexes.put(booksNumber, book);
        booksNumber++;
    }

    public void addBookToLibrary(Book book) {
        LibraryBook lBook = new LibraryBook(book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getChapterTitles());
        addBookToLibrary(lBook);
    }

    public int getBookWithTitleFromLibraryForReader(String title, String readerName) {
        int index = -1;

        for (Map.Entry<Integer, LibraryBook> bookEntry : booksIndexes.entrySet()) {
            LibraryBook book = bookEntry.getValue();
            if (book.getTitle().equals(title)) {
                if (book.isTaken()) {
                    break;
                }

                LibraryBook newBook = new LibraryBook(book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getChapterTitles(), book.getReadersList());
                newBook.setTaken(true);
                newBook.addReader(readerName);
                booksIndexes.put(bookEntry.getKey(), newBook);
                index = bookEntry.getKey();
                break;
            }
        }
        return index;
    }

    public void returnBookWithTitleToLibrary(String title) {
        for (Map.Entry<Integer, LibraryBook> bookEntry : booksIndexes.entrySet()) {
            LibraryBook book = bookEntry.getValue();
            if (book.getTitle().equals(title)) {
                LibraryBook newBook = new LibraryBook(book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getChapterTitles(), book.getReadersList());
                newBook.setTaken(false);
                booksIndexes.put(bookEntry.getKey(), newBook);
                break;
            }
        }
    }

    public void printAllBooksInfo() {
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
