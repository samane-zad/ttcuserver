package ac.ttcu.model.entity.mapper;

import ac.ttcu.model.entity.dto.PostDTO;
import ac.ttcu.model.entity.table.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Mapper(componentModel = "spring",  imports = {PostDTO.class, Post.class})
public interface PostMapper {
    PostMapper INSTANCE= Mappers.getMapper(PostMapper.class);
    Post toEntity(PostDTO dto);


    PostDTO toDTO(Post entity);


    List<Post> toEntity(List<PostDTO> dtoList);


    List<PostDTO> toDTO(List<Post> entityList);

    default byte[] mapImage(MultipartFile image) throws IOException {
        if (image != null)
            return image.getBytes();
        else return null;
    }

    default MultipartFile mapImage(byte[] image) {
//        if(image!=null)
//        return (MultipartFile) new ByteArrayResource(image);
//        else return null;
        return null;
    }

}
