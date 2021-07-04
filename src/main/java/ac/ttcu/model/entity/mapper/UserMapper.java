package ac.ttcu.model.entity.mapper;


import ac.ttcu.model.entity.dto.UserDTO;
import ac.ttcu.model.entity.table.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring", imports = {UserDTO.class, User.class})
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);


    User toEntity(UserDTO dto);


    UserDTO toDTO(User entity);

}
