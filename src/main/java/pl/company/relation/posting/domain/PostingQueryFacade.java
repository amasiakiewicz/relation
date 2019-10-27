package pl.company.relation.posting.domain;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import pl.company.relation.posting.domain.dto.PostingQueryDto;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;
import static lombok.AccessLevel.PACKAGE;

@AllArgsConstructor(access = PACKAGE)
@Transactional
public class PostingQueryFacade {
    private PostingRepository postingRepository;
        
    public Optional<PostingQueryDto> findPostingByDescription(final String description) {
        checkArgument(StringUtils.isNotBlank(description), "Description should not be blank");
        
        return postingRepository
                .findByDescription(description)
                .map(Posting::toQueryDto);
    }
    
}
