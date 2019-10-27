package pl.company.relation.posting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.company.relation.posting.domain.PostingFacade;
import pl.company.relation.posting.domain.PostingQueryFacade;
import pl.company.relation.posting.domain.dto.CreatePostingDto;
import pl.company.relation.posting.domain.dto.PostingQueryDto;
import pl.company.relation.posting.domain.exception.PostingNotFoundException;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static pl.company.relation.posting.domain.dto.CreatePostingDto.DESCRIPTION_MIN_LENGTH;

@RestController
@RequestMapping("/postings")
class PostingController {
    private PostingFacade postingFacade;
    private PostingQueryFacade postingQueryFacade;

    @Autowired
    PostingController(final PostingFacade postingFacade, final PostingQueryFacade postingQueryFacade) {
        this.postingFacade = postingFacade;
        this.postingQueryFacade = postingQueryFacade;
    }

    @GetMapping(path = "{description}")
    PostingQueryDto findPostingByDescription(
            @PathVariable @NotBlank @Size(min = DESCRIPTION_MIN_LENGTH, message = "description.minLength") final String description
    ) {
        return postingQueryFacade
                .findPostingByDescription(description)
                .orElseThrow(PostingNotFoundException::new);
    }
    
    @PostMapping
    void create(@RequestBody @Valid CreatePostingDto createPostingDto) {
        postingFacade.create(createPostingDto);
    }
    
}
