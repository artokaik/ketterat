package ohtu.mini.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import ohtu.mini.domain.Reference;
import ohtu.mini.service.ReferenceServiceInterface;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        List<Reference> references = refService.list();
        ArrayList<String> refStrings = new ArrayList<String>();
        for (Reference reference : references) {
            refStrings.add(reference.toString());
        }
        model.addAttribute("references", refStrings);
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

    @RequestMapping(method= RequestMethod.GET, value="bibfile")
//    public void getBibFile(@PathVariable("file_name") String fileName, HttpServletResponse response) {
    public void getBibFile(HttpServletResponse response) {
        String filename = "refFile.txt";
        try {
            refService.generateBibtex(filename, refService.list());
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine() + "\n");
            }
            FileInputStream fis = new FileInputStream(file);
            IOUtils.copy(fis, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    
//    @RequestMapping(method = RequestMethod.POST, value = "viitelisatty")
//    public String addReferenceViiteLisatty(@ModelAttribute Reference reference) {
//        this.refService.add(reference);
//        return "redirect:/viitelisatty";
//    }
    
//    @RequestMapping(method = RequestMethod.GET, value = "viitelisatty")
//    public String viiteLisattyGet() {
//        return "viitelisatty";
//    }
    
//    @RequestMapping(method = RequestMethod.GET, value = "viitelisatty")
//    public String viiteLisattyGet(Model model) {
//        model.addAttribute("references", refService.list());
//        return "viitelisatty";
//    }


}
