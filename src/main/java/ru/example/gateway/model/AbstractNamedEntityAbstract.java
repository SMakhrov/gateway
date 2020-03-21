package ru.example.gateway.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractNamedEntityAbstract extends AbstractBaseEntity {
    @NotBlank
    @SafeHtml
    private String name;

    public AbstractNamedEntityAbstract(Long id, String name) {
        super(id);
        this.name = name;
    }
}
