package ru.example.gateway.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.example.gateway.HasId;

import javax.persistence.*;

@Access(AccessType.FIELD)
@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class AbstractBaseEntity implements HasId {
    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Long id;

    public AbstractBaseEntity(Long id) {
        this.id = id;
    }
}
