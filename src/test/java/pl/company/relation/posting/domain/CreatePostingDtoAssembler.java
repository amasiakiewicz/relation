package pl.company.relation.posting.domain;

import lombok.NoArgsConstructor;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import pl.company.relation.posting.domain.dto.CreatePostingDto;

import java.time.LocalDate;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
class CreatePostingDtoAssembler {

    private String description = "olo";
    private LocalDate date = LocalDate.of(2018, 5, 6);
    private String account = "32432048372";
    private Money amount = Money.of(CurrencyUnit.EUR, 5.0);

    static CreatePostingDtoAssembler givenCreatePostingDto() {
        return new CreatePostingDtoAssembler();
    }

    CreatePostingDto assemble() {
        return new CreatePostingDto(date, account, amount, description);
    }

    CreatePostingDtoAssembler withDescription(final String description) {
        this.description = description;
        return this;
    }
}
