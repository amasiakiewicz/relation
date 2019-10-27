package pl.company.relation.posting.domain;

import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import pl.company.relation.posting.domain.dto.CreatePostingDto;

import static lombok.AccessLevel.PACKAGE;

@AllArgsConstructor(access = PACKAGE)
@Transactional
public class PostingFacade {
    private PostingRepository postingRepository;
    
    public void create(final CreatePostingDto createPostingDto) {
        if (postingRepository.existsByDescription(createPostingDto.description)) {
            throw new IllegalStateException("Posting description duplicated");
        }
        
        final Posting posting = Posting.create(createPostingDto);
        postingRepository.save(posting);
    }
    
}
