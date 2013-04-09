
package wad.springchat;

import java.util.LinkedList;
import java.util.Queue;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {
    
    Queue<String> viestit = new LinkedList<String>();
    
    @RequestMapping(value = "login", method=RequestMethod.GET)
    public String loginGet() {
        return "login";
    }    
    
    @RequestMapping(value = "login", method=RequestMethod.POST)
    public String Login(@RequestParam String tunnus, HttpSession sessio) {
        
        sessio.setAttribute("tunnus", tunnus);
        
        return "redirect:/chat";
    }
    
    @RequestMapping(value = "chat", method=RequestMethod.GET)
    public String Chat(Model model, HttpSession sessio) {       
        
        if (sessio.getAttribute("tunnus") == null) return "redirect:/login";
        model.addAttribute("viestit", viestit);
        model.addAttribute("tunnus", sessio.getAttribute("tunnus"));
        return "chat";
    }
    
    @RequestMapping(value = "chat", method=RequestMethod.POST)
    public String Chat(@RequestParam String viesti, Model model, HttpSession sessio) {
        if (sessio.getAttribute("tunnus") == null) return "redirect:/login";
        viestit.add(sessio.getAttribute("tunnus") + ": " + viesti);        

        return "redirect:/chat";
    }
    
    @RequestMapping(value = "*", method=RequestMethod.GET)
    public String redirectLogin() {
        return "redirect:/login";
    } 
    
    @RequestMapping(value = "logout", method=RequestMethod.GET)
    public String logOut(HttpSession sessio) {
        sessio.invalidate();
        return "logout";
    } 
    
    
}
