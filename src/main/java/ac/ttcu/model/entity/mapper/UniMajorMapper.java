package ac.ttcu.model.entity.mapper;

import ac.ttcu.common.Majors;
import ac.ttcu.common.Universities;
import ac.ttcu.model.entity.dto.UniMajorDTO;
import ac.ttcu.model.entity.table.UniMajor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", imports = UniMajor.class, uses = {UniMajorDTO.class, UniMajor.class})
public interface UniMajorMapper {
    @Mappings({
            @Mapping(target = "uni", expression = "java(mapUni(uniMajorDTO.getUni()))"),
            @Mapping(target = "major", expression = "java(mapMajor(uniMajorDTO.getMajor()))")
    })
    UniMajor toEntity(UniMajorDTO uniMajorDTO);

    @Mappings({
            @Mapping(target = "uni", expression = "java(mapUni(uniMajor.getUni()))"),
            @Mapping(target = "major", expression = "java(mapMajor(uniMajor.getMajor()))")
    })
    UniMajorDTO toDTO(UniMajor uniMajor);

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
