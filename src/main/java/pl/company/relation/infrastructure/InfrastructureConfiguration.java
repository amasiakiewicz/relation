package pl.company.relation.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.joda.money.Money;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Clock;

import static pl.company.relation.RelationApplication.DEFAULT_ZONE_OFFSET;

@Configuration
class InfrastructureConfiguration {
    
    @Bean
    IllegalExceptionHandler illegalExceptionHandler() {
        return new IllegalExceptionHandler();
    }

    @Bean
    @Primary
    public ObjectMapper defaultObjectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();

        final SimpleModule moneyModule = new SimpleModule();
        moneyModule.addSerializer(Money.class, new MoneySerializer());
        moneyModule.addDeserializer(Money.class, new MoneyDeserializer());
        objectMapper.registerModule(moneyModule);

        final JavaTimeModule javaTimeModule = new JavaTimeModule();
        objectMapper.registerModule(javaTimeModule);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setDateFormat(new StdDateFormat());

        objectMapper.registerModule(new Jdk8Module());
        return objectMapper;
    }

    @Bean
    Clock clock(){
        return Clock.system(DEFAULT_ZONE_OFFSET);
    }
    
}
