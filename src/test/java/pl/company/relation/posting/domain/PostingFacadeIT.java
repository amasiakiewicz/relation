package pl.company.relation.posting.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import pl.company.relation.IT;
import pl.company.relation.posting.domain.dto.CreatePostingDto;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@IT
public class PostingFacadeIT {
    
    @Autowired
    private PostingFacade postingFacade;
    
    @Autowired
    private PostingRepository postingRepository;

    @Test
    public void shouldCreatePosting() {
        //given
        final CreatePostingDto createPostingDto = CreatePostingDtoAssembler.givenCreatePostingDto().assemble();

        //when
        postingFacade.create(createPostingDto);
        
        //then
        thenPosting().isCreated();
    }

    @Test
    public void shouldThrowExceptionOnDuplicateDescription() {
        //given
        givenPosting().withDescription("ala").inDb();
        final CreatePostingDto createPostingDto = CreatePostingDtoAssembler.givenCreatePostingDto().withDescription("ala").assemble();

        //when
        final Throwable thrownException = catchThrowable(() -> postingFacade.create(createPostingDto));

        //then
        assertThat(thrownException)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Posting description duplicated");
    }

    private PostingAssembler givenPosting() {
        return PostingAssembler.givenPosting(postingRepository);
    }

    private PostingAsserter thenPosting() {
        return PostingAsserter.thenPosting(postingRepository);
    }

}