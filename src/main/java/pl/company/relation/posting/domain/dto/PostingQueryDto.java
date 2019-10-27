package pl.company.relation.posting.domain.dto;

import lombok.Value;

import java.time.LocalDate;

@Value
public class PostingQueryDto {
    public final LocalDate date;
    public final String account;
    public final String description;

}
