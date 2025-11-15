package ehsan.bookstore.persistent.repository;

import ehsan.bookstore.persistent.domain.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  // 1. Books with unknown edition and print year > 1390
  List<Book> findByEditionIsNullAndPrintYearGreaterThan(Integer year);

  // 2. Publishers with price < 200,000
  @Query("SELECT DISTINCT b.publisher FROM Book b WHERE b.price < :price AND b.deletedAt IS NULL")
  List<String> findPublishersWithPriceLessThan(Double price);

  // 3. Cheapest book per publisher
  @Query("""
      SELECT b.publisher, MIN(b.price), b.title 
      FROM Book b 
      WHERE b.deletedAt IS NULL 
      GROUP BY b.publisher 
      ORDER BY b.publisher
      """)
  List<Object[]> findCheapestBookPerPublisher();

  List<Book> findByPrintYearLessThanAndDeletedAtIsNullOrderByTitleAsc(int i);

}