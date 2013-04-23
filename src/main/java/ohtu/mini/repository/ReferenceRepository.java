package ohtu.mini.repository;

import java.util.List;
import ohtu.mini.domain.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenceRepository extends JpaRepository<Reference, Long>{

	public Reference findById(long id);
	public List<Reference> findByTitle(String title);
        public Reference findByAbbreviation(String abbreviation);

}
