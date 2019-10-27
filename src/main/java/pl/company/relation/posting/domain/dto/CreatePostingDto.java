package pl.company.relation.posting.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatePostingDto {
    public static final int DESCRIPTION_MIN_LENGTH = 3;

    @NotNull
    @Past
    public LocalDate date;

    @NotNull
    public String account;

    @NotNull
    public Money amount;

    @NotBlank
    @Size(min = DESCRIPTION_MIN_LENGTH, message = "description.minLength")
    public String description;
    
}
