package ehsan.bookstore.persistent.seed;

import ehsan.bookstore.persistent.domain.Book;
import ehsan.bookstore.persistent.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class BookDataSeeder implements CommandLineRunner {

  @Autowired
  private BookRepository bookRepository;

  @PostConstruct
  public void seedData() {
    if (bookRepository.count() == 0) {
      List<Book> books = List.of(
          createBook("Java Advanced", "Aliyev R.", 1396, null, 195000.0, "Nəşriyyat A"),
          createBook("Spring Boot Guide", "Həsənov S.", 1389, "2nd", 165000.0, "Nəşriyyat B"),
          createBook("Database Systems", "Quliyev T.", 1393, null, 220000.0, "Nəşriyyat A"),
          createBook("Web Development", "Məmmədov K.", 1385, "1st", 85000.0, "Nəşriyyat C"),
          createBook("AI & ML", "Səfərov N.", 1399, "3rd", 280000.0, "Nəşriyyat B"),
          createBook("Python Programming", "Nəsirov F.", 1391, null, 140000.0, "Nəşriyyat D"),
          createBook("Cloud Computing", "İsmayılov B.", 1397, "1st", 310000.0, "Nəşriyyat E"),
          createBook("Data Science", "Rəhimov A.", 1387, "4th", 190000.0, "Nəşriyyat C"),
          createBook("Microservices", "Əliyev M.", 1394, null, 175000.0, "Nəşriyyat A"),
          createBook("DevOps Basics", "Qasımov H.", 1390, "2nd", 155000.0, "Nəşriyyat F"),
          createBook("Cybersecurity", "Babayev R.", 1383, "5th", 110000.0, "Nəşriyyat G"),
          createBook("Mobile App Dev", "Hüseynov E.", 1398, null, 205000.0, "Nəşriyyat B"),
          createBook("Blockchain", "Cəfərov S.", 1400, "1st", 350000.0, "Nəşriyyat H"),
          createBook("Big Data", "Məcidov T.", 1388, null, 180000.0, "Nəşriyyat D"),
          createBook("Frontend Mastery", "Əhmədov Z.", 1395, "2nd", 135000.0, "Nəşriyyat I"),
          createBook("Backend Architecture", "Qurbanov F.", 1386, "3rd", 95000.0, "Nəşriyyat C"),
          createBook("Testing Strategies", "Nəcəfov P.", 1392, null, 160000.0, "Nəşriyyat A"),
          createBook("Game Development", "Şükürov K.", 1401, "1st", 420000.0, "Nəşriyyat J"),
          createBook("Algorithms", "Məhərrəmov L.", 1384, "6th", 105000.0, "Nəşriyyat G"),
          createBook("Software Engineering", "Rüstəmov O.", 1390, "2nd", 198000.0, "Nəşriyyat F")
      );

      bookRepository.saveAll(books);
      log.info("20 BOOKS INSERTED INTO DATABASE!");
    }
  }

  private Book createBook(String title, String author, Integer printYear, String edition, Double price, String publisher) {
    Book book = new Book();
    book.setTitle(title);
    book.setAuthor(author);
    book.setPrintYear(printYear);
    book.setEdition(edition);
    book.setPrice(price);
    book.setPublisher(publisher);
    return book;
  }

  @Override
  public void run(String... args) throws Exception {
    this.seedData();
  }
}
