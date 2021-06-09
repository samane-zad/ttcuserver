package ac.ttcu.model.entity.mapper;


import ac.ttcu.model.entity.dto.UserDTO;
import ac.ttcu.model.entity.table.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", uses = {UserDTO.class, User.class})
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);


    @Mapping(target = "uniMajor",ignore = true)
    User toEntity(UserDTO userDTO);


    UserDTO toDTO(User user);



}