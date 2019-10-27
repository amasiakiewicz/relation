package pl.company.relation.posting.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import pl.company.relation.IT;
import pl.company.relation.posting.domain.dto.PostingQueryDto;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@IT
public class PostingQueryFacadeIT {

    @Autowired
    private PostingQueryFacade postingQueryFacade;
    
    @Autowired
    private PostingRepository postingRepository;

    @Test
    public void shouldFindPosting() {
        //given
        final String description = "olo";
        givenPosting().withDescription("olo").inDb();
        
        //when
        final Optional<PostingQueryDto> posting = postingQueryFacade.findPostingByDescription(description);

        //then
        assertThat(posting).hasValueSatisfying(p -> 
                assertThat(p.description).isEqualTo("olo")
        );
    }
    
    @Test
    public void shouldNotFindPosting() {
        //given
        final String description = "olo";
        
        //when
        final Optional<PostingQueryDto> posting = postingQueryFacade.findPostingByDescription(description);

        //then
        assertThat(posting).isEmpty();
    }

    private PostingAssembler givenPosting() {
        return PostingAssembler.givenPosting(postingRepository);
    }

}