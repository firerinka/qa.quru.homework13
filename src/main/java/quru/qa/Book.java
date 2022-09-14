package quru.qa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private List<String> chapterTitles = new ArrayList<>();

    public Book(String title, String author, int publicationYear, List<String> chapterTitles) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.chapterTitles.addAll(chapterTitles);
    }

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public List<String> getChapterTitles() {
        return chapterTitles;
    }

    public void printBookInfo() {
        System.out.printf("Book title: \"%s\"%n", getTitle());
        System.out.printf("Book author: %s%n", getAuthor());
        System.out.printf("Publication year: %d%n", getPublicationYear());

        System.out.println("List of chapter titles:");
        for (String chapterTitle : chapterTitles) {
            System.out.printf("- \"%s\"%n", chapterTitle);
        }
    }

    public void addChapter(String chapterTitle) {
        chapterTitles.add(chapterTitle);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Book book = (Book) obj;
        return this.title.equals(book.title) && this.author.equals(book.author) && this.getPublicationYear() == book.getPublicationYear() &&
                this.getChapterTitles().size() == book.getChapterTitles().size() &&
                new HashSet<>(this.getChapterTitles()).containsAll(book.getChapterTitles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publicationYear, chapterTitles);
    }
}
