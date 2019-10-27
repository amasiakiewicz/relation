package pl.company.relation.infrastructure;

import lombok.Getter;

import javax.persistence.Access;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

import static javax.persistence.AccessType.FIELD;
import static pl.company.relation.RelationApplication.DEFAULT_ZONE_OFFSET;

@MappedSuperclass
@Access(FIELD)
public abstract class BaseEntity {
    @Id
    @Getter
    private final UUID id = UUID.randomUUID();

    @Version
    private Integer version;

    @Getter
    private final OffsetDateTime createdDateTime = OffsetDateTime.now(DEFAULT_ZONE_OFFSET);

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
