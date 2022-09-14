package quru.qa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LibraryBook extends Book {
    private boolean isTaken = false;
    private Set<String> readersList = new HashSet<>();

    public LibraryBook(String title, String author, int publicationYear, List<String> chapterTitles, Set<String> readersList) {
        this(title, author, publicationYear, chapterTitles);
        this.readersList.addAll(readersList);
    }

    public LibraryBook(String title, String author, int publicationYear, List<String> chapterTitles) {
        super(title, author, publicationYear, chapterTitles);
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public Set<String> getReadersList() {
        return readersList;
    }

    @Override
    public void printBookInfo() {
        super.printBookInfo();
        if (!isTaken()) {
            System.out.println("Book is available");
        } else {
            System.out.println("Book is NOT available");
        }
    }

    public void addReader(String name) {
        readersList.add(name);
    }

    public void printReadersList() {
        System.out.println("Readers number: " + readersList.size());
        for (String reader : readersList) {
            System.out.println("- " + reader);
        }
    }
}
