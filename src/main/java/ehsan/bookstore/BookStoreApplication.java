package ehsan.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
    System.out.println(System.currentTimeMillis());
    // http://localhost:9098/api-docs/swagger-ui/index.html
    SpringApplication.run(BookStoreApplication.class, args);
	}

}
