package pl.company.relation.posting.domain;

import lombok.RequiredArgsConstructor;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor(access = PRIVATE)
class PostingAssembler {
    private final PostingRepository postingRepository;
    private String description = "olo";
    private LocalDate date = LocalDate.of(2018, 5, 6);
    private String account = "32432048372";
    private Money amount = Money.of(CurrencyUnit.EUR, 5.0);

    static PostingAssembler givenPosting(final PostingRepository postingRepository) {
        return new PostingAssembler(postingRepository);
    }

    void inDb() {
        final Posting posting = assemble();
        postingRepository.save(posting);
    }

    Posting assemble() {
        return new Posting(date, account, amount, description);
    }

    PostingAssembler withDescription(final String description) {
        this.description = description; 
        return this;
    }
}
