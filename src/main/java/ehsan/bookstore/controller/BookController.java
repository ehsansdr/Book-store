package ehsan.bookstore.controller;

import ehsan.bookstore.persistent.domain.Book;
import ehsan.bookstore.persistent.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

  @Autowired
  private BookRepository bookRepository;

  @GetMapping("/query1")
  public List<Book> query1() {
    return bookRepository.findByEditionIsNullAndPrintYearGreaterThan(1390);
  }

  @GetMapping("/query2")
  public List<String> query2() {
    return bookRepository.findPublishersWithPriceLessThan(200000.0);
  }

  @GetMapping("/query3")
  public List<Object[]> query3() {
    return bookRepository.findCheapestBookPerPublisher();
  }

  @GetMapping("/query4")
  public List<Book> query4() {
    return bookRepository.findByPrintYearLessThanAndDeletedAtIsNullOrderByTitleAsc(1390);
  }

  @GetMapping("/all")
  public List<Book> all() {
    return bookRepository.findAll();
  }
}