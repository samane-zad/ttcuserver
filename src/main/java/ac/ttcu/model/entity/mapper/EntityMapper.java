package ac.ttcu.model.entity.mapper;

import ac.ttcu.model.entity.dto.ContentDTO;
import ac.ttcu.model.entity.table.Content;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EntityMapper<D,E> {
    E toEntity(D dto);

    D toDTO(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDTO(List<E> entityList);
}
