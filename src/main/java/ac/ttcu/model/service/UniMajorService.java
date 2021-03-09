package ac.ttcu.model.service;

import ac.ttcu.model.entity.UniMajor;
import ac.ttcu.model.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UniMajorService {
    @Autowired
    CrudRepository<UniMajor, Integer> uniMajorRepository;

    public UniMajor findUniMajorById(Integer id) throws Exception {
        return uniMajorRepository.findOne(UniMajor.class, id);
    }

}
