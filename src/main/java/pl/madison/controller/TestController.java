package pl.madison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.madison.dao.BookDao;
import pl.madison.domain.Book;
import pl.madison.utils.BookComparator;

import java.util.Collections;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    BookDao bookRepository;

    @RequestMapping(value = ("/show"), method = RequestMethod.GET)
    public String show(){
        String book = "";

        for (Book book1 : bookRepository.findAll()) {
            book = book + book1;
        }

        return book;
    }

//    public void change(int[] numbers, int location1, int location2){
//        int value1 = numbers[location1];
//        int value2 = numbers[location2];
//
//        numbers[location1] = value2;
//        numbers[location2] = value1;
//    }

//    public void bubbleSort(int[] tab){
//        int n = tab.length;
//
//        do{
//            for(int i = 0; i<n-1; i++){
//                if(tab[i] > tab[i+1]){
//                    change(tab, i, i+1);
//                }n = n -1;
//            }
//        }while(n>1);
//    }

    @RequestMapping(value = "/sortedByNumberOfPages", method = RequestMethod.GET)
    public String sortedByNumberOfPages(){
        List<Book> books = ((List<Book>)bookRepository.findAll());

        Collections.sort(books, new BookComparator());
        return "" + books;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(@RequestParam("id") Long id){
        bookRepository.delete(id);

        return "Book have been deleted";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestParam("id") Long id, @RequestParam("author") String author,
                         @RequestParam("title") String title, @RequestParam("numberOfPages") String numberOfPages){
        Book nBook = new Book();
        nBook = bookRepository.findOne(id);
        nBook.setAuthor(author);
        nBook.setTitle(title);
        nBook.setNumberOfPages(numberOfPages);

        bookRepository.save(nBook);

        return "You have updated book";
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public String add(@RequestParam("author") String author,
                         @RequestParam("title") String title, @RequestParam("numberOfPages") String numberOfPages) {
        Book nBook = new Book();
        nBook.setAuthor(author);
        nBook.setTitle(title);
        nBook.setNumberOfPages(numberOfPages);

        bookRepository.save(nBook);

        return "You have added new Book";
    }


}
