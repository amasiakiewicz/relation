package pl.company.relation.posting;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;
import pl.company.relation.posting.domain.PostingFacade;
import pl.company.relation.posting.domain.PostingQueryFacade;
import pl.company.relation.posting.domain.dto.PostingQueryDto;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class PostingControllerBaseTestClass {

    @Autowired
    private WebApplicationContext web;
    
    @MockBean
    private PostingFacade postingFacade;

    @MockBean
    private PostingQueryFacade postingQueryFacade;

    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(web);

        final LocalDate date = LocalDate.of(2018, 4, 5);
        final String account = "1232435";
        final String description = "olo";
        final PostingQueryDto postingQueryDto = new PostingQueryDto(
                date, account, description
        );
        
        Mockito.when(postingQueryFacade.findPostingByDescription(description))
                .thenReturn(Optional.of(postingQueryDto));
    
        Mockito.doNothing().when(postingFacade).create(any());
    }
    
}