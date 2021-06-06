package ac.ttcu.model.service;

import ac.ttcu.common.Majors;
import ac.ttcu.common.Universities;
import ac.ttcu.model.entity.dto.UniMajorDTO;
import ac.ttcu.model.entity.mapper.UniMajorMapper;
import ac.ttcu.model.entity.table.UniMajor;
import ac.ttcu.model.repository.UniMajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UniMajorService {
    @Autowired
    UniMajorRepository uniMajorRepository;


    public Optional<UniMajorDTO> findUniMajor(UniMajorDTO uniMajorDTO) throws Exception {
        Optional<UniMajor> uniMajor= uniMajorRepository.findUniMajorByName(Universities.valueOf(uniMajorDTO.getUni())
                , Majors.valueOf(uniMajorDTO.getMajor()));
        return Optional.ofNullable(UniMajorMapper.INSTNCE.toDTO(uniMajor.get()));
    }

}
