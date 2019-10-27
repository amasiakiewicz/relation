package pl.company.relation.posting.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class PostingConfiguration {
    
    @Bean
    PostingFacade postingFacade(final PostingRepository postingRepository) {
        return new PostingFacade(postingRepository);
    }
    
    @Bean
    PostingQueryFacade postingQueryFacade(final PostingRepository postingRepository) {
        return new PostingQueryFacade(postingRepository);
    }
    
}
