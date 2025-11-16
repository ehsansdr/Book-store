package ehsan.bookstore.controller;

import ehsan.bookstore.persistent.domain.Book;
import ehsan.bookstore.persistent.repository.BookRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book", description = "Book queries for university assignment")
@RequiredArgsConstructor
public class BookController extends BaseController {

  private final BookRepository bookRepository;

  /**
   * 1- کتاب هایی که نسخه آن مشخص نیست و تاریخ چاپ آنها برای بعد از 1390
   */
  @Operation(
      summary = "Find books with null edition and print year greater than a value",
      description = "Returns all books where edition is NULL and print year is greater than the given year."
  )
  @GetMapping("/greater-than")
  public List<Book> getAllBooksByPrintYear(
      @RequestParam
      @Parameter(example = "1390", description = "Books printed after this year")
      int printYear) {
    return bookRepository.findByEditionIsNullAndPrintYearGreaterThan(printYear);
  }

  /**
   * 2- نشر هایی که قیمت آن ها کمتر از 200 هزار تومان هست
   */
  @Operation(
      summary = "Find publishers whose book prices are less than the given price",
      description = "Returns the list of publishers where at least one book is priced less than the specified amount."
  )
  @GetMapping("/less-than-price")
  public List<String> getAllBooksByPrice(
      @RequestParam
      @Parameter(name = "price", example = "200000.0", description = "Maximum price allowed")
      double price) {
    return bookRepository.findPublishersWithPriceLessThan(price);
  }

  /**
   * 3- قیمت ارزان ترین کتاب هر انتشارات
   */
  @Operation(
      summary = "Find cheapest book per publisher",
      description = "Returns each publisher with its cheapest book (title, price, etc.)."
  )
  @GetMapping("/find-heapest-book-per-publisher")
  public List<Object[]> getCheapestBookPerPublisher() {
    return bookRepository.findCheapestBookPerPublisher();
  }

  /**
   * 4- نام و شماره کتاب هایی که قبل از 1390 چاپ شده اند به صورت مرتب شده
   */
  @Operation(
      summary = "Find books printed before a specific year (sorted ASC by title)",
      description = "Returns list of books where print year is less than the given year, sorted by title ascending."
  )
  @GetMapping("/less-than-print-year")
  public List<Book> getAllBooksByPrintYearLess(
      @RequestParam
      @Parameter(name = "year", example = "1390", description = "Books printed before this year")
      int year) {
    return bookRepository.findByPrintYearLessThanAndDeletedAtIsNullOrderByTitleAsc(year);
  }

  @Operation(
      summary = "Get all books",
      description = "Returns all books in the database."
  )
  @GetMapping("/all")
  public List<Book> all() {
    return bookRepository.findAll();
  }
}
