package ohtu.mini.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import ohtu.mini.domain.Reference;
import ohtu.mini.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReferenceServiceImpl implements ReferenceServiceInterface {

    @Autowired
    ReferenceRepository referenceRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Reference> list() {
        return referenceRepository.findAll();
    }

    @Override
    public void add(Reference reference) {
        referenceRepository.save(reference);
    }

    public ReferenceRepository getReferenceRepository() {
        return referenceRepository;
    }

    @Override
<<<<<<< HEAD
    public void generateAbbreviation(Reference reference) {
        if (reference.getAbbreviation()==null ||reference.getAbbreviation().isEmpty()) {
            String first3Letters = reference.getAuthor().substring(0, 3);
            String year = reference.getYear() + "";
            year = year.substring(2, 4);
            String abbreviation = first3Letters + year;

            char[] extraLetter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
            int i = 0;
            while (referenceRepository.findByAbbreviation(abbreviation) != null) {
                abbreviation = abbreviation.substring(0, 5) + extraLetter[i];
                i++;
            }
            reference.setAbbreviation(abbreviation);
        }
    }
=======
    public void generateBibtex(String file, List<Reference> references) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (Reference reference : references) {
            sb.append(reference.toBibtex());
            sb.append("\n");
        }
        FileWriter writer = new FileWriter(file);
        writer.write(sb.toString());
        writer.close();
    } 

>>>>>>> 4dd1be10df6fda08cd6743b2f9fe7e1eac442687
}
