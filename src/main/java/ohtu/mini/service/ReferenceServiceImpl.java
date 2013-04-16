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
}
