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
}
