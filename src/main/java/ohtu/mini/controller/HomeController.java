package ohtu.mini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

//    @RequestMapping(value = "/home")
//    public String home() {
//        return "home";
//    }
    
    @RequestMapping(value = "nakyma", method=RequestMethod.GET)
    public String nakymaGet() {
        return "nakyma";
    } 
    
    @RequestMapping(value = "*", method=RequestMethod.GET)
    public String redirectNakyma() {
        return "redirect:/nakyma";
    } 
}
