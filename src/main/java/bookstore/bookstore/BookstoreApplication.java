package bookstore.bookstore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.Kirja;
import bookstore.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner kirjaDemo(BookRepository repository) {
		return (args) -> {
			log.info("save couple of books");
			repository.save(new Kirja("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 10.00));
			repository.save(new Kirja("Animal Farm", "George Orwell", 1945, "2212343-5", 10.00));
			log.info("Fetch all books");
			for (Kirja kirja : repository.findAll()) {
				log.info(kirja.toString());
			}
		};
	}

}
