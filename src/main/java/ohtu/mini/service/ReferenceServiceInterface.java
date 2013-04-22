package ohtu.mini.service;

import java.io.IOException;
import java.util.List;
import ohtu.mini.domain.Reference;

public interface ReferenceServiceInterface {
    
	public List<Reference> list();
        public void add(Reference reference);
<<<<<<< HEAD
        public void generateAbbreviation(Reference reference);
=======
        public void generateBibtex(String file, List<Reference> references) throws IOException;
>>>>>>> 4dd1be10df6fda08cd6743b2f9fe7e1eac442687
        
}
