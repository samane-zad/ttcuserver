package ac.ttcu.model.repository;

import ac.ttcu.common.enumerations.Majors;
import ac.ttcu.common.enumerations.Universities;
import ac.ttcu.model.entity.table.UniMajor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniMajorRepository extends JpaRepository<UniMajor, Long> {
    @Query(value = "select u from UniMajor u where u.uni=?1 and u.major=?2")
    Optional<UniMajor> findUniMajorByName(Universities uni, Majors major);
}
