package pl.company.relation.infrastructure;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.io.IOException;
import java.math.BigDecimal;

public class MoneyDeserializer extends JsonDeserializer<Money> {
    @Override
    public Money deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final JsonNode node = p.readValueAsTree();

        final String currencyStr = node.get("currency").asText();
        final CurrencyUnit currency = CurrencyUnit.of(currencyStr);

        final double amount = node.get("amount").asDouble();
        final BigDecimal bdValue = BigDecimal.valueOf(amount);
        
        return Money.of(currency, bdValue);
    }
}