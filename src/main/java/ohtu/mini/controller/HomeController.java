package ohtu.mini.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ohtu.mini.domain.Reference;
import ohtu.mini.service.ReferenceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    
    @Autowired
    ReferenceServiceInterface refService;

//    @RequestMapping(value = "/home")
//    public String home() {
//        return "home";
//    }
    
    @RequestMapping(method = RequestMethod.GET, value = "alkunakyma")
    public String nakymaGet(Model model) {
        model.addAttribute("references", refService.list());
        return "alkunakyma";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "bibtex")
    public String bibtexGet(Model model) {
        List<Reference> References = refService.list();
        ArrayList<String> Texes = new ArrayList<String>();
        for (Reference reference : References) {
            Texes.add(reference.toBibtex());
        }
        model.addAttribute("texes", Texes);
        return "bibtex";
    }

    @RequestMapping(method = RequestMethod.GET, value = "*")
    public String redirectNakyma() {
        return "redirect:/alkunakyma";
    }

    @RequestMapping(method = RequestMethod.POST, value = "lisaaviite")
    public String addReference(@ModelAttribute Reference reference) {
        this.refService.add(reference);
        return "redirect:/alkunakyma";
    }
}
