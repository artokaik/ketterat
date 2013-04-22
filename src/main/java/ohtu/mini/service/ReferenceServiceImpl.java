package ohtu.mini.service;

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
}
