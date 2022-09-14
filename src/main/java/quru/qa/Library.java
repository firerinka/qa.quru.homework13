package quru.qa;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private String name;
    private HashMap<Integer, LibraryBook> booksIndexes = new HashMap<>();
    private int nextBookIndex = 0;

    public Library(String name) {
        this.name = name;
    }

    public void addBookToLibrary(LibraryBook book) {
        booksIndexes.put(nextBookIndex, book);
        nextBookIndex++;
    }

    public void addBookToLibrary(Book book) {
        LibraryBook lBook = new LibraryBook(book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getChapterTitles());
        addBookToLibrary(lBook);
    }

    public void getBookWithTitleFromLibraryForReader(String title, String readerName) {
        int index = findIndexByTitle(title);
        LibraryBook book = booksIndexes.get(index);

        if (!book.isTaken()) {
            LibraryBook newBook =
                    new LibraryBook(book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getChapterTitles(), book.getReadersList());
            newBook.setTaken(true);
            newBook.addReader(readerName);

            booksIndexes.put(index, newBook);
        }
    }

    public void returnBookWithTitleToLibrary(String title) {
        int index = findIndexByTitle(title);
        LibraryBook book = booksIndexes.get(index);
        LibraryBook newBook =
                new LibraryBook(book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getChapterTitles(), book.getReadersList());
        newBook.setTaken(false);

        booksIndexes.put(index, newBook);
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
        booksIndexes.get(findIndexByTitle(title)).printReadersList();
    }

    public void removeBookByIndex(int index) {
        booksIndexes.remove(index);
    }

    public void removeBookByTitle(String title) {
        booksIndexes.remove(findIndexByTitle(title));
    }

    public void removeBook(LibraryBook book) {
        booksIndexes.remove(findIndexByTitle(book.getTitle()));
    }

    private int findIndexByTitle(String title) {
        int index = -1;
        for (Map.Entry<Integer, LibraryBook> bookEntry : booksIndexes.entrySet()) {
            LibraryBook book = bookEntry.getValue();
            if (book.getTitle().equals(title)) {
                index = bookEntry.getKey();
                break;
            }
        }
        return index;
    }

}
