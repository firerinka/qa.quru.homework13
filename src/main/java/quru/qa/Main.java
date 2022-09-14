package quru.qa;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();

        Book book1 = new Book("Never let me go", "Kazuo Ishiguro", 2005);
        book1.addChapter("Chapter 1");
        book1.addChapter("Chapter 2");

        Book book2 = new Book("Harry Potter and Philosopher's Stone", "J. K. Rowling", 1997);
        book2.addChapter("The Boy Who Lived");
        book2.addChapter("The Vanishing Glass");
        book2.addChapter("The Letters from No One");

        Book book3 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
        book3.addChapter("The Worst Birthday");
        book3.addChapter("Dobby’s Warning");
        book3.addChapter("The Burrow");

        Book book4 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
        book4.addChapter("The Worst Birthday");
        book4.addChapter("Dobby’s Warning");
        book4.addChapter("The Burrow");

        bookShelf.putBookAtTheEndOfShelf(book2);
        bookShelf.putBookAtTheEndOfShelf(book1);
        bookShelf.putBookAfterBookWithTitle(book3, book1.getTitle());
        System.out.println(bookShelf.checkIfSameBookAlreadyOnTheShelf(book4));

        Library publicLibrary = new Library("Public library");
        publicLibrary.addBookToLibrary(book1);
        publicLibrary.addBookToLibrary(book2);
        publicLibrary.addBookToLibrary(book3);

        publicLibrary.getBookWithTitleFromLibraryForReader("Harry Potter and the Chamber of Secrets", "Marina Remneva");
        publicLibrary.returnBookWithTitleToLibrary("Harry Potter and the Chamber of Secrets");
        publicLibrary.getBookWithTitleFromLibraryForReader("Harry Potter and the Chamber of Secrets", "Sasha Tonks");
        publicLibrary.printAllBooksInfo();

    }
}
