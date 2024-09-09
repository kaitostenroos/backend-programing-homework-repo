package bookstore.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bookstore.bookstore.domain.Kirja;
import bookstore.bookstore.domain.BookRepository;

@Controller
public class KirjaController {
    @Autowired
    private BookRepository repository;

    @RequestMapping(value = { "/", "/booklist" })
    public String Books(Model model) {
        model.addAttribute("books", repository.findAll());
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
        return "addbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Kirja kirja) {
        repository.save(kirja);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/edit/{id}")
    public String showModStu(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("kirja", repository.findById(bookId));
        return "editbook";
    }

}
