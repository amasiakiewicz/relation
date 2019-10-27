package pl.company.relation.posting.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.money.Money;
import pl.company.relation.infrastructure.BaseEntity;
import pl.company.relation.posting.domain.dto.CreatePostingDto;
import pl.company.relation.posting.domain.dto.PostingQueryDto;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

import static javax.persistence.AccessType.FIELD;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Access(FIELD)
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PACKAGE)
class Posting extends BaseEntity {

    private LocalDate date;
    
    private String account;

    @Columns(columns = {@Column(name = "amountCurrency"), @Column(name = "amountValue")})
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmountAndCurrency")
    private Money amount;
    
    private String description;

    static Posting create(final CreatePostingDto createPostingDto) {
        return new Posting(
                createPostingDto.date, createPostingDto.account, createPostingDto.amount, createPostingDto.description
        );
    }

    PostingQueryDto toQueryDto() {
        return new PostingQueryDto(date, account, description);
    }
    
}
