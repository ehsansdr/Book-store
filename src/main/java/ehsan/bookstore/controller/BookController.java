package ehsan.bookstore.controller;

import ehsan.bookstore.persistent.domain.Book;
import ehsan.bookstore.persistent.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book")
public class BookController extends BaseController {

  @Autowired
  private BookRepository bookRepository;

  @GetMapping("/greater-than")
  public List<Book> getAllBooksByPrintYear(
      @RequestParam
      @Parameter(example = "1390", description = "get all the book that is greater than")
      int printYear) {
    return bookRepository.findByEditionIsNullAndPrintYearGreaterThan(printYear);
  }

  @GetMapping("/less-than-price")
  public List<String> getAllBooksByPrice(
      @RequestParam
      @Parameter(name = "price", example = "200000.0", description = "find the boke less than price")
      double price
  ) {
    return bookRepository.findPublishersWithPriceLessThan(price);
  }

  @GetMapping("/find-heapest-book-per-publisher")
  public List<Object[]> getCheapestBookPerPublisher() {
    return bookRepository.findCheapestBookPerPublisher();
  }

  @GetMapping("/less-than-print-year")
  public List<Book> getAllBooksByPrintYearLess(
      @RequestParam
      @Parameter(name = "year", example = "1390", description = "find by year but less than")
      int year
  ) {
    return bookRepository.findByPrintYearLessThanAndDeletedAtIsNullOrderByTitleAsc(year);
  }

  @GetMapping("/all")
  public List<Book> all() {
    return bookRepository.findAll();
  }
}