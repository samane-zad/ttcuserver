package ac.ttcu.model.entity.mapper;

import ac.ttcu.common.enumerations.Majors;
import ac.ttcu.common.enumerations.Universities;
import ac.ttcu.model.entity.dto.UniMajorDTO;
import ac.ttcu.model.entity.table.UniMajor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",  imports = {UniMajorDTO.class, UniMajor.class})
public interface UniMajorMapper {
    UniMajorMapper INSTANCE= Mappers.getMapper(UniMajorMapper.class);


    UniMajor toEntity(UniMajorDTO dto);


    UniMajorDTO toDTO(UniMajor entity);


    List<UniMajor> toEntity(List<UniMajorDTO> dtoList);


    List<UniMajorDTO> toDTO(List<UniMajor> entityList);

    default Universities mapUni(String uni) {
        return Universities.valueOf(uni);
    }

    default String mapUni(Universities uni) {
        return uni.name();
    }

    default Majors mapMajor(String major) {
        return Majors.valueOf(major);
    }

    default String mapMajor(Majors major) {
        return major.name();
    }
}
