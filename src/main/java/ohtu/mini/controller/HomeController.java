package ohtu.mini.controller;

import ohtu.mini.domain.Reference;
import ohtu.mini.service.ReferenceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    
    @RequestMapping(value = "alkunakyma", method = RequestMethod.GET)
    public String nakymaGet() {
        return "alkunakyma";
    }

    @RequestMapping(value = "*", method = RequestMethod.GET)
    public String redirectNakyma() {
        return "redirect:/alkunakyma";
    }

    @RequestMapping(value = "viitelisatty", method = RequestMethod.POST)
    public String addReference(@ModelAttribute Reference reference) {
        this.refService.add(reference);
        return "redirect:/alkunakyma";
    }

}
