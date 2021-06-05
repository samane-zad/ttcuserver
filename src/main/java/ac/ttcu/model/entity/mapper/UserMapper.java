package ac.ttcu.model.entity.mapper;

import ac.ttcu.common.UserType;
import ac.ttcu.model.entity.dto.UserDTO;
import ac.ttcu.model.entity.table.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", imports = User.class, uses = {UserDTO.class, User.class})
public interface UserMapper {


    @Mapping(target = "userType", expression = "java(map(userDTO.getUserType()))")
    User toEntity(UserDTO userDTO);

    @Mapping(target = "userType", expression = "java(map(user.getUserType()))")
    UserDTO toDTO(User user);

    default UserType map(String userType) {
        return UserType.valueOf(userType);
    }

    default String map(UserType userType) {
        return userType.name();
    }

}
