package org.example.backend.dto.mapper;

import org.example.backend.db.Post;
import org.example.backend.dto.request.PostWriteDto;
import org.example.backend.dto.respond.PostReadDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post mapPostWriteDtoToPost(PostWriteDto postWriteDto);
    PostReadDto mapPostToReadDto(Post post);
}
