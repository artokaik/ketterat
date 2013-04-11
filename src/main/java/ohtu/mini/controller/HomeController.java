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
    
    @RequestMapping(method = RequestMethod.GET, value = "alkunakyma")
    public String nakymaGet() {
        return "alkunakyma";
    }

    @RequestMapping(method = RequestMethod.GET, value = "*")
    public String redirectNakyma() {
        return "redirect:/alkunakyma";
    }

    @RequestMapping(method = RequestMethod.POST, value = "alkunakyma")
    public String addReference(@ModelAttribute Reference reference) {
        this.refService.add(reference);
        return "redirect:/viitelisatty";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "viitelisatty")
    public String addReferenceZ(@ModelAttribute Reference reference) {
        this.refService.add(reference);
        return "redirect:/viitelisatty";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "viitelisatty")
    public String viitelisattyGet() {
        return "viitelisatty";
    }

}
