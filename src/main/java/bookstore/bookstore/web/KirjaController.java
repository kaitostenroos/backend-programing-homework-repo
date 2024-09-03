package bookstore.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class KirjaController {

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String Books(Model model) {
        return "";
    }



}
