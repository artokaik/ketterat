package ohtu.mini.repository;

import java.util.List;
import ohtu.mini.domain.SampleObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefTypeRepository extends JpaRepository<SampleObject, Long>{

	public RefType findById(long id);
	public List<RefType> findByTag(String typeName);

}
