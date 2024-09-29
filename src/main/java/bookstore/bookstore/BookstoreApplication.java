package bookstore.bookstore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.Kirja;
import bookstore.bookstore.domain.AppUser;
import bookstore.bookstore.domain.AppUserRepository;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner kirjaDemo(BookRepository repository, CategoryRepository cRepository, AppUserRepository uRepository) {
		return (args) -> {
			log.info("save couple of categories");
			cRepository.save(new Category("Fiction"));
			cRepository.save(new Category("Nonfiction"));
			log.info("Fetch all categories");
			for (Category category : cRepository.findAll()) {
				log.info(category.toString());
			}
			log.info("save couple of books");
			repository.save(new Kirja("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 9.00, cRepository.findByName("Fiction").get(0)));
			repository.save(new Kirja("Animal Farm", "George Orwell", 1945, "2212343-5", 10.00, cRepository.findByName("Fiction").get(0)));
			repository.save(new Kirja("Homo Deus", "Yuval Noah Harari", 2015, "9781784703936", 12.00, cRepository.findByName("Nonfiction").get(0)));

			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			uRepository.save(user1);
			uRepository.save(user2);
			log.info("Fetch all books");
			for (Kirja kirja : repository.findAll()) {
				log.info(kirja.toString());
			}
		};
	}
}
