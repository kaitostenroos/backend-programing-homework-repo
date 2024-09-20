package bookstore.bookstore.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.server.core.Relation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bookstore.bookstore.domain.Kirja;
import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;
import bookstore.bookstore.domain.BookRepository;

@Controller
public class KirjaController {
    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository cRepository;

    @RequestMapping(value = { "/", "/booklist" })
    public String Books(Model model) {
        model.addAttribute("books", repository.findAll());
        model.addAttribute("categories", cRepository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }

    @RequestMapping(value = "/add")
    public String addKirja(Model model) {
        model.addAttribute("kirja", new Kirja());
        model.addAttribute("categories", cRepository.findAll());
        return "addbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Kirja kirja, Category category) {
        repository.save(kirja);
        cRepository.save(category);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/edit/{id}")
    public String showModStu(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("kirja", repository.findById(bookId));
        model.addAttribute("categories", cRepository.findAll());
        return "editbook";
    }

    @RequestMapping(value = "books")
    public @ResponseBody List<Kirja>booklistRest() {
        return (List<Kirja>)repository.findAll();
    }

    @RequestMapping(value = "book{id}", method = RequestMethod.GET)
    public @ResponseBody Kirja findBookRest(@PathVariable("id") Long bookId) {
        return repository.findById(bookId).get();
    }

}
