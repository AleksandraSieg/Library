package pl.madison;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.madison.dao.BookDao;
import pl.madison.domain.Book;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner
{
    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Autowired
    BookDao bookRepository;

    public void run(String... strings) throws Exception {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();

        book1.setAuthor("Joanne Rowling");
        book2.setAuthor("J.R.R Tolkien");
        book3.setAuthor("Andrzej Sapkowski");
        book4.setAuthor("Henryk Sienkiewicz");

        book1.setTitle("Harry Potter i Komnata Tajemnic");
        book2.setTitle("Hobbit");
        book3.setTitle("Wiedźmin");
        book4.setTitle("W pustyni i w puszczy");

        book1.setNumberOfPages("324");
        book2.setNumberOfPages("690");
        book3.setNumberOfPages("478");
        book4.setNumberOfPages("233");

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
    }
}
