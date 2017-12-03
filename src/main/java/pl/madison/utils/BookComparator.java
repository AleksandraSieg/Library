package pl.madison.utils;

import pl.madison.domain.Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    public int compare(Book o1, Book o2) {
        return o2.getNumberOfPages().compareTo(o1.getNumberOfPages());
    }
}
