package ac.ttcu.model.entity.mapper;

import ac.ttcu.common.enumerations.Universities;
import ac.ttcu.model.entity.dto.ContentDTO;
import ac.ttcu.model.entity.table.Content;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Mapper(componentModel = "spring",  imports = {ContentDTO.class, Content.class})
public interface ContentMapper {
    ContentMapper INSTANCE= Mappers.getMapper(ContentMapper.class);


    Content toEntity(ContentDTO dto);


    ContentDTO toDTO(Content entity);


    List<Content> toEntity(List<ContentDTO> dtoList);


    List<ContentDTO> toDTO(List<Content> entityList);

    default byte[] mapImage(MultipartFile image) throws IOException {
        return image.getBytes();
    }

    default MultipartFile mapImage(byte[] image) {
        return (MultipartFile) new ByteArrayResource(image);
    }
}
