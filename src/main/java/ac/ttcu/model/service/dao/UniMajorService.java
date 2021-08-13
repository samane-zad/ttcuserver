package ac.ttcu.model.service.dao;

import ac.ttcu.common.enumerations.Constants;
import ac.ttcu.common.enumerations.Majors;
import ac.ttcu.common.enumerations.Universities;
import ac.ttcu.model.entity.dto.UniMajorDTO;
import ac.ttcu.model.entity.mapper.UniMajorMapper;
import ac.ttcu.model.entity.table.UniMajor;
import ac.ttcu.model.repository.UniMajorRepository;
import javassist.NotFoundException;
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

        Optional<UniMajor> uniMajor = uniMajorRepository.findUniMajorByName(Universities.valueOf(uniMajorDTO.getUni().name())
                , Majors.valueOf(uniMajorDTO.getMajor().name()));
        if (!uniMajor.isPresent())
            throw new NotFoundException(Constants.NO_UNIMAJOR_FOUND.name());
        return Optional.ofNullable(UniMajorMapper.INSTANCE.toDTO(uniMajor.get()));
    }


}
