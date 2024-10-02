package bookstore.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import bookstore.bookstore.web.KirjaController;
import bookstore.bookstore.domain.Kirja;
import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.CategoryRepository;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private KirjaController controller;

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository cRepository;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	void searchBookByIsbn() {
		List<Kirja> books = repository.findByIsbn("2212343-5");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Animal Farm");
	}

	@Test
	void createNewBook() {
		Kirja kirja = repository.save(new Kirja("山田鐘人, アベツカ","葬送のフリーレン 8", 2022, "978-4-09-851148-8", 500.00, cRepository.findByName("Nonfiction").get(0)));
		assertThat(kirja.getId()).isNotNull();
	}

	@Test
	void deleteBook() {
		Long bookId = 1L;
		repository.deleteById(bookId);
	}


}
