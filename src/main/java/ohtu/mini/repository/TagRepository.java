package ohtu.mini.repository;

import java.util.List;
import ohtu.mini.domain.SampleObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<SampleObject, Long>{

	public Tag findById(long id);
	public List<Tag> findByTag(String tag);
        public List<Tag> findByReferenceId(long referenceId);

}
