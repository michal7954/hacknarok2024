package org.example.backend.dto.mapper;

import org.example.backend.db.PostStatistic;
import org.example.backend.dto.respond.PostStatisticReadDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostStatisticMapper {
    PostStatisticReadDto mapPostStatisticToPostStatisticReadDto(PostStatistic postStatistic);
}
