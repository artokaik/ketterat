package ohtu.mini.service;

import java.util.List;
import ohtu.mini.domain.Reference;
import ohtu.mini.repository.ReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ReferenceServiceImpl implements ReferenceServiceInterface {

    @Autowired
    ReferenceRepository referenceRepository;
    

    @Override
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
}
