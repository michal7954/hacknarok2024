package org.example.backend.dto.mapper;

import org.example.backend.db.Post;
import org.example.backend.db.PostStatistic;
import org.example.backend.dto.request.PostWriteDto;
import org.example.backend.dto.respond.PostAndStatsReadDto;
import org.example.backend.dto.respond.PostReadDto;
import org.example.backend.dto.respond.PostStatisticReadDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post mapPostWriteDtoToPost(PostWriteDto postWriteDto);
    PostReadDto mapPostToReadDto(Post post);
    @Mapping(source = "post.id", target = "id")
    @Mapping(source = "postStatistic", target = "postStatisticReadDto", qualifiedByName = "postStatisticReadDtoMapping")
    PostAndStatsReadDto mapToPostAndStatsReadDto(Post post, PostStatistic postStatistic);


    @Named("postStatisticReadDtoMapping")
    default PostStatisticReadDto map(PostStatistic postStatistic) {
        if (postStatistic == null) {
            return null;
        }
        return new PostStatisticReadDto(
                postStatistic.getId(),
                postStatistic.getNumberOfViews(),
                postStatistic.getNumberOfLikes(),
                postStatistic.getNumberOfComments(),
                postStatistic.getNumberOfShares(),
                postStatistic.getEngagementRate(),
                postStatistic.getNumberOfImpressions(),
                postStatistic.getReach(),
                postStatistic.getClickThroughRate(),
                postStatistic.getConversionRate(),
                postStatistic.getAverageTimeSpent()
        );
    }
}
