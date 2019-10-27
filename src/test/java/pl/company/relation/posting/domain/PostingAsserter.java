package pl.company.relation.posting.domain;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE)
class PostingAsserter {

    private final PostingRepository postingRepository;

    static PostingAsserter thenPosting(final PostingRepository postingRepository) {
        return new PostingAsserter(postingRepository);
    }

    void isCreated() {
        final List<Posting> postings = postingRepository.findAll();
        Assertions.assertThat(postings).hasSize(1);
    }
}
