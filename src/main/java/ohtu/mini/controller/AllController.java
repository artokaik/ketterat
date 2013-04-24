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
import javax.validation.Valid;
import ohtu.mini.domain.Reference;
import ohtu.mini.service.ReferenceServiceInterface;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AllController {

    @Autowired
    ReferenceServiceInterface refService;
    
    @RequestMapping(method = RequestMethod.GET, value = "alkunakyma")
    public String getNakyma(Model model) {
        List<Reference> references = refService.list();
        ArrayList<Reference> refs = new ArrayList<Reference>();
        for (Reference reference : references) {
            reference.toString();
            refs.add(reference);
        }
        model.addAttribute("references", refs);
        return "alkunakyma";
    }

    @RequestMapping(method = RequestMethod.GET, value = "bibtex")
    public String getBibtex(Model model) {
        List<Reference> References = refService.list();
        ArrayList<String> Texes = new ArrayList<String>();
        for (Reference reference : References) {
            Texes.add(reference.toBibtex());
        }
        model.addAttribute("texes", Texes);
        return "bibtex";
    }
    
    @RequestMapping(value = "poista/{id}")
    public String removeReference(@PathVariable Long id) {
        System.out.println("MENEE METODIIN" + id);
        refService.delete(id);
        return "redirect:/alkunakyma";
    }

    @RequestMapping(method= RequestMethod.GET, value="bibfile.tex")
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
            Logger.getLogger(AllController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "*")
    public String redirectNakyma() {
        return "redirect:/alkunakyma";
    }

    @RequestMapping(method = RequestMethod.POST, value = "viite")
    public String addReference(@Valid @ModelAttribute Reference reference,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "alkunakyma";
        }
        this.refService.add(reference);
        return "redirect:/alkunakyma";
    }
}
