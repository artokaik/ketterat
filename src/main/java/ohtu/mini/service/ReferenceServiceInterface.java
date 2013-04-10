package ohtu.mini.service;

import java.util.List;
import ohtu.mini.domain.Reference;

public interface ReferenceServiceInterface {

	public List<Reference> list();
        public void add(Reference reference);

}
