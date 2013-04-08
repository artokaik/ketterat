package ohtu.mini.repository;

import java.util.List;
import ohtu.mini.domain.Author;
import ohtu.mini.domain.SampleObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<SampleObject, Long>{

	public Author findById(long id);
	public List<Author> findByTag(String tag);
        public List<Author> findByReferenceId(long referenceId);

}
