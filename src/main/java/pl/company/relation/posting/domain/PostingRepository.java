package pl.company.relation.posting.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

interface PostingRepository extends JpaRepository<Posting, UUID> {
    
    boolean existsByDescription(final String description);
    Optional<Posting> findByDescription(final String description);
    
}
